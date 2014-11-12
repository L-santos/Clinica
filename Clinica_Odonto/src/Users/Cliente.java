package Users;

import java.util.ArrayList;

/**
 *
 * @author LucasPc
 */
public class Cliente {

    private String cpf;
    private String nome;
    private String telefone;
    public ArrayList<Consulta> consultas = new ArrayList<>();
    public static String[] colunasCliente = {"Cpf", "Nome", "Tel"};
    public static String colConsultasCliente[] = {"ID", "Data", "Medico"};
    public Cliente() {

    }

    public static String[] getColunasCliente() {
        return colunasCliente;
    }

    public static void setColunasCliente(String[] colunasCliente) {
        Cliente.colunasCliente = colunasCliente;
    }

    public ArrayList<Consulta> getConsultas() {
        return new Clinica().PesquisarConsulta(this.getCpf());
    }

    
    public Cliente(String Cpf, String Nome, String Tel) {
        this.cpf = Cpf;
        this.nome = Nome;
        this.telefone = Tel;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String _cpf) {
        this.cpf = _cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String _nome) {
        this.nome = _nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String _telefone) {
        this.telefone = _telefone;
    }
}
