public class Empresa {
  private String nome;
  private Pessoa responsavel;

  public Empresa(EmpresaBuilder builder) {
    this.nome = builder.getNome();
    this.responsavel = builder.getResponsavel();
  }

  public String getNome() {
    return this.nome;
  }

  public Pessoa getResponsavel() {
    return this.responsavel;
  }

  @Override
    public String toString() {
      return("  Nome Empresa: " + this.nome + "\nResponsável:\n" + this.responsavel);
    }
}