public class PCDData extends PCD {
  private String nome;
  private double temp;
  private double PH;
  private double PA;
  private Zelador zelador;

  public PCDData(String nome, double temp, double PH, double PA) {
    this.nome = nome;
    this.temp = temp;
    this.PH = PH;
    this.PA = PA;
    this.zelador = new Zelador();
  }

  public void addData(double temp, double PH, double PA) {
    saveMemento();
    this.temp = temp;
    this.PH = PH;
    this.PA = PA;
    notificar();
  }

  public String getPCDNome() {
    return this.nome;
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

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setTemp(double temp) {
    this.temp = temp;
  }

  public void setPH(double PH) {
    this.PH = PH;
  }

  public void setPA(double PA) {
    this.PA = PA;
  }

  private void saveMemento() {
    PCDMemento memento = createMemento();
    zelador.addMemento(memento);
  }

  public void restore() {
    if (zelador.hasMementos()) {
      PCDMemento memento = zelador.getMemento();
      setMemento(memento);
    } else {
      System.out.println("Erro! Sem estados anteriores.");
    }
  }

  public PCDMemento createMemento() {
    return new PCDMemento(this.nome, this.temp, this.PH, this.PA);
  }

  public void setMemento(PCDMemento memento) {
    this.nome = memento.getNome();
    this.temp = memento.getTemp();
    this.PH = memento.getPH();
    this.PA = memento.getPA();
    notificar();
  }

  public void info() {
    System.out.println("Nome: " + this.nome);
    System.out.println(String.format("   Temperatura: %.2f, PH: %.2f, PA: %.2f \n", temp, PH, PA));
  }
}
