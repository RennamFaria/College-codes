import java.util.ArrayList;
import java.util.List;

public class Congresso implements Participante{
  private List<Participante> membros;

  public Congresso() {
      membros = new ArrayList<Participante> ();
  }
  
  @Override
  public int totalParticipantes() {
    int total = 0;
    int sizeLista;
    
    for (Participante membro : membros) {
      if(membro instanceof Individuo){
        total += 1;
      }
      if(membro instanceof Instituicao){
        sizeLista = ((Instituicao)membro).getMembros().size();
        total += sizeLista;
        sizeLista = 0;  //reseta
      }
    }
    
    return total;
  }

  @Override
  public int totalAssentos() {
    int total = 0;
    int sizeLista;
    
    for (Participante membro : membros) {
      if(membro instanceof Individuo && ((Individuo)membro).getAssento() == true){
        total += 1;
      }
      if(membro instanceof Instituicao){
        sizeLista = ((Instituicao)membro).getMembros().size();
        for(int i = 0; i < sizeLista; i++){
          if(membros.get(i) instanceof Individuo && ((Individuo)membros.get(i)).getAssento() == true){
            total += 1;
          }
        }
        
        sizeLista = 0;  //reseta
      }
    }
    
    return total;
  }
}