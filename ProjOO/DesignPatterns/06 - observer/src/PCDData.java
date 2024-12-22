public class PCDData extends PCD {
  private String nome;
  private double temp;
  private double PH;
  private double PA;

  public PCDData(String nome, double temp, double PH, double PA) {
    this.nome = nome;
    this.temp = temp;
    this.PH = PH;
    this.PA = PA;
  }

  public void addData(double temp, double PH, double PA) {
    this.temp = temp;
    this.PH = PH;
    this.PA = PA;
    notificar();
  }

  public double getTemp() {
    return this.temp;
  }

  public double getPH() {
    return this.PH;
  }

  public double getPA() {
    return this.PA;
  }
  
  public String getPCDNome() {
    return this.nome;
  }
}