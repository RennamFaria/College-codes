public class Cliente {          //Facade
  CriadorFig construtor = new CriadorFig();

  public void printAreaCirculo(){
    Figura figura = construtor.getFigura("Circulo");

    System.out.println("Area do Circulo: " + figura.area());
  }

  public void printAreaQuadrado(){
    Figura figura = construtor.getFigura("Quadrado");

    System.out.println("Area do Quadrado: " + figura.area());
  }

  public void printAreaTrEquilatero(){
    Figura figura = construtor.getFigura("TrEquilatero");

    System.out.println("Area do Triangulo Equilatero: " + figura.area());
  }
}