/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design;

import Persistence.Connect;
import Users.Clinica;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author LucasPc
 */
public class ClinicaF extends javax.swing.JFrame {

    /**
     * Creates new form Clinica
     */
    //LoginPanel login_panel
    AdmPanel adm_panel;
    ClientePanel cliente_panel;
    Map lista_panels;
    String pAnterior = "";

    public ClinicaF() {
        initComponents();
        String s = JOptionPane.showInputDialog("Senha MySQL root");
        if(s != null){
            Connect.setPass("root", s);
        }
        adm_panel = new AdmPanel();
        cliente_panel = new ClientePanel();
        lista_panels = new HashMap();
        adm_panel.setVisible(true);
        cliente_panel.setVisible(false);
        pAnterior = "AdmPanel";
        this.add(adm_panel);
        this.add(cliente_panel);
        lista_panels.put("AdmPanel", adm_panel);
        lista_panels.put("ClientePanel", cliente_panel);
        adm_panel.att();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jConnDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        txtPass = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        connErro = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btConect = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jClienteLogin = new javax.swing.JDialog();
        txtCpfCliente = new javax.swing.JTextField();
        jbLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jOpErrorCliente = new javax.swing.JOptionPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmAdmInterface = new javax.swing.JMenuItem();
        jmClienteInterface = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmBanco = new javax.swing.JMenuItem();

        jConnDialog.setTitle("Banco de Dados");
        jConnDialog.setMinimumSize(new java.awt.Dimension(400, 300));
        jConnDialog.setResizable(false);

        jLabel12.setText("Senha");

        connErro.setForeground(new java.awt.Color(255, 0, 0));

        jLabel14.setText("Usuario");

        btConect.setText("Continuar");
        btConect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectActionPerformed(evt);
            }
        });

        jLabel15.setText("Assistente de Conexão com o Banco de Dados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(connErro, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(txtPass)))
                    .addComponent(btConect))
                .addContainerGap(99, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(73, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(65, 65, 65)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(btConect)
                .addGap(29, 29, 29)
                .addComponent(connErro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(245, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jConnDialogLayout = new javax.swing.GroupLayout(jConnDialog.getContentPane());
        jConnDialog.getContentPane().setLayout(jConnDialogLayout);
        jConnDialogLayout.setHorizontalGroup(
            jConnDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(jConnDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jConnDialogLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jConnDialogLayout.setVerticalGroup(
            jConnDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(jConnDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jConnDialogLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jClienteLogin.setTitle("Login Cliente");
        jClienteLogin.setMinimumSize(new java.awt.Dimension(330, 135));

        jbLogin.setText("Entrar");
        jbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoginActionPerformed(evt);
            }
        });

        jLabel1.setText("Insira o seu CPF para continuar");

        javax.swing.GroupLayout jClienteLoginLayout = new javax.swing.GroupLayout(jClienteLogin.getContentPane());
        jClienteLogin.getContentPane().setLayout(jClienteLoginLayout);
        jClienteLoginLayout.setHorizontalGroup(
            jClienteLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jClienteLoginLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jClienteLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jClienteLoginLayout.createSequentialGroup()
                        .addComponent(txtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLogin)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jClienteLoginLayout.setVerticalGroup(
            jClienteLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jClienteLoginLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jClienteLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 255));
        setForeground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(462, 564));
        setPreferredSize(new java.awt.Dimension(462, 564));
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        jMenu1.setText("Interface");

        jmAdmInterface.setText("Administrador");
        jmAdmInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAdmInterfaceActionPerformed(evt);
            }
        });
        jMenu1.add(jmAdmInterface);

        jmClienteInterface.setText("Cliente");
        jmClienteInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClienteInterfaceActionPerformed(evt);
            }
        });
        jMenu1.add(jmClienteInterface);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opções");

        jmBanco.setText("Banco de Dados");
        jmBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmBancoActionPerformed(evt);
            }
        });
        jMenu2.add(jmBanco);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
     private void changePanel(String anterior, String atual) {
        JPanel panelAt = (JPanel) lista_panels.get(atual);
        panelAt.setVisible(true);
        JPanel panelAn = (JPanel) lista_panels.get(anterior);
        panelAn.setVisible(false);
    }
    private void jmAdmInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAdmInterfaceActionPerformed
        adm_panel.att();
        changePanel(pAnterior, "AdmPanel");
        pAnterior = "AdmPanel";
    }//GEN-LAST:event_jmAdmInterfaceActionPerformed

    private void jmClienteInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClienteInterfaceActionPerformed
        jClienteLogin.setVisible(true);
    }//GEN-LAST:event_jmClienteInterfaceActionPerformed

    private void btConectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConectActionPerformed
        Connect.setPass(this.txtUser.getText(), this.txtPass.getText());
        Connection conn = Connect.getConnection();
        if (conn == null) {
            connErro.setText("Erro na conexão com o banco de dados!");
        } else {
            this.jConnDialog.setVisible(false);
        }
    }//GEN-LAST:event_btConectActionPerformed

    private void jmBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBancoActionPerformed
        jConnDialog.setVisible(true);
    }//GEN-LAST:event_jmBancoActionPerformed

    private void jbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoginActionPerformed
        if (new Clinica().PesquisarCliente(txtCpfCliente.getText()) != null) {
            this.cliente_panel._cliente.setCpf(txtCpfCliente.getText());
            this.cliente_panel.atualizarClientePanel();
            changePanel(pAnterior, "ClientePanel");
            pAnterior = "ClientePanel";
            jClienteLogin.setVisible(false);
        } else {
            jOpErrorCliente.setVisible(true);
        }
    }//GEN-LAST:event_jbLoginActionPerformed

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
            java.util.logging.Logger.getLogger(ClinicaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClinicaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClinicaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClinicaF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClinicaF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConect;
    private javax.swing.JLabel connErro;
    private javax.swing.JDialog jClienteLogin;
    private javax.swing.JDialog jConnDialog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JOptionPane jOpErrorCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbLogin;
    private javax.swing.JMenuItem jmAdmInterface;
    private javax.swing.JMenuItem jmBanco;
    private javax.swing.JMenuItem jmClienteInterface;
    private javax.swing.JTextField txtCpfCliente;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

}
