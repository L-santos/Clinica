
package Users;

import java.util.*;

/**
 *
 * @author LucasPc
 */
public class Consulta {
    
    public static String colunasConsulta[] = {"ID", "CLIENTE", "MEDICO", "DATA"};
    private String cpfCliente;
    private String registroMedico;
    private int idConsulta;
    private Date data = new Date();

    public Consulta(String _cpf, String _registro, Date _data) {
        this.cpfCliente = _cpf;
        this.registroMedico = _registro;
        this.data = _data;
        idConsulta = new Random().nextInt(1000);
    }

    public Consulta() {
    }

    
    public String getCpfCliente() {
        return this.cpfCliente;
    }

    public void setCpfCliente(String _cpf) {
        this.cpfCliente = _cpf;
    }

    public String getRegistroMedico() {
        return this.registroMedico;
    }

    public void setRegistroMedico(String _registro) {
        this.registroMedico = _registro;
    }

    public int getIdConsulta() {
        return this.idConsulta;
    }

    public void setIdConsulta(int _id) {
        this.idConsulta = _id;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date _data) {
        this.data = _data;
    }
}
