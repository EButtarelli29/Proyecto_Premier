# Proyecto Premier

Sistema de Gestión Financiera (FMS) para administrar el dinero en movimiento de una
empresa. Aplicación de escritorio en Java con Swing y MySQL.

Desarrollado por: Emiliano Buttarelli Sarmiento, Fernando Faccini, Ramiro Miraglia y
Gabriel Vázquez.

> Esto es un proyecto escolar, no busca ser una fuente de remuneración.

## Funcionalidades

- Ingreso de registros con fecha, cuenta y monto.
- Historial de registros en tabla, del más reciente al más antiguo.
- Registro e inicio de sesión de usuarios.
- Cambio del nombre de usuario visible en la sesión y cierre de sesión.
- Tema claro y oscuro.

## Requisitos

- Java 21 o superior.
- MySQL 8.0 en ejecución en `localhost:3306`.

## Dependencias

Los archivos `.jar` no se versionan en el repositorio. Descargalos dentro de
`sqlConnector/`:

| Dependencia | Archivo esperado |
| --- | --- |
| MySQL Connector/J 9.5.0 | `sqlConnector/mysql-connector-j-9.5.0/mysql-connector-j-9.5.0.jar` |
| jBCrypt 0.4 | `sqlConnector/jbcrypt-0.4.jar` |

## Compilación

Desde la raíz del proyecto, en PowerShell:

```powershell
$env:CLASSPATH = "sqlConnector\mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar;sqlConnector\jbcrypt-0.4.jar"
javac -d build\classes -sourcepath src src\proyecto_premier\*.java
Copy-Item src\img\*.png build\classes\img\ -Force
```

El `Copy-Item` es necesario: los iconos se cargan como recurso del classpath y
`javac` no copia imágenes. Sin ese paso la aplicación abre pero los botones quedan
sin icono. NetBeans hace esta copia automáticamente al ejecutar.

## Ejecución

```powershell
$env:CLASSPATH = "build\classes;sqlConnector\mysql-connector-j-9.5.0\mysql-connector-j-9.5.0.jar;sqlConnector\jbcrypt-0.4.jar"
java proyecto_premier.Proyecto_Premier
```

## Base de datos

La base `PremierDataBase` y las tablas `users` y `registros` se crean solas al
iniciar, y el esquema se prepara una sola vez por proceso.

| Tabla | Columnas |
| --- | --- |
| `users` | `id`, `nombre`, `password`, `email` |
| `registros` | `id`, `fecha`, `cuenta`, `monto DECIMAL(12,2)` |

La conexión está fija en `Conexion`: usuario `root` sin contraseña contra
`localhost:3306`. **No hay pantalla de configuración de conexión**, hay que
cambiar esas constantes si tu MySQL usa otras credenciales.

### Migración de la columna `monto`

`monto` es `DECIMAL(12,2)` y no `INT`. Con `INT` el motor redondeaba solo al
guardar: `100.75` quedaba como `101`. Instalaciones anteriores con la columna
`INT` se actualizan solas al arrancar: `Conexion` consulta `information_schema`
y, solo si el tipo no es el esperado, ejecuta el `ALTER`.

## Seguridad

Las contraseñas se guardan con **bcrypt** (`jBCrypt 0.4`, coste 12) a través de
`HashUtil`. Ninguna contraseña se almacena en texto plano.

Las consultas usan `PreparedStatement` en todos los casos, sin concatenar datos
del usuario en el SQL.

## Validaciones

Centralizadas en `Validaciones` y aplicadas en los tres formularios:

| Formulario | Reglas |
| --- | --- |
| Registro | Usuario de más de 2 caracteres, contraseña de más de 8, email con formato válido. |
| Log-in | Usuario válido y contraseña no vacía. |
| Ingreso de registros | Cuenta no vacía, fecha en formato `dd-MM-yyyy`, monto numérico con hasta 2 decimales. |

El monto acepta coma o punto como separador decimal (`100,75` y `100.75`), y usa
`BigDecimal` en toda la capa de datos: `double` no representa los decimales en
base 2, así que `0.1 + 0.2` no da `0.3` y las sumas acumularían error.

## Notas de diseño

**Navegación sin fuga de ventanas.** Cada ventana expone un `obtener()` que
devuelve una única instancia, y las ventanas hijas vuelven al menú con
`volverAlMenu()` en lugar de crear un menú nuevo. Antes se ocultaba la ventana
anterior con `setVisible(false)` y se creaba otra con `new MainUI()`, lo que
dejaba los menús anteriores retenidos por AWT para siempre. Verificado con
`WeakReference`: el patrón anterior liberaba la mitad de las ventanas creadas y
el actual libera todas menos el menú.

Las ventanas que se abren sobre otra usan `DISPOSE_ON_CLOSE` y devuelven el
control a la ventana de la que salieron al cerrarse con la X. Con
`EXIT_ON_CLOSE`, cerrar el perfil o la configuración mataba la aplicación
entera.

**Colores, tipografías e iconos centralizados.** `Paleta` tiene todos los
colores, `Config` los resuelve según el tema activo, `Tipografia` reemplaza las
fuentes no instaladas conservando tamaño y estilo, e `Iconos` carga los PNG
devolviendo `null` si faltan en lugar de lanzar una excepción. Un recurso
ausente no puede impedir que la aplicación abra.

**Los `.form` van junto con los `.java`.** NetBeans guarda en el `.form` los
colores, las fuentes y la geometría, y regenera el `.java` desde ahí. Cualquier
cambio de estilo hay que escribirlo en los dos archivos.

## Limitaciones conocidas

Quedan pendientes, a propósito y no por descuido:

- Los registros no están asociados a un usuario: la tabla `registros` no tiene
  columna de usuario, así que cualquier usuario ve todos los registros y no hay
  filtro por usuario.
- La tabla del historial no se puede ordenar haciendo clic en las columnas.
- El cambio de nombre de usuario solo cambia la etiqueta de la sesión actual:
  no se ejecuta ningún `UPDATE` sobre `users`, así que al volver a iniciar
  sesión aparece el nombre original.
- Los usuarios creados antes de pasar a bcrypt tienen el hash SHA-256 en la base
  y no pueden iniciar sesión. No hay migración para eso.
- La conexión a MySQL está fija en el código, sin variables de entorno.
- Sin pool de conexiones: cada operación abre y cierra una conexión.
- Todas las ventanas generadas por NetBeans repiten el bloque `initComponents()`
  con su `main()`, que no se usa porque la entrada real es `Proyecto_Premier`.
