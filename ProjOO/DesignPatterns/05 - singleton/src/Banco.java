public class Banco {
  Aluno[] alunos;
  Curso[] cursos;
  Turma[] turmas;

  public Aluno getAluno(int codigo) {
    for (int i = 0; i < alunos.length; i++) {
      if (alunos[i].codigo == codigo) {
        return alunos[i];
      }
    }
  }

  public Curso getCurso(int codigo) {
    for (int i = 0; i < cursos.length; i++) {
      if (cursos[i].codigo == codigo) {
        return cursos[i];
      }
    }
  }

  public Turma getTurma(int codigo) {
    for (int i = 0; i < turmas.length; i++) {
      if (turmas[i].codigo == codigo) {
        return turmas[i];
      }
    }
  }
}