public class Main {  //TESTE
  public static void main(String[] args) {
    Colecao jornal = new Colecao("Jornal");
    Colecao caderno = new Colecao("Caderno");
    Colecao revista = new Colecao("Revista");
    
    jornal.adicionarPublicacao(new Artigo("Artigo Jornal", new String[] { "Autor 1", "Autor 2" }));
    jornal.adicionarPublicacao(caderno);
    caderno.adicionarPublicacao(new Artigo("Artigo Caderno", new String[] { "Autor 2" }));
    caderno.adicionarPublicacao(revista);
    revista.adicionarPublicacao(new Artigo("Artigo Revista", new String[] { "Autor 1", "Autor 2", "Autor 3" }));
    int numPublicacoes = contarPublicacoes(jornal);
    int numArtigos = contarArtigos(jornal);

    
    System.out.println("Número de Publicações: " + numPublicacoes);
    System.out.println("Número de Artigos: " + numArtigos);
    System.out.println("\n");
    System.out.println(jornal.toString());
  }

  public static int contarPublicacoes(Publicacao publicacao) {
    int count = 1; // Contando a própria publicação
    for (Publicacao p : publicacao.getPublicacoes()) {
      count += contarPublicacoes(p);
    }
    return count;
  }

  public static int contarArtigos(Publicacao publicacao) {
    int count = 0;
    for (Publicacao p : publicacao.getPublicacoes()) {
      if (p instanceof Artigo) {
        count++;
      } else {
        count += contarArtigos(p);
      }
    }
    return count;
  }
}