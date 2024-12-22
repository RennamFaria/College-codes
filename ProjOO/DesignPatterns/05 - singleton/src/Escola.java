public class Escola {
  Banco banco;

  public void setBanco(Banco b) {
    this.banco = b;
  }

  public Curso getCurso(int codigo) {
    return banco.getCurso(codigo);
  }

  public Aluno getAluno(int codigo) {
    return banco.getAluno(codigo);
  }
}