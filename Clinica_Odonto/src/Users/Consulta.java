
package Users;

import java.util.Date;

/**
 *
 * @author LucasPc
 */
public class Consulta {

    private String cpfCliente;
    private String registroMedico;
    private int idConsulta;
    private Date data = new Date();

    public Consulta(String _cpf, Date _data) {
        this.cpfCliente = _cpf;
        this.data = _data;
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
