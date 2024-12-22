import java.util.ArrayList;
import java.util.List;

class Colecao implements Publicacao {
  private String nome;
  private List<Publicacao> publicacoes;

  public Colecao(String nome) {
    this.nome = nome;
    this.publicacoes = new ArrayList<Publicacao>();
  }

  @Override
  public List<Publicacao> getPublicacoes() {
    return publicacoes;
  }

  public String getNome() {
    return nome;
  }

  public void adicionarPublicacao(Publicacao publicacao) {
    publicacoes.add(publicacao);
  }

  public void removerPublicacao(Publicacao publicacao) {
    publicacoes.remove(publicacao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
      sb.append(nome).append(":");
      for (Publicacao p : publicacoes) {
        sb.append("\n").append(p.toString());
      }
      return sb.toString();
    }
}