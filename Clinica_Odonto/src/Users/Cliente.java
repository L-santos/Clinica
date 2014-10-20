
package Users;

/**
 *
 * @author LucasPc
 */
public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;
    
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
