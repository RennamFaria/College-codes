public class Circulo implements Figura {
  float raio;
  float area;

  public Circulo(){
    raio = 3;
  }
  
  @Override
  public float area() {
    float area = (float) (3.14 * raio * raio);
    
    return area;
  }
}