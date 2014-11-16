/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design;

import Users.Cliente;
import Users.Clinica;
import Users.Consulta;
import Utiliarios.Tools;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LucasPc
 */
public class ClientePanel extends javax.swing.JPanel {

    Cliente _cliente;

    /**
     * Creates new form ClientePanel
     */
    public ClientePanel() {
        initComponents();
        _cliente = new Cliente();
        atualizarClientePanel();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jConsultaDialog = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jBtMarcarConsulta = new javax.swing.JButton();
        cbSetRegMed = new javax.swing.JComboBox();
        jLabel = new javax.swing.JLabel();
        jlCpfCliente = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jCBDia = new javax.swing.JComboBox();
        jCBMes = new javax.swing.JComboBox();
        jCBAno = new javax.swing.JComboBox();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMClienteDelConsulta = new javax.swing.JMenuItem();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        ConsultasPanel1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jBtAddConsulta1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbConsulta1 = new javax.swing.JTable();

        jConsultaDialog.setTitle("Nova Consulta");
        jConsultaDialog.setMinimumSize(new java.awt.Dimension(334, 194));
        jConsultaDialog.setResizable(false);
        jConsultaDialog.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jConsultaDialogComponentShown(evt);
            }
        });

        jLabel2.setText("Data");

        jBtMarcarConsulta.setText("Adicionar");
        jBtMarcarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtMarcarConsultaActionPerformed(evt);
            }
        });

        cbSetRegMed.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel.setText("Médico");

        jToolBar1.setRollover(true);

        javax.swing.GroupLayout jConsultaDialogLayout = new javax.swing.GroupLayout(jConsultaDialog.getContentPane());
        jConsultaDialog.getContentPane().setLayout(jConsultaDialogLayout);
        jConsultaDialogLayout.setHorizontalGroup(
            jConsultaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jConsultaDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jConsultaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jConsultaDialogLayout.createSequentialGroup()
                        .addGroup(jConsultaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel))
                        .addGap(55, 55, 55)
                        .addGroup(jConsultaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbSetRegMed, 0, 182, Short.MAX_VALUE)
                            .addGroup(jConsultaDialogLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(jlCpfCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jBtMarcarConsulta))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jConsultaDialogLayout.setVerticalGroup(
            jConsultaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jConsultaDialogLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jlCpfCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jConsultaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jConsultaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel)
                    .addComponent(cbSetRegMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBtMarcarConsulta)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jCBDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11", " " }));

        jCBMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCBAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMClienteDelConsulta.setText("Cancelar");
        jMClienteDelConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMClienteDelConsultaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMClienteDelConsulta);

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setMinimumSize(new java.awt.Dimension(462, 564));
        setPreferredSize(new java.awt.Dimension(462, 564));

        jTabbedPane2.setBackground(java.awt.SystemColor.window);
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(442, 542));

        ConsultasPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jBtAddConsulta1.setText("Adicionar Consulta");
        jBtAddConsulta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtAddConsulta1ActionPerformed(evt);
            }
        });

        tbConsulta1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbConsulta1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane5.setViewportView(tbConsulta1);

        javax.swing.GroupLayout ConsultasPanel1Layout = new javax.swing.GroupLayout(ConsultasPanel1);
        ConsultasPanel1.setLayout(ConsultasPanel1Layout);
        ConsultasPanel1Layout.setHorizontalGroup(
            ConsultasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultasPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConsultasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                    .addGroup(ConsultasPanel1Layout.createSequentialGroup()
                        .addComponent(jBtAddConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator3))
                .addContainerGap())
        );
        ConsultasPanel1Layout.setVerticalGroup(
            ConsultasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultasPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtAddConsulta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Consultas", ConsultasPanel1);

        add(jTabbedPane2);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtAddConsulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtAddConsulta1ActionPerformed
        this.jConsultaDialog.setVisible(true);
    }//GEN-LAST:event_jBtAddConsulta1ActionPerformed
    public void atualizarClientePanel(){
        this.jlCpfCliente.setText(_cliente.getCpf());
        this.cbSetRegMed.setModel(Tools.getMedEspModel());
        attTbConsulta1();
    }
    private void jBtMarcarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtMarcarConsultaActionPerformed
        Calendar d = Calendar.getInstance();
        int reg = cbSetRegMed.getSelectedIndex();
        d.set((int)jCBAno.getSelectedItem() , jCBMes.getSelectedIndex(), jCBDia.getSelectedIndex()+1);
        if (new Clinica().MarcarConsulta(new Consulta(_cliente.getCpf(), new Clinica().MostrarMedicos().get(reg).getRegistro_M(), d))) {
            this.jConsultaDialog.setVisible(false);
            Tools.showMessage(1);
        }else{
            Tools.showMessage(2);
        }
        attTbConsulta1();
    }//GEN-LAST:event_jBtMarcarConsultaActionPerformed

    private void jConsultaDialogComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jConsultaDialogComponentShown
        this.jCBDia.setModel(Tools.getDiaModel());
        this.jCBAno.setModel(Tools.getAnoModel());
        this.jCBMes.setModel(Tools.getMesModel(0));
        this.jToolBar1.add(this.jCBDia);
        this.jToolBar1.add(this.jCBMes);
        this.jToolBar1.add(this.jCBAno);
    }//GEN-LAST:event_jConsultaDialogComponentShown

    private void jMClienteDelConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMClienteDelConsultaActionPerformed
        JTable table = (JTable) this.jPopupMenu1.getInvoker();
        if (table.getSelectedRow() != -1) {
            int n = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja Cancelar esta consulta?",
                    "Excluir",
                    JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                String valueAt = table.getValueAt(table.getSelectedRow(), 0).toString();
                _cliente.deletarConsulta(valueAt);
            }
            attTbConsulta1();
        }
    }//GEN-LAST:event_jMClienteDelConsultaActionPerformed

    //Atualiza a tabela consulta
    void attTbConsulta1() {
        DefaultTableModel model = new DefaultTableModel();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
        model.setColumnIdentifiers(Cliente.getColConsultasCliente());
        _cliente.consultas = _cliente.getConsultas();
       
        for (Consulta consulta : _cliente.consultas) {
            model.addRow(new Object[]{consulta.getIdConsulta(), formataData.format(consulta.getData().getTime()), consulta.dadosMedico.getNome_M()});
        }
        this.tbConsulta1.setModel(model);
        this.tbConsulta1.setFillsViewportHeight(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ConsultasPanel1;
    private javax.swing.JComboBox cbSetRegMed;
    private javax.swing.JButton jBtAddConsulta1;
    private javax.swing.JButton jBtMarcarConsulta;
    private javax.swing.JComboBox jCBAno;
    private javax.swing.JComboBox jCBDia;
    private javax.swing.JComboBox jCBMes;
    private javax.swing.JDialog jConsultaDialog;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMClienteDelConsulta;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel jlCpfCliente;
    private javax.swing.JTable tbConsulta1;
    // End of variables declaration//GEN-END:variables
}
