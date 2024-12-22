public class Main {
    public static void main(String[] args) {
        String nome = "TestClass";
        String mensagem = "Test Message!";

        GeradorClassTemplate gerador = new GeradorClassPadrao(nome, mensagem);
        gerador.constroiClass();

        System.out.print("\nIsso devera ser salvo em um arquivo chamado " + nome + ".java" + "\n");
    }
}