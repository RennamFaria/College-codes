public abstract class Fabrica { // abstract factory
  public Ponto createPonto(int x, int y) {return null;}

  public Circulo createCirculo(Ponto p1, float raio) {return null;}
  
  public Retangulo createRetangulo(Ponto p1, Ponto p2) {return null;}

  public Triangulo createTriangulo(Ponto p1, Ponto p2, Ponto p3) {return null;}

  //para clone
  public Ponto createClonePonto(Ponto ponto) {return null;}
  
  public Circulo createCloneCirculo(Circulo circulo) {return null;}
  
  public Retangulo createCloneRetangulo(Retangulo retangulo) {return null;}
  
  public Triangulo createCloneTriangulo(Triangulo triangulo) {return null;}
}