public class TrEquilatero implements Figura{
    int tamLado;
    float area;

    public TrEquilatero(){
      tamLado = 5;
    }

    @Override
    public float area(){
      area = (float) (Math.sqrt(3)/4) * (tamLado * tamLado);

      return area;
    }

    @Override
    public void print(){
      System.out.println("TrEquilatero: ");
      System.out.println("\ttamLado = " + tamLado);
      System.out.println("\tarea = "+ area());
    }
}