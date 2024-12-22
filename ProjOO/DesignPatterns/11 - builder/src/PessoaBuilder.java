public class PessoaBuilder extends Builder{
  private String nome;
  private String ID;

  public PessoaBuilder nome(String nome){
    this.nome = nome;
    return this;
  }

  public PessoaBuilder ID(String ID){
    this.ID = ID;
    return this;
  }

  public String getNome(){
    return this.nome;
  }

  public String getID(){
    return this.ID;
  }

  public Pessoa build() {
    if (nome == null || ID == null) {
      throw new Error("Nome e identidade são obrigatórios");
    }
    return new Pessoa(this);
  }
}