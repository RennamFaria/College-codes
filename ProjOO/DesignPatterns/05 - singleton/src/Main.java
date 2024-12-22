public class Main {
    public static void main(String[] args) {
      Singleton singleton1, singleton2, singleton3;

      Banco banco_de_dados = new Banco();
      singleton1 = Singleton.obterInstanciaSingleton();
      singleton2 = Singleton.obterInstanciaSingleton(); 
      singleton3 = Singleton.obterInstanciaSingleton();  

      if (singleton1 == singleton2) {
        if(singleton2 == singleton3){
          System.out.println("Os tres facades são a mesma instancia");
        }
      }

        singleton1.setBanco(banco_de_dados);
        singleton1.novoCurso("Matemática", 1);
        singleton1.novoCurso("Física", 2);
        singleton1.novoAluno("Rex", 1, 1);
        singleton1.novoAluno("Fulano", 2, 2);
        singleton1.novoAluno("Ciclano", 3, 3);
      int[] array1 = {1,2};
      int[] array2 = {2,3};
        singleton1.criarTurma(1, array1);
        singleton1.criarTurma(2, array2);
        singleton1.printStatus(1);

    }
}