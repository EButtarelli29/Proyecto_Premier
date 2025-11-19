
package proyecto_premier;

import java.awt.Image;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class IngRegistros extends javax.swing.JFrame implements ThemeInterface{

    public IngRegistros() {
        setTitle("Proyecto Premier - Ingreso de registros");
        initComponents();
        aplicarTema();
        setLocationRelativeTo(null);
    }
    
    @Override
    public void aplicarTema() {
        getContentPane().setBackground(Config.getBackgroundColor());
        MainPanel.setBackground(Config.getBackgroundColor());
        panelForm.setBackground(Config.getBackgroundColor());
        campoFecha.setBackground(Config.getBackgroundColor());
        campoCuenta.setBackground(Config.getBackgroundColor());
        campoMonto.setBackground(Config.getBackgroundColor());
        campoFecha.setForeground(Config.getContrastColor());
        campoCuenta.setForeground(Config.getContrastColor());
        campoMonto.setForeground(Config.getContrastColor());
        campoFecha.setCaretColor(Config.getContrastColor());
        campoCuenta.setCaretColor(Config.getContrastColor());
        campoMonto.setCaretColor(Config.getContrastColor());
        fechaLabel.setForeground(Config.getContrastColor());
        fechaLabel2.setForeground(Config.getContrastColor());
        cuentaLabel.setForeground(Config.getContrastColor());
        montoLabel.setForeground(Config.getContrastColor());
        montoLabel2.setForeground(Config.getContrastColor());
    }

    public Icon setIcono(String url, JButton boton) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        
        int ancho = boton.getWidth();
        int alto = boton.getHeight();
        
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        
        return icono;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelForm = new javax.swing.JPanel();
        campoFecha = new javax.swing.JTextField();
        fechaLabel = new javax.swing.JLabel();
        cuentaLabel = new javax.swing.JLabel();
        campoMonto = new javax.swing.JTextField();
        montoLabel = new javax.swing.JLabel();
        campoCuenta = new javax.swing.JTextField();
        montoLabel2 = new javax.swing.JLabel();
        fechaLabel2 = new javax.swing.JLabel();
        ingRegBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Header.setBackground(new java.awt.Color(102, 102, 255));

        titleLabel.setBackground(new java.awt.Color(102, 0, 0));
        titleLabel.setFont(new java.awt.Font("Swis721 BT", 1, 56)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Proyecto Premier");
        titleLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        titleLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleLabelMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingreso de registros");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
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

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        MainPanel.add(jPanel3, new java.awt.GridBagConstraints());

        panelForm.setBackground(new java.awt.Color(255, 255, 255));
        panelForm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        panelForm.setPreferredSize(new java.awt.Dimension(470, 490));

        campoFecha.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        campoFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        fechaLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        fechaLabel.setText("Fecha");

        cuentaLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        cuentaLabel.setText("Cuenta");

        campoMonto.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        campoMonto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        montoLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        montoLabel.setText("Monto registrado (ARS)");

        campoCuenta.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        campoCuenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        montoLabel2.setBackground(new java.awt.Color(204, 204, 204));
        montoLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        montoLabel2.setText("Utilizar símbolos \"+\" o \"-\" para indicar la dirección de la transferencia");

        fechaLabel2.setBackground(new java.awt.Color(204, 204, 204));
        fechaLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        fechaLabel2.setText("Formato \"dd-MM-yyyy\"");

        ingRegBtn.setBackground(new java.awt.Color(51, 204, 0));
        ingRegBtn.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        ingRegBtn.setForeground(new java.awt.Color(255, 255, 255));
        ingRegBtn.setText("Registrar");
        ingRegBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ingRegBtn.setFocusable(false);
        ingRegBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingRegBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(255, 0, 0));
        cancelBtn.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setText("Cancelar");
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.setFocusable(false);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormLayout.createSequentialGroup()
                        .addComponent(fechaLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormLayout.createSequentialGroup()
                        .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormLayout.createSequentialGroup()
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaLabel)
                                    .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoCuenta)
                                    .addComponent(cuentaLabel)))
                            .addComponent(campoMonto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormLayout.createSequentialGroup()
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(montoLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(montoLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelFormLayout.createSequentialGroup()
                                .addComponent(ingRegBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47))))
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaLabel)
                    .addComponent(cuentaLabel))
                .addGap(18, 18, 18)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(fechaLabel2)
                .addGap(26, 26, 26)
                .addComponent(montoLabel)
                .addGap(18, 18, 18)
                .addComponent(campoMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(montoLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingRegBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        MainPanel.add(panelForm, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void titleLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleLabelMouseClicked
        this.dispose();
        new MainUI().setVisible(true);
    }//GEN-LAST:event_titleLabelMouseClicked

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
        new MainUI().setVisible(true);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void ingRegBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingRegBtnActionPerformed
        String fecha = campoFecha.getText();
        String cuenta = campoCuenta.getText();
        int monto = Integer.parseInt(campoMonto.getText());

        IngRegistrosCheck ing = new IngRegistrosCheck();
        if (ing.ingresarRegistro(fecha, cuenta, monto)) {
            JOptionPane.showMessageDialog(this, "Registro exitoso.");
            this.dispose();
            new MainUI().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Datos Incorrectos.");
        }
    }//GEN-LAST:event_ingRegBtnActionPerformed

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
            java.util.logging.Logger.getLogger(IngRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngRegistros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Header;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JTextField campoCuenta;
    private javax.swing.JTextField campoFecha;
    private javax.swing.JTextField campoMonto;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel cuentaLabel;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel fechaLabel2;
    private javax.swing.JButton ingRegBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel montoLabel;
    private javax.swing.JLabel montoLabel2;
    private javax.swing.JPanel panelForm;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
