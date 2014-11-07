
package Users;

class Funcionario {
    private String cpf_func;
    private String nome_func;
    private String tel_func;
   public static String colunasFuncionario[] = {"CPF", "NOME", "TELEFONE"};
   
  public Funcionario(String Cpf_f, String Nome_f, String Tel_f){
      this.cpf_func= Cpf_f;
      this.nome_func= Nome_f;
      this.tel_func=Tel_f;
  }

    public Funcionario() {
    }
  
  public String getCpf_f(){
    return this.cpf_func;
     
  }
  public void setCpf_f(String _Cpf_f){
      this.cpf_func = _Cpf_f;
  }
  
  public String getNome_f(){
      return this.nome_func;
  }
  public void setNome_f(String _Nome_f){
      this.nome_func = _Nome_f;
  }
  
  public String getTel_f(){
      return this.tel_func;    
  }
  
  public void setTel_f(String _Tel_f){
      this.tel_func = _Tel_f;
  }
}
