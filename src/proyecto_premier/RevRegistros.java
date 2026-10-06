
package proyecto_premier;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.*;
import java.text.NumberFormat;
import javax.swing.table.DefaultTableModel;

public class RevRegistros extends javax.swing.JFrame implements ThemeInterface{

    /** Instancia unica: evita apilar ventanas de historial. */
    private static RevRegistros instancia;

    public static RevRegistros obtener() {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new RevRegistros();
        }
        return instancia;
    }

    public RevRegistros() {
        setTitle("Proyecto Premier - Historial de registros");
        initComponents();
        Tipografia.aplicar(this);
        aplicarTema();
        cargarTabla();
        setLocationRelativeTo(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                MainUI.obtener().setVisible(true);
            }
        });
    }

    /** Cierra esta ventana y muestra el menu. */
    private void volverAlMenu() {
        this.dispose();
        MainUI.obtener().setVisible(true);
    }

    @Override
    public void aplicarTema() {
        getContentPane().setBackground(Config.getBackgroundColor());
        MainPanel.setBackground(Config.getBackgroundColor());
        tablaRegistros.setBackground(Config.getPanelColor());
        tablaRegistros.setForeground(Config.getContrastColor());
        tablaRegistros.setGridColor(Config.getGridColor());
        tablaRegistros.setBorder(javax.swing.BorderFactory.createLineBorder(Config.getBorderColor()));
        tablaRegistros.getTableHeader().setBackground(Paleta.AZUL_MARINO);
        tablaRegistros.getTableHeader().setForeground(Paleta.BLANCO);
        tablaRegistros.setSelectionBackground(Paleta.AZUL_MARINO);
        tablaRegistros.setSelectionForeground(Paleta.BLANCO);
        panelTabla.setBackground(Config.getBackgroundColor());
        scroll.getViewport().setBackground(Config.getPanelColor());
    }
    
    public void cargarTabla() {
    DefaultTableModel model = new DefaultTableModel(
        new Object[]{"ID", "Fecha", "Cuenta", "Monto"}, 0);

    tablaRegistros.setModel(model);

    // getConnection() es estatico. Con new Conexion() se ejecutaba de nuevo
    // todo el DDL de preparacion del esquema en cada carga de la tabla.
    String sql = "SELECT id, fecha, cuenta, monto FROM registros ORDER BY id DESC";

    try (Connection conexion = Conexion.getConnection();
         PreparedStatement st = conexion.prepareStatement(sql);
         ResultSet rs = st.executeQuery()) {

        // Formato argentino: 1.234,56
        NumberFormat formato = NumberFormat.getInstance(java.util.Locale.of("es", "AR"));
        while (rs.next()) {
            Object[] fila = new Object[4];
            fila[0] = rs.getInt("id");
            fila[1] = rs.getString("fecha");
            fila[2] = rs.getString("cuenta");
            // BigDecimal y no getInt: getInt trunca y ademas el monto ya es
            // DECIMAL(12,2), asi que 100.75 se perdia.
            BigDecimal monto = rs.getBigDecimal("monto");
            fila[3] = monto == null ? "" : formato.format(monto);

            model.addRow(fila);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
            "Error al cargar la tabla:\n" + e.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}

        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        panelTabla = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tablaRegistros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(Paleta.BLANCO);

        jPanel1.setBackground(Paleta.BLANCO);

        Header.setBackground(Paleta.AZUL_MARINO);

        titleLabel.setBackground(Paleta.AZUL_MARINO);
        titleLabel.setFont(new java.awt.Font("Swis721 BT", 1, 56)); // NOI18N
        titleLabel.setForeground(Paleta.BLANCO);
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Proyecto Premier");
        titleLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        titleLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleLabelMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 2, 24)); // NOI18N
        jLabel2.setForeground(Paleta.TEXTO_HEADER);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Historial de registros");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        MainPanel.setBackground(Paleta.BLANCO);
        MainPanel.setLayout(new java.awt.GridBagLayout());

        tablaRegistros.setBorder(javax.swing.BorderFactory.createLineBorder(Paleta.BORDE));
        tablaRegistros.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        tablaRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tablaRegistros.setFocusable(false);
        tablaRegistros.setGridColor(Paleta.GRIS_CLARO);
        tablaRegistros.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tablaRegistros.setRowHeight(35);
        tablaRegistros.setRowSelectionAllowed(false);
        tablaRegistros.setSurrendersFocusOnKeystroke(true);
        scroll.setViewportView(tablaRegistros);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        MainPanel.add(panelTabla, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void titleLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLabelMouseClicked
        volverAlMenu();
    }//GEN-LAST:event_titleLabelMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RevRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RevRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RevRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RevRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RevRegistros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tablaRegistros;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
