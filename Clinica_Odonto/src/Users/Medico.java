/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

/**
 *
 * @author LucasPc
 */

public class Medico {
   private String cpfMedico;
   private String nome;
   private String registro;
   private int especialidade;
   
  public Medico(String Cpf_M, String Nome_M, String Registro_M, int Esp_M){
      this.cpfMedico = Cpf_M;
      this.nome = Nome_M;
      this.registro = Registro_M;
      this.especialidade = Esp_M;
  }

    public Medico(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
  public String getCpf_M(){
      return this.cpfMedico;
  }
  public void setCpf_M(String _Cpf_M){
      this.cpfMedico = _Cpf_M;
  }
  
  public String setNome_M(){
      return this.nome;
  }
  public void setNome_M(String _Nome_M){
      this.nome = _Nome_M;
  }
  public String getRegistro_M(){
      return this.registro;
  }
  public void setRegistro_M(String _Registro_M){
      this.registro = _Registro_M;
  }
  public int getEsp_M(){
      return this.especialidade;
  }
  public void setEsp_M(int _Esp_M){
      this.especialidade = _Esp_M;
  }
}
