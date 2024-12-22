public class TrEquilatero implements Figura{
  int tamLado;
  float area;

  public TrEquilatero(){
    tamLado = 3;
  }

  @Override
  public float area(){
    area = (float) (Math.sqrt(3)/4) * (tamLado * tamLado);

    return area;
  }
}