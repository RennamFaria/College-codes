public class InstituicaoConcreto implements Instituicao {
  private String nome;

  public InstituicaoConcreto(String nome){
    this.nome = nome;
  }

  @Override
  public void update(PCD pcd) {
    if (pcd instanceof PCDData) {
      PCDData data = (PCDData) pcd;

      String nome = data.getPCDNome();
      double temp = data.getTemp();
      double PH = data.getPH();
      double PA = data.getPA();

      System.out.println(this.nome);
      System.out.println("Nova Atualização recebida de " + nome);
      System.out.println(String.format("   Temperatura: %.2f, PH: %.2f, PA: %.2f", temp, PH, PA));
    }
  }
}