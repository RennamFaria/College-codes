public class Ponto {
  private int x;
  private int y;

  public Ponto(int x, int y) {
    setX(x);
    setY(y);
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  public void printPonto() {
    System.out.println("Ponto: " + toString());
  }
}