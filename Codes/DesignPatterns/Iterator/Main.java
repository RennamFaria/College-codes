import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main{
    public static void main(String[] args){
        IteratorFiguras iterator = new IteratorFiguras();

        Circulo circulo = new Circulo();
        Quadrado quadrado = new Quadrado();
        TrEquilatero trEquilatero = new TrEquilatero();
        
        iterator.add(quadrado);
        iterator.add(circulo);
        iterator.add(trEquilatero);

        iterator.itera();
    }
}