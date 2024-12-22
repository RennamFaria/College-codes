public class Triangulo {
  private Ponto ponto1;
  private Ponto ponto2;
  private Ponto ponto3;

  public Triangulo(Ponto ponto1, Ponto ponto2, Ponto ponto3) {
    setPonto1(ponto1);
    setPonto2(ponto2);
    setPonto3(ponto3);
  }

  public void setPonto1(Ponto ponto) {
    this.ponto1 = ponto;
  }

  public Ponto getPonto1() {
    return this.ponto1;
  }

  public void setPonto2(Ponto ponto) {
    this.ponto2 = ponto;
  }

  public Ponto getPonto2() {
    return this.ponto2;
  }

  public void setPonto3(Ponto ponto) {
    this.ponto3 = ponto;
  }

  public Ponto getPonto3() {
    return this.ponto3;
  }

  @Override
  public String toString() {
    return "Ponto 1: " + ponto1.toString() + ", Ponto 2: " + ponto2.toString() + ", Ponto 3: " + ponto3.toString();
  }

  public void printTriangulo() {
    System.out.println("Triangulo: " + toString());
  }
}