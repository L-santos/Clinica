/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiliarios;

import Users.*;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author LucasPc
 */
public class DesignTools {

    public static String colunasFuncionario[] = {"CPF", "NOME", "TELEFONE"};
    public static String colunasMedico[] = {"Cpf", "Nome", "Registro", "Especialidade"};
    public static String colunasConsulta[] = {"Id", "Cliente", "Medico", "Data"};
    public static String[] colunasCliente = {"Cpf", "Nome", "Tel"};
    public static String colConsultasCliente[] = {"ID", "Data", "Medico"};
    
    public static DefaultComboBoxModel getMedEspModel() {

        //seta o combobox da consulta
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (Medico m : new Clinica().MostrarMedicos()) {
            model.addElement(m.getNome_M() + ", " + m.getStrEspecialidade());
        }
        return model;
    }

    public static ComboBoxModel getEspModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (String m : new Clinica().getEspecialidades()) {
            model.addElement(m);
        }
        return model;
    }

//    public static DefaultTableModel getConsultaModel(int parameter) {
//        /*
//         1 = registro + nome
//         2 = nome
//         */
//        DefaultTableModel model = new DefaultTableModel();
//        model.setColumnIdentifiers(Consulta.colunasConsulta);
//        if (parameter == 1) {
//            for (Consulta cs : new Clinica().MostrarConsultas()) {
//                model.addRow(new Object[]{cs.getIdConsulta(), cs.getCpfCliente(), 
//                    " "+cs.dadosMedico.getRegistro_M()+" ("+cs.dadosMedico.getNome_M()+")", 
//                    cs.getData()});
//            }
//        }
//        if (parameter == 2) {
//            for (Consulta cs : new Clinica().MostrarConsultas()) {
//                model.addRow(new Object[]{cs.getIdConsulta(), cs.getCpfCliente(), cs.dadosMedico.getNome_M(), cs.getData()});
//            }
//        }
//        
//        return model;
//    }
}