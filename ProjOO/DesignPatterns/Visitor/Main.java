public class Main {
    public static void main (String[] args){
        Operacao adicao = new Adicao(4, 9);
        Operacao multiplicacao =  new Multiplicacao(5, 7);

        Calcula calculator = new Calcula();
        Imprime printer = new Imprime(calculator);

        adicao.aceita(calculator);
        adicao.aceita(printer);

        multiplicacao.aceita(calculator);
        multiplicacao.aceita(printer);
    }
}