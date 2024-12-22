public class Circulo {
  private Ponto ponto;
  private float raio;

  public Circulo(Ponto ponto, float raio) {
    setPonto1(ponto);
    setRaio(raio);
  }

  public Ponto getPonto1() {
    return ponto;
  }

  public void setPonto1(Ponto ponto) {
    this.ponto = ponto;
  }

  public void setRaio(float raio) {
    this.raio = raio;
  }

  public float getRaio() {
    return this.raio;
  }

  @Override
  public String toString() {
    return "Centro: " + ponto.toString() + ", Raio: " + raio;
  }

  public void printCirculo() {
    System.out.println("Circulo: " + toString());
  }
}