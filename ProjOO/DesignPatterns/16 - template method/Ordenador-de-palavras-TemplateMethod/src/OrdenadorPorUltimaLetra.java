import java.util.Comparator;

class OrdenadorPorUltimaLetra extends OrdenadorTemplate {

  @Override
  protected Comparator<String> criarComparator() {
    return new Comparator<String>() {
      @Override
        public int compare(String s1, String s2) {
          char lastChar1 = s1.charAt(s1.length() - 1);
          char lastChar2 = s2.charAt(s2.length() - 1);
          return Character.compare(lastChar1, lastChar2);
        }
    };
  }
}