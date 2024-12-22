class Individuo implements Participante {
  private boolean assento;  //true = possui assento, false = nao possui assento

  public Individuo(boolean assento) {
    this.assento = assento;
  }

  @Override
  public boolean getAssento() {
    return assento;
  }

  public void setAssento(boolean assento) {
    this.assento = assento;
  }
}