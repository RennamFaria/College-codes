public class PCDMemento {
  private String nome;
  private double temp;
  private double PH;
  private double PA;

  public PCDMemento(String nome, double temp, double PH, double PA) {
    this.nome = nome;
    this.temp = temp;
    this.PH = PH;
    this.PA = PA;
  }

  public String getNome() {
    return nome;
  }

  public double getTemp() {
    return temp;
  }

  public double getPH() {
    return PH;
  }

  public double getPA() {
    return PA;
  }
}