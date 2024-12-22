public class Main {
  public static void main(String[] args) {
    Fabrica fabrica = new FabricaConcreta();

    Ponto pontoA = fabrica.createPonto(1, 10);
    Ponto pontoB = fabrica.createPonto(5, 5);
    Ponto pontoC = fabrica.createPonto(10, 2);

    Circulo circulo = fabrica.createCirculo(pontoA, 5);
    Retangulo retangulo = fabrica.createRetangulo(pontoA, pontoB);
    Triangulo triangulo = fabrica.createTriangulo(pontoA, pontoB, pontoC);

    circulo.printCirculo();
    retangulo.printRetangulo();
    triangulo.printTriangulo();

    System.out.println("Agora teste para clones:\n");

    Ponto pontoClone = fabrica.createClonePonto(pontoA);
    Circulo circuloClone = fabrica.createCloneCirculo(circulo);
    Retangulo retanguloClone = fabrica.createCloneRetangulo(retangulo);
    Triangulo trianguloClone = fabrica.createCloneTriangulo(triangulo);

    //Nesta parte apenas checo se para cada clone possui informaçoes corretas do original, se todas forem certas, retorna true
    
    System.out.println("Ponto original e clone têm o mesmo estado: "
        + (pontoA.getX() == pontoClone.getX() && pontoA.getY() == pontoClone.getY()));

    System.out.println("Circulo original e clone têm o mesmo estado: "
        + (circulo.getPonto1().getX() == circuloClone.getPonto1().getX()
            && circulo.getPonto1().getY() == circuloClone.getPonto1().getY()
            && circulo.getRaio() == circuloClone.getRaio()));

    System.out.println("Retangulo original e clone têm o mesmo estado: "
        + (retangulo.getPonto1().getX() == retanguloClone.getPonto1().getX()
            && retangulo.getPonto1().getY() == retanguloClone.getPonto1().getY()
            && retangulo.getPonto2().getX() == retanguloClone.getPonto2().getX()
            && retangulo.getPonto2().getY() == retanguloClone.getPonto2().getY()));

    System.out.println("Triangulo original e clone têm o mesmo estado: "
        + (triangulo.getPonto1().getX() == trianguloClone.getPonto1().getX()
            && triangulo.getPonto1().getY() == trianguloClone.getPonto1().getY()
            && triangulo.getPonto2().getX() == trianguloClone.getPonto2().getX()
            && triangulo.getPonto2().getY() == trianguloClone.getPonto2().getY()
            && triangulo.getPonto3().getX() == trianguloClone.getPonto3().getX()
            && triangulo.getPonto3().getY() == trianguloClone.getPonto3().getY()));
  }
}