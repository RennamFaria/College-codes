import java.util.Arrays;
import java.util.Comparator;

public abstract class OrdenadorTemplate {
  protected abstract Comparator<String> criarComparator();
  
  public void ordenarPalavras(String[] palavras) {
    Arrays.sort(palavras, criarComparator());
  }
}