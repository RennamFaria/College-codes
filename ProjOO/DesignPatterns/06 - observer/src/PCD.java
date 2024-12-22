import java.util.ArrayList;
import java.util.List;

public class PCD {
  private List<Instituicao> instituicoes;

  public PCD() {
    this.instituicoes = new ArrayList<Instituicao>();
  }

  public void cadastrar(Instituicao o) {
      instituicoes.add(o);
  }

  public void descadastrar(Instituicao o) {
      instituicoes.remove(o);
  }

  public void notificar() {
    for (Instituicao instituicao : instituicoes) {
      instituicao.update(this);
    }
  }
}
