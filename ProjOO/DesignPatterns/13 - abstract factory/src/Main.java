public class Main {
  public static void main(String[] args) {
    Fabrica fabrica = new FabricaConcreta();

    Ponto pontoA = fabrica.createPonto(1, 10);
    Ponto pontoB = fabrica.createPonto(5, 5);
    Ponto pontoC = fabrica.createPonto(10, 2);

    Circulo circulo = fabrica.createCirculo(pontoA, 5);
    circulo.printCirculo();

    Retangulo retangulo = fabrica.createRetangulo(pontoA, pontoB);
    retangulo.printRetangulo();

    Triangulo triangulo = fabrica.createTriangulo(pontoA, pontoB, pontoC);
    triangulo.printTriangulo();
  }
}