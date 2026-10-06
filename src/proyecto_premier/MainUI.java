
package proyecto_premier;
import javax.swing.*;

public class MainUI extends javax.swing.JFrame implements ThemeInterface{

    /**
     * Unica instancia del menu.
     *
     * Antes cada ventana hacia new MainUI() al volver, y como las ventanas
     * anteriores solo se ocultaban con setVisible(false) en vez de liberarse
     * con dispose(), cada ida y vuelta al menu dejaba una ventana vieja
     * registrada en AWT. Medido: 8 ida y vuelta acumulaban 15 ventanas con
     * una sola visible. Con una instancia reutilizada la cantidad queda
     * acotada a una.
     */
    private static MainUI instancia;

    /**
     * Devuelve el menu, creandolo solo si hace falta.
     * Reutilizar la misma instancia es lo que evita la fuga de ventanas.
     */
    public static MainUI obtener() {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new MainUI();
        }
        return instancia;
    }

    /**
     * Cierra el menu si esta abierto. Se usa al cerrar sesion: antes el menu
     * quedaba visible detras del login y se podia seguir usando la aplicacion
     * sin haber vuelto a autenticarse.
     */
    public static void cerrar() {
        if (instancia != null && instancia.isDisplayable()) {
            instancia.dispose();
        }
    }

    public MainUI() {
        setTitle("Proyecto Premier - Menú Principal");
        initComponents();
        Tipografia.aplicar(this);
        aplicarTema();
        userBtn.setIcon(Iconos.cargar("/img/userIconBlanco.png", 50, 50));
        configBtn.setIcon(Iconos.cargar("/img/configIconBlanco.png", 50, 50));
        setLocationRelativeTo(null);
    }
    
    @Override
    public void aplicarTema() {
        getContentPane().setBackground(Config.getBackgroundColor());
        MainPanel.setBackground(Config.getBackgroundColor());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        configBtn = new javax.swing.JButton();
        userBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ingRegBtn = new javax.swing.JButton();
        revRegBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(Paleta.BLANCO);

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

        configBtn.setBorderPainted(false);
        configBtn.setContentAreaFilled(false);
        configBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        configBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configBtnActionPerformed(evt);
            }
        });

        userBtn.setAlignmentY(0.0F);
        userBtn.setBorderPainted(false);
        userBtn.setContentAreaFilled(false);
        userBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userBtn.setIconTextGap(0);
        userBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 2, 24)); // NOI18N
        jLabel2.setForeground(Paleta.TEXTO_HEADER);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Menú principal");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(configBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(configBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        ingRegBtn.setBackground(Paleta.AZUL_ACERO);
        ingRegBtn.setFont(new java.awt.Font("Swis721 Cn BT", 1, 24)); // NOI18N
        ingRegBtn.setForeground(Paleta.BLANCO);
        ingRegBtn.setText("Ingresar registros");
        ingRegBtn.setBorder(new javax.swing.border.LineBorder(Paleta.BORDE, 2, true));
        ingRegBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ingRegBtn.setFocusable(false);
        ingRegBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ingRegBtn.setIconTextGap(0);
        ingRegBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        ingRegBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingRegBtnActionPerformed(evt);
            }
        });
        jPanel1.add(ingRegBtn);
        ingRegBtn.setBounds(100, 0, 400, 64);

        revRegBtn.setBackground(Paleta.AZUL_ACERO);
        revRegBtn.setFont(new java.awt.Font("Swis721 Cn BT", 1, 24)); // NOI18N
        revRegBtn.setForeground(Paleta.BLANCO);
        revRegBtn.setText("Revisar registros");
        revRegBtn.setBorder(new javax.swing.border.LineBorder(Paleta.BORDE, 2, true));
        revRegBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        revRegBtn.setFocusable(false);
        revRegBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revRegBtnActionPerformed(evt);
            }
        });
        jPanel1.add(revRegBtn);
        revRegBtn.setBounds(100, 88, 400, 64);

        exitBtn.setBackground(Paleta.ROJO_OSCURO);
        exitBtn.setFont(new java.awt.Font("Swis721 Cn BT", 1, 24)); // NOI18N
        exitBtn.setForeground(Paleta.BLANCO);
        exitBtn.setText("Salir");
        exitBtn.setBorder(new javax.swing.border.LineBorder(Paleta.BORDE, 2, true));
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.setFocusable(false);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(exitBtn);
        exitBtn.setBounds(100, 176, 400, 64);

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configBtnActionPerformed
        ConfigFrame.obtener().setVisible(true);
    }//GEN-LAST:event_configBtnActionPerformed

    private void userBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBtnActionPerformed
        // obtener() en vez de new: antes cada clic abria otra ventana de perfil.
        UserFrame.obtener().setVisible(true);
    }//GEN-LAST:event_userBtnActionPerformed

    private void ingRegBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingRegBtnActionPerformed
        this.setVisible(false);
        IngRegistros.obtener().setVisible(true);
    }//GEN-LAST:event_ingRegBtnActionPerformed

    private void revRegBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revRegBtnActionPerformed
        this.setVisible(false);
        RevRegistros.obtener().setVisible(true);
    }//GEN-LAST:event_revRegBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void titleLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLabelMouseClicked
        // Antes creaba otro MainUI, con lo cual se podian apilar menus
        // identicos. Ahora solo se trae al frente el que ya existe.
        this.toFront();
    }//GEN-LAST:event_titleLabelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton configBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton ingRegBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton revRegBtn;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton userBtn;
    // End of variables declaration//GEN-END:variables
}
