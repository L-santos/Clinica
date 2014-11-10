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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LucasPc
 */
public class Clinica implements ClinicaInterface {

    public ArrayList<Cliente> Clientes = new ArrayList<>();
    public ArrayList<Consulta> Consultas = new ArrayList<>();
    public ArrayList<Medico> Medicos = new ArrayList<>();
    public ArrayList<Funcionario> Funcionario = new ArrayList<>();

    @Override
    public boolean AlterarConsulta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean CancelarConsulta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Consulta> MostrarConsultas() {
        ArrayList<Consulta> arr = new ArrayList<>();
        Connection conn = Connect.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement("select *"
                + " from consulta as c, medico as m "
                + "where c.registroMedico = m.registro")) {
            Consulta temp;
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                temp = new Consulta();
                temp.setIdConsulta(rs.getInt("c.id"));
                temp.setCpfCliente(rs.getString("c.cpfCliente"));
                temp.dadosMedico.setRegistro_M(rs.getString("registroMedico"));
                temp.dadosMedico.setNome_M(rs.getString("m.nome"));
                temp.dadosMedico.setStrEspecialidade(rs.getString("m.especialidade"));
                temp.setData(rs.getDate("c.dataConsulta"));
                arr.add(temp);
            }

        } catch (SQLException e) {

        }

        return arr;
    }

    @Override
    public ArrayList<Consulta> PesquisarConsulta(String cpf) {
        ArrayList<Consulta> arr = new ArrayList<>();
        Connection conn = Connect.getConnection();
        String sql = "SELECT * FROM consulta as c, medico as m "
                + "WHERE c.cpfCliente = ? AND c.registroMedico = m.registro";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, cpf);
            Consulta temp;
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                temp = new Consulta();
                temp.setCpfCliente(rs.getString("c.cpfCliente"));
                temp.setIdConsulta(rs.getInt("c.id"));
                temp.dadosMedico.setRegistro_M(rs.getString("registroMedico"));
                temp.dadosMedico.setNome_M(rs.getString("m.nome"));
                temp.dadosMedico.setStrEspecialidade(rs.getString("m.especialidade"));
                temp.setData(rs.getDate("c.dataConsulta"));
                arr.add(temp);
            }
             conn.close();
        } catch (SQLException e) {

        }

        return arr;
    }

    @Override
    public boolean PesquisarCliente(String cpf) {
        Connection conn = Connect.getConnection();
        String sql = "select cpf from cliente";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String temp = rs.getString("cpf");
                if (cpf.equals(temp)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean AddCliente(Cliente cliente) {
        Connection conn = Connect.getConnection();
        String sql = "INSERT INTO cliente"
                + "(cpf, nome, telefone)"
                + "Values (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.execute();
            this.Clientes.add(cliente);
            stmt.close();
            conn.close();
        } catch (SQLException e) {

        }
        return true;
    }

    @Override
    public boolean MarcarConsulta(Consulta consulta) {
        Date myDate = new Date();
        // if (this.PesquisarCliente(consulta.getCpfCliente()) != null) {
        Connection conn = Connect.getConnection();
        String sql = "INSERT INTO consulta "
                + "(id, cpfCliente, registroMedico, dataConsulta)"
                + "Values (?, ? , ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, consulta.getIdConsulta());
            stmt.setString(2, consulta.getCpfCliente());
            stmt.setString(3, consulta.dadosMedico.getRegistro_M());
            stmt.setDate(4, new java.sql.Date(myDate.getTime()));
            stmt.execute();
            this.Consultas.add(consulta);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return true;
        /* else {
         return false;
         }*/
    }

    @Override
    public boolean AddMedico(Medico medico) {
        Connection conn = Connect.getConnection();
        String sql = "INSERT INTO medico"
                + "(cpf, nome, registro, especialidade)"
                + "Values (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, medico.getCpf_M());
            stmt.setString(2, medico.getNome_M());
            stmt.setString(3, medico.getRegistro_M());
            stmt.setInt(4, medico.getEsp_M());
            stmt.execute();
            this.Medicos.add(medico);
            stmt.close();
            conn.close();
        } catch (SQLException e) {

        }
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
        try (PreparedStatement stmt = conn.prepareStatement("select * from cliente");) {
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

    @Override
    public ArrayList<Medico> MostrarMedicos() {
        ArrayList<Medico> arr = new ArrayList<>();
        Connection conn = Connect.getConnection();
        //PreparedStatement stmt = null;
        try (PreparedStatement stmt = conn.prepareStatement("select m.cpf, m.nome, m.registro, e.nome "
                + "from medico as m, especialidade as e "
                + "where m.especialidade = e.id ");) {
            //stmt = conn.prepareStatement("select * from cliente");
            Medico temp;
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                temp = new Medico();
                temp.setCpf_M(rs.getString("m.cpf"));
                temp.setNome_M(rs.getString("m.nome"));
                temp.setRegistro_M(rs.getString("m.registro"));
                temp.setStrEspecialidade(rs.getString("e.nome"));
                arr.add(temp);
            }
        } catch (SQLException e) {
            return null;
        }
        return arr;
    }

    @Override
    public ArrayList<Funcionario> MostrarFuncionarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<String> getEspecialidades() {
        ArrayList<String> esp = new ArrayList<>();
        Connection conn = Connect.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement("select nome from especialidade");) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                esp.add(rs.getString("nome"));
            }

        } catch (SQLException e) {

        }
        return esp;
    }
}
