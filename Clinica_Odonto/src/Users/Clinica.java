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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LucasPc
 */
public class Clinica {

    public ArrayList<Cliente> Clientes = new ArrayList<>();
    public ArrayList<Consulta> Consultas = new ArrayList<>();
    public ArrayList<Medico> Medicos = new ArrayList<>();
    public ArrayList<Funcionario> Funcionario = new ArrayList<>();

    public boolean AlterarConsulta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean CancelarConsulta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("c.dataConsulta"));
                temp.setIdConsulta(rs.getInt("c.id"));
                temp.setCpfCliente(rs.getString("c.cpfCliente"));
                temp.dadosMedico.setRegistro_M(rs.getString("registroMedico"));
                temp.dadosMedico.setNome_M(rs.getString("m.nome"));
                temp.dadosMedico.setStrEspecialidade(rs.getString("m.especialidade"));
                temp.setData(cal);
                arr.add(temp);
            }
        } catch (SQLException e) {
            System.err.print(e);
        }

        return arr;
    }

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
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("c.dataConsulta"));
                temp = new Consulta();
                temp.setCpfCliente(rs.getString("c.cpfCliente"));
                temp.setIdConsulta(rs.getInt("c.id"));
                temp.dadosMedico.setRegistro_M(rs.getString("registroMedico"));
                temp.dadosMedico.setNome_M(rs.getString("m.nome"));
                temp.dadosMedico.setStrEspecialidade(rs.getString("m.especialidade"));
                temp.setData(cal);
                arr.add(temp);
            }
            conn.close();
        } catch (SQLException e) {

        }

        return arr;
    }

    public ArrayList<Consulta> PesquisarConsulta(int par, String key) {

        ArrayList<Consulta> arr = new ArrayList<>();
        Connection conn = Connect.getConnection();
        String sql = "SELECT * FROM consulta as c, medico as m "
                + "WHERE c.registroMedico = m.registro";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            //stmt.setString(1, cpf);
            Consulta temp;
            ResultSet rs = stmt.executeQuery();
            String str_temp = "";
            //int int_temp = 0;
            while (rs.next()) {
                if (par == 0) {
                    str_temp = "" + rs.getInt("id");
                } else if (par == 1) {
                    str_temp = rs.getString("cpfCliente");
                } else if (par == 2) {
                    str_temp = rs.getString("registroMedico");
                }
                if (str_temp.equalsIgnoreCase(key)) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(rs.getDate("c.dataConsulta"));
                    temp = new Consulta();
                    temp.setCpfCliente(rs.getString("c.cpfCliente"));
                    temp.setIdConsulta(rs.getInt("c.id"));
                    temp.dadosMedico.setRegistro_M(rs.getString("registroMedico"));
                    temp.dadosMedico.setNome_M(rs.getString("m.nome"));
                    temp.dadosMedico.setStrEspecialidade(rs.getString("m.especialidade"));
                    temp.setData(cal);
                    arr.add(temp);
                }
            }
            conn.close();
            
        return arr;
        } catch (SQLException e) {
                System.err.print(e);
        }
        return null;
    }

    /*public boolean PesquisarCliente(String cpf) {
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
     }*/
    public Cliente PesquisarCliente(int par, String key) {
        /* par =>> 0 - pesquisa CPF
         1 - pesquisa Tele
         */

        Connection conn = Connect.getConnection();
        String sql = "select * from cliente";
        /*if(par == 0){
         sql = "select * from cliente where cpf = ?";
         }else if(par == 1){
         sql = "select * from cliente where telefone = ?";

         }*/

        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            //stmt.setString(1, key);
            ResultSet rs = stmt.executeQuery();
            Cliente cliente = new Cliente();
            while (rs.next()) {
                String temp = "";
                if (par == 0) {
                    temp = rs.getString("cpf");
                } else if (par == 1) {
                    temp = rs.getString("telefone");
                }
                if (key.equals(temp)) {
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setTelefone(rs.getString("telefone"));
                    return cliente;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

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
            System.err.print(e);
            return false;
        }
        return true;
    }

    public boolean MarcarConsulta(Consulta consulta) {
        Connection conn = Connect.getConnection();

        String sql = "INSERT INTO consulta "
                + "(id, cpfCliente, registroMedico, dataConsulta)"
                + "Values (?, ? , ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            long x = consulta.getData().getTimeInMillis();
            stmt.setString(2, consulta.getCpfCliente());
            stmt.setInt(1, consulta.getIdConsulta());
            stmt.setString(3, consulta.dadosMedico.getRegistro_M());
            stmt.setDate(4, new java.sql.Date(x));
            stmt.execute();
            this.Consultas.add(consulta);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
        return true;
    }

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

    public boolean AddFuncionario(Funcionario funcionario) {

        this.Funcionario.add(funcionario);
        return true;
    }

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

    public boolean EditarClienteData(String index, String item, String value) {

        String sql = null;
        item = item.toLowerCase();
        switch (item) {
            case "cpf":
                sql = "UPDATE cliente SET cpf = ?"
                        + " Where cpf = ?";
                break;
            case "nome":
                sql = "UPDATE cliente SET nome = ?"
                        + " Where cpf = ?";
                break;
            case "tel":
                sql = "UPDATE cliente SET telefone = ?"
                        + " Where cpf = ?";
                break;

        }
        //String cpf = this.Clientes.get(index).getCpf();
        Connection conn = Connect.getConnection();
        //String sql = "UPDATE cliente SET (?) = (?)"
        //+" Where cpf = (?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            //stmt.setString(1, item);
            stmt.setString(1, value);
            stmt.setString(2, index);
            stmt.execute();
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        }
        return true;
    }

    public boolean ExcluirCliente(String cpf) {
        Connection conn = Connect.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM cliente WHERE cpf = ?");) {
            stmt.setString(1, cpf);
            stmt.execute();
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        }
        return true;
    }

    public boolean EditarConsulta(String id, String item, String text) {
        String sql = null;
        int aux = 0;
        item = item.toLowerCase();
        switch (item) {
            case "id":
                sql = "UPDATE consulta SET id = ?"
                        + " Where id = ?";
                break;
            case "cliente":
                sql = "UPDATE consulta SET cpfCliente = ?"
                        + " Where id = ?";
                break;
            case "medico":
                sql = "UPDATE consulta SET registroMedico = ?"
                        + " Where id = ?";
                break;
            case "data":
                sql = "UPDATE consulta SET dataConsulta = ?"
                        + " Where id = ?";
                aux = 1;
                break;
        }
        Connection conn = Connect.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            if (aux == 1) {
                SimpleDateFormat temp = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                try {
                    cal.setTime(temp.parse(text));
                } catch (ParseException ex) {
                    Logger.getLogger(Clinica.class.getName()).log(Level.SEVERE, null, ex);
                }
                long timeInMillis = cal.getTimeInMillis();
                stmt.setDate(1, new java.sql.Date(timeInMillis));
            } else {
                stmt.setString(1, text);
            }
            stmt.setInt(2, Integer.parseInt(id));
            stmt.execute();
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        }
        return true;
    }

    public boolean ExcluirConsulta(String id) {
        Connection conn = Connect.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM consulta WHERE id = ?");) {
            stmt.setInt(1, Integer.parseInt(id));
            stmt.execute();
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        }
        return true;
    }

    public boolean EditarMedico(String registro, String item, String text) {
        String sql = null;
        item = item.toLowerCase();
        int aux = 0;
        switch (item) {
            case "cpf":
                sql = "UPDATE medico SET cpf = ?"
                        + " Where registro = ?";
                break;
            case "nome":
                sql = "UPDATE medico SET nome = ?"
                        + " Where registro = ?";
                break;
            case "registro":
                sql = "UPDATE medico SET registro = ?"
                        + " Where registro= ?";
                break;
            case "especialidade":
                sql = "UPDATE medico SET especialidade = ?"
                        + " Where registro = ?";
                aux = 1;
                break;

        }
        Connection conn = Connect.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(sql);) {
            if (aux == 1) {
                stmt.setInt(1, Integer.parseInt(text));
            } else {
                stmt.setString(1, text);
            }
            stmt.setString(2, registro);
            stmt.execute();
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        }
        return true;
    }

    /*public boolean ExcluirConsulta(String id) {
     Connection conn = Connect.getConnection();
     try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM consulta WHERE id = ?");) {
     stmt.setInt(1, Integer.parseInt(id));
     stmt.execute();
     } catch (SQLException e) {
     System.err.print(e);
     return false;
     }
     return true;
     }*/
    public boolean ExcluirDentista(String registro) {
        Connection conn = Connect.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM medico WHERE registro = ?");) {
            stmt.setString(1, registro);
            stmt.execute();
        } catch (SQLException e) {
            System.err.print(e);
            return false;
        }
        return true;
    }

    public boolean EditarFuncionario(String valueAt, String selectedItem, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
