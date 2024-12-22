import java.util.ArrayList;
import java.util.List;

class Artigo implements Publicacao {
  private String nome;
  private String[] autores;

  public Artigo(String nome, String[] autores) {
    this.nome = nome;
    this.autores = autores;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String[] getAutores() {
    return autores;
  }

  public void setAutor(String nome) {
    this.nome = nome;
  }

  @Override
  public List<Publicacao> getPublicacoes() {
    return new ArrayList<Publicacao>();  //retorna nada
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Artigo: ").append(nome);
    if (autores != null && autores.length > 0) {
      sb.append(" (Autores: ");
      for (int i = 0; i < autores.length; i++) {
        sb.append(autores[i]);
        if (i < autores.length - 1) {
          sb.append(", ");
        }
      }
      sb.append(")");
    }
    return sb.toString();
  }
}
