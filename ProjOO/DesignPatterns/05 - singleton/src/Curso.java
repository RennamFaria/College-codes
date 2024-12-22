public class Curso {
  String nome;
  int codigo;
  Banco banco;

  public void setBanco(Banco b) {
    this.banco = b;
  }

  public String getNome() {
    return banco.getCurso(codigo).nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }
}