import java.util.ArrayList;
import java.util.List;

// Composite
class Instituicao implements Participante {
  private List<Participante> membros;

  public Instituicao() {
    membros = new ArrayList<Participante>();
  }

  public List<Participante> getMembros(){
    return membros;
  }

  @Override
  public void adicionarMembro(Participante membro) {
    membros.add(membro);
  }

  @Override
  public void removerMembro(Participante participante) {
    membros.remove(participante);
  }

  @Override
  public Participante getFolha(int i) {
    return membros.get(i);
  }
  
}