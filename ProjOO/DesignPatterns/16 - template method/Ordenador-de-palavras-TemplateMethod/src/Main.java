import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    OrdenadorTemplate ordenador = new OrdenadorPorUltimaLetra();

    String[] sequencia = {"Mao", "Pe", "Cabecak", "Orelha", "Boca", "Pernat", "Pescoçoz", "Bracos"};
    
    ordenador.ordenarPalavras(sequencia);

    System.out.println(Arrays.toString(sequencia));
  }
}