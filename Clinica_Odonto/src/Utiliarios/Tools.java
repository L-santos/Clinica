/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiliarios;

import Users.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author LucasPc
 */
public class Tools {

    public static String colunasFuncionario[] = {"CPF", "NOME", "TELEFONE"};
    public static String colunasMedico[] = {"Registro", "Nome", "Cpf", "Especialidade"};
    public static String colunasConsulta[] = {"Id", "Cliente", "Medico", "Data"};
    public static String colunasCliente[] = {"Cpf", "Nome", "Tel"};
    public static String colConsultasCliente[] = {"ID", "Data", "Medico"};
    private static final String meses[] = {"Janeiro", "Fevereiro", "Março",
        "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    private static Calendar date;

    public static boolean tryParse(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException nfe) {
            System.err.print(nfe);
            return false;
        }
    }

    public static boolean checkNubers(String x) {
        int length = x.length();
        int i = 0;
        if (length == 0) {
            return false;
        }
        do {
            char charAt = x.charAt(i);
            if (Character.isDigit(charAt) == false) {
                return false;
            }
            i++;
        } while (i < length);
        return true;
    }

    public static boolean checkOnlySpaces(String x) {
        int length = x.length();
        int count = 0;
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < x.length(); i++) {
            char charAt = x.charAt(i);
            if (Character.isSpaceChar(charAt) == true) {
                count++;
            }
        }
        if(count == length){
            return false;
        }
        return true;
    }

    public static boolean checkAlpha(String x) {
        int count = 0;
        int length = x.length();
        int i = 0;
        if (length == 0) {
            return false;
        }
        do {
            char charAt = x.charAt(i);
            if (Character.isAlphabetic(charAt) == true) {
                count++;
            }
            i++;
        } while (i < length);
        if (count != 0) {
            return true;
        } else {
            return false;
        }
    }

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

    public static ComboBoxModel getDiaModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        date = Calendar.getInstance();
        int day = date.get(Calendar.DAY_OF_MONTH);
        if (day < 31) {
            for (int i = 1; i <= 30; i++) {
                model.addElement(i);
            }
        } else {
            model.addElement(model);
        }
        return model;
    }

    public static ComboBoxModel getMesModel(int ano) {

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        date = Calendar.getInstance();
        int valor = 0;
        int get = date.get(Calendar.MONTH);
        if (valor == get) {
            for (int i = get - 1; i < meses.length; i++) {
                model.addElement(meses[i]);
            }
        } else {
            for (String s : meses) {
                model.addElement(s);
            }
        }
        return model;
    }

    public static ComboBoxModel getAnoModel() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        date = Calendar.getInstance();
        int get = date.get(Calendar.YEAR);
        for (int i = get; i <= get + 4; i++) {
            model.addElement(i);
        }
        return model;
    }

    public static void showMessage(int i) {
        switch (i) {
            case 1:
                JOptionPane.showMessageDialog(new JFrame(), "Salvo!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(new JFrame(),
                        "Ocorreu um erro!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                break;
        }
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
