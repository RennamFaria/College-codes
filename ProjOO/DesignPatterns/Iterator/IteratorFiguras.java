import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorFiguras{
    List<Figura> listFiguras;

    public IteratorFiguras(){
        listFiguras = new ArrayList<>();
    }

    public void itera(){
        Iterator it = listFiguras.iterator();

        while(it.hasNext()){
            Figura fig = (Figura) it.next();
            fig.print();
        }
    }

    public void add(Figura f){
        listFiguras.add(f);
    }
}