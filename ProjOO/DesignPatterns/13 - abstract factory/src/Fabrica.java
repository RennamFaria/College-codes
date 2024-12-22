public abstract class Fabrica { // abstract factory
  public Ponto createPonto(int x, int y) {return null;}

  public Circulo createCirculo(Ponto p1, float raio) {return null;}
  
  public Retangulo createRetangulo(Ponto p1, Ponto p2) {return null;}

  public Triangulo createTriangulo(Ponto p1, Ponto p2, Ponto p3) {return null;}
}