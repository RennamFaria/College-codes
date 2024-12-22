public class Turma {
  Aluno[] alunos;
  Curso curso;
  int codigo;

  public void setCurso(Curso c) {
    this.curso = c;
  }

  public void addAluno(Aluno a) {
    alunos.append(a);
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

}