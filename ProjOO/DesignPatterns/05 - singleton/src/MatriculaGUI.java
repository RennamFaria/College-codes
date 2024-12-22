public class MatriculaGUI {
  public void matricular(int codAluno, int codCurso, Turma turma) {
    if (turma == null) {
      turma = new Turma();
      Curso c = Escola.getCurso(codCurso);
      turma.setCurso(c);
    }how to transform a
    Aluno rex = Escola.getAluno(codAluno);
    turma.addAluno(rex);
  }

  public void exibirStatus(Turma turma) {
    cursoFld.setText(turma.getCurso().getNome());
    Aluno[] alunos = turma.getAlunos();
    for (int i = 0; i < alunos.length; i++) {
      displayList.add(alunos[i]);
    }
  }

}