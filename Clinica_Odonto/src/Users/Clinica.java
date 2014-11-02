/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Persistence.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        if (this.PesquisarCliente(cpf) == true) {
            this.Consultas.add(new Consulta(cpf, registro, data));
            return true;
        } else {
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
            System.out.println(Consulta.getIdConsulta() + " - " + Consulta.getCpfCliente());
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
        for (Cliente Consulta : this.Clientes) {
            if (cpf.equals(Consulta.getCpf())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean AddCliente(Cliente cliente) {
        this.Clientes.add(cliente);
        Connection conn = Connect.getConnection();
        String sql = "INSERT INTO cliente"
                + "(cpf, nome, telefone)"
                + "Values (?, ?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (SQLException e) {

        }
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

    @Override
    public ArrayList<Cliente> MostrarClientes() {
        ArrayList<Cliente> arr = new ArrayList<>();
        Connection conn = Connect.getConnection();
        //PreparedStatement stmt = null;
        try(PreparedStatement stmt = conn.prepareStatement("select * from cliente");) {
            //stmt = conn.prepareStatement("select * from cliente");
            Cliente temp;
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                temp = new Cliente();
                temp.setCpf(rs.getString("cpf"));
                temp.setNome(rs.getString("nome"));
                temp.setTelefone(rs.getString("telefone"));
                arr.add(temp);
            }
        } catch (SQLException e) {

        }
        return arr;
    }
}
