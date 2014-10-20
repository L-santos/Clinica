/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author LucasPc
 */
public class Clinica implements ClinicaInterface {

    ArrayList<Cliente> Clientes = new ArrayList<>();
    ArrayList<Consulta> Consultas = new ArrayList<>();
    ArrayList<Medico> Medicos = new ArrayList<>();

    @Override
    public int MarcarConsulta(String cpf, Date data) {
        this.Consultas.add(new Consulta(cpf, data));
        return 0;
    }

    @Override
    public int AlterarConsulta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int CancelarConsulta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int MostrarConsultas() {
        for (Consulta Consulta : this.Consultas) {
            System.out.println(Consulta.getCpfCliente());
            System.out.println(Consulta.getData());
        }
        return 0;
    }

    @Override
    public int PesquisarConsulta(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int PesquisarUsuario(String termo, int parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int AddCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int AddMedico(Medico medico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int AddFuncionario(Funcionario funcionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
