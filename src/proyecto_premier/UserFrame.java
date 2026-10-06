
package proyecto_premier;

import javax.swing.*;

public class UserFrame extends javax.swing.JFrame implements ThemeInterface{

    /** Instancia unica: el perfil se abre sobre el menu, sin ocultarlo. */
    private static UserFrame instancia;

    public static UserFrame obtener() {
        if (instancia == null || !instancia.isDisplayable()) {
            instancia = new UserFrame();
        }
        return instancia;
    }

    public UserFrame() {
        setTitle("Proyecto Premier - Perfil");
        initComponents();
        Tipografia.aplicar(this);
        aplicarTema();
        userBtn.setIcon(Iconos.cargar("/img/userIconBlanco.png", 150, 150));
        String usuario = Config.getUsuario();
        userNameLabel.setText(usuario);
        setLocationRelativeTo(null);
    }

    @Override
    public void aplicarTema() {
        getContentPane().setBackground(Config.getBackgroundColor());
        MainPanel.setBackground(Config.getBackgroundColor());
        nameField.setBackground(Config.getPanelColor());
        nameField.setForeground(Config.getContrastColor());
        nameField.setCaretColor(Config.getContrastColor());
        nameField.setBorder(javax.swing.BorderFactory.createLineBorder(Config.getBorderColor()));
        notaLabel.setForeground(Config.getSecondaryTextColor());
        escBtn.setBackground(Config.getPanelColor());
        escBtn.setForeground(Config.getContrastColor());
        escBtn.setBorder(javax.swing.BorderFactory.createLineBorder(Config.getBorderColor()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        userBtn = new javax.swing.JButton();
        userNameLabel = new javax.swing.JLabel();
        logOutBtn = new javax.swing.JButton();
        changeNameBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nameField = new javax.swing.JTextArea();
        escBtn = new javax.swing.JButton();
        notaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        MainPanel.setBackground(Paleta.BLANCO);

        jPanel2.setBackground(Paleta.AZUL_MARINO);

        userBtn.setAlignmentY(0.0F);
        userBtn.setBorderPainted(false);
        userBtn.setContentAreaFilled(false);
        userBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userBtn.setIconTextGap(0);
        userBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBtnActionPerformed(evt);
            }
        });

        userNameLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        userNameLabel.setForeground(Paleta.BLANCO);
        userNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userNameLabel.setText("username");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addComponent(userNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(userNameLabel)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        logOutBtn.setBackground(Paleta.ROJO_OSCURO);
        logOutBtn.setFont(new java.awt.Font("Swis721 Cn BT", 1, 18)); // NOI18N
        logOutBtn.setForeground(Paleta.BLANCO);
        logOutBtn.setText("Cerrar sesión");
        logOutBtn.setBorder(new javax.swing.border.LineBorder(Paleta.BORDE, 2, true));
        logOutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logOutBtn.setFocusable(false);
        logOutBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logOutBtn.setIconTextGap(0);
        logOutBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        changeNameBtn.setBackground(Paleta.AZUL_ACERO);
        changeNameBtn.setFont(new java.awt.Font("Swis721 Cn BT", 1, 18)); // NOI18N
        changeNameBtn.setForeground(Paleta.BLANCO);
        changeNameBtn.setText("Cambiar nombre");
        changeNameBtn.setBorder(new javax.swing.border.LineBorder(Paleta.BORDE, 2, true));
        changeNameBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changeNameBtn.setFocusable(false);
        changeNameBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        changeNameBtn.setIconTextGap(0);
        changeNameBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        changeNameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeNameBtnActionPerformed(evt);
            }
        });

        nameField.setColumns(20);
        nameField.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        nameField.setLineWrap(true);
        nameField.setRows(1);
        nameField.setAlignmentX(1.0F);
        nameField.setAlignmentY(1.0F);
        nameField.setBorder(javax.swing.BorderFactory.createLineBorder(Paleta.BORDE));
        jScrollPane1.setViewportView(nameField);

        escBtn.setFont(new java.awt.Font("Segoe UI Semilight", 1, 14)); // NOI18N
        escBtn.setText("Volver");
        escBtn.setBorder(javax.swing.BorderFactory.createLineBorder(Paleta.BORDE));
        escBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        escBtn.setFocusable(false);
        escBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escBtnActionPerformed(evt);
            }
        });

        notaLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        notaLabel.setText("Nota: el cambio se aplicará solo durante la sesión actual.");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changeNameBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(escBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(notaLabel)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(changeNameBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(notaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(escBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtnActionPerformed

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        this.dispose();
        // El menu queda abierto detras del perfil, asi que cerrar sesion
        // tambien tiene que cerrarlo: si no se follow usando la aplicacion
        // sin autenticarse.
        MainUI.cerrar();
        Config.setUsuario(null);
        LoginUI.obtener().setVisible(true);
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void changeNameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeNameBtnActionPerformed
        if(!"".equals(nameField.getText())) { 
            Config.setUsuario(nameField.getText());
            userNameLabel.setText(nameField.getText());
            nameField.setText("");
        }
    }//GEN-LAST:event_changeNameBtnActionPerformed

    private void escBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_escBtnActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton changeNameBtn;
    private javax.swing.JButton escBtn;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JTextArea nameField;
    private javax.swing.JLabel notaLabel;
    private javax.swing.JButton userBtn;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
