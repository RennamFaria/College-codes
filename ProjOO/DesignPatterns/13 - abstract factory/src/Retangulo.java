public class Retangulo {
  private Ponto ponto1;
  private Ponto ponto2;

  public Retangulo(Ponto ponto1, Ponto ponto2) {
    setPonto1(ponto1);
    setPonto2(ponto2);
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

  @Override
  public String toString() {
    return "Ponto 1: " + ponto1.toString() + ", Ponto 2: " + ponto2.toString();
  }

  public void printRetangulo() {
    System.out.println("Retangulo: " + toString());
  }
}