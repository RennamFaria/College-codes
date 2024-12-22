public class EmpresaBuilder extends Builder{
  private String nome;
  private Pessoa responsavel;

  public EmpresaBuilder nome(String nome) {
    this.nome = nome;
    return this;
  }

  public EmpresaBuilder responsavel(Pessoa responsavel) {
    this.responsavel = responsavel;
    return this;
  }

  public String getNome() {
    return this.nome;
  }

  public Pessoa getResponsavel() {
    return this.responsavel;
  }

  public Empresa build() {
    if (responsavel.getNome() == null || responsavel.getID() == null) {
      throw new Error("Nome e ID do responsável são obrigatórios");
    }
    return new Empresa(this);
  }
}