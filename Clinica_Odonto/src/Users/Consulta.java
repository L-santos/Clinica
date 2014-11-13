package Users;

import java.util.*;

/**
 *
 * @author LucasPc
 */
public class Consulta {

    public static String colunasConsulta[] = {"Id", "Cliente", "Medico", "Data"};
    public static String uniqueKey = "Id";
    public static String[] getColunasConsulta() {
        return colunasConsulta;
    }
    private String cpfCliente;
    public Medico dadosMedico;
    private int idConsulta;
    private Date data = new Date();

    public Consulta(String _cpf, String _registro, Date _data) {
        dadosMedico = new Medico();
        this.cpfCliente = _cpf;
        this.dadosMedico.setRegistro_M(_registro);
        this.data = _data;
        idConsulta = new Random().nextInt(1000);
    }

    public Consulta() {
        dadosMedico = new Medico();
    }

    public String getCpfCliente() {
        return this.cpfCliente;
    }

    public void setCpfCliente(String _cpf) {
        this.cpfCliente = _cpf;
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
