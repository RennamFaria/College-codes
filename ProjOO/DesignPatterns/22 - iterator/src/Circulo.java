public class Circulo implements Figura {
    float raio;
    float area;
  
    public Circulo(){
      raio = 2;
    }
    
    @Override
    public float area() {
      float area = (float) (3.14 * raio * raio);
      
      return area;
    }

    @Override
    public void print(){
      System.out.println("Circulo: ");
      System.out.println("\traio = " + raio);
      System.out.println("\tarea = "+ area());
    }
}