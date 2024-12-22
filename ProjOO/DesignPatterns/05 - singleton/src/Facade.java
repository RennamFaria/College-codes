public class Singleton {

  private static Singleton singleton;

  public static Singleton obterInstanciaSingleton() {
    if (singleton == null){
        singleton = new Singleton();
      }
  return singleton;
  }

  private static MatriculaGUI matriculaGUI;
  private static Banco banco;

  public static MatriculaGUI GetMatriculaGUI() {
    if (matriculaGUI == null) {
      matriculaGUI = new MatriculaGUI();
    }
    return matriculaGUI;
  }
  

  public static Banco GetBanco() {
    if (banco == null) {
      banco = new Banco();
    }
  return banco;
  }

  public void setBanco(Banco b) {
    this.banco = b;
  }

  public void matricular(int codAluno, int codCurso, int codTurma) {
    int turma = banco.getTurma(codTurma);
      MatriculaGUI Singleton.matricular(codAluno, codCurso, turma);
    System.out.println("Matricula realizada com sucesso!");
  }

  public void printStatus(int codTurma) {
    Turma turma = banco.getTurma(codTurma);
    Lista lista = matriculaGUI.exibirStatus(turma);
    for (int i = 0; i < lista.length; i++) {
      System.out.println(lista[i]);
    }
  }

  public void criarTurma(int codCurso, int[] alunos) {
    Turma turma = new Turma();
    Curso curso = Singleton.GetBanco().getCurso(codCurso);
    turma.setCurso(Curso);
    if (alunos != null) {
      for (int i = 0; i < alunos.length; i++) {
        Aluno aluno = banco.getAluno(alunos[i]);
        turma.addAluno(aluno);
      }
    }
    turma.setCodigo(codigo);
    Banco banco.addTurma(turma);
  }

  public void novoCurso(String nome, int codigo) {
    Curso curso = new Curso();
    curso.setNome(nome);
    curso.setCodigo(codigo);
    Banco banco.addCurso(curso);
  }

  public void novoAluno(String nome, int matricula, int codigo) {
    Aluno aluno = new Aluno();
    aluno.setNome(nome);
    aluno.setMatricula(matricula);
    aluno.setCodigo(codigo);
    Banco banco.addAluno(aluno);
  }
}
