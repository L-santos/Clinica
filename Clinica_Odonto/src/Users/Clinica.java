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

    public ArrayList<Cliente> Clientes = new ArrayList<>();
    ArrayList<Consulta> Consultas = new ArrayList<>();
    ArrayList<Medico> Medicos = new ArrayList<>();
    ArrayList<Funcionario> Funcionario = new ArrayList<>();

    @Override
    public boolean MarcarConsulta(String cpf, String registro, Date data) {
        if(this.PesquisarCliente(cpf)==true)
        {
            this.Consultas.add(new Consulta(cpf, registro, data));
            return true;
        }else{
            return false;
        }
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
            System.out.println(Consulta.getIdConsulta()+" - "+Consulta.getCpfCliente());
            System.out.println(Consulta.getRegistroMedico());
            System.out.println(Consulta.getData());
        }
        return 0;
    }

    @Override
    public int PesquisarConsulta(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean PesquisarCliente(String cpf) {
        for(Cliente Consulta : this.Clientes)
        {
            if(cpf.equals(Consulta.getCpf()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean AddCliente(Cliente cliente) {
        this.Clientes.add(cliente);
        
        return true;
    }

    @Override
    public boolean AddMedico(Medico medico) {
        this.Medicos.add(medico);
        return true;
    }

    @Override
    public boolean AddFuncionario(Funcionario funcionario) {
        
        this.Funcionario.add(funcionario);
        return true;
    }
}
