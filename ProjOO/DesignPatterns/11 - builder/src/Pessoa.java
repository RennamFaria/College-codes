public class Pessoa {
  private String nome;
  private String ID;

  public Pessoa(PessoaBuilder builder){
    this.nome = builder.getNome();
    this.ID = builder.getID();
  }

  public String getNome() {
    return this.nome;
  }

  public String getID() {
    return this.ID;
  }

  @Override
    public String toString() {
      return("  Nome: " + this.nome + "\n  Identificação: " + this.ID);
    }
}