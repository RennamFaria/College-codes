public class Diretor {
  public Pessoa buildPessoa(String nome, String ID){
    
    PessoaBuilder pessoa = new PessoaBuilder()
                          .nome(nome)
                          .ID(ID);
    return pessoa.build();
  }
  
  public Empresa buildEmpresa(String nomeEmpresa, String nome, String ID) {
    Pessoa responsavel = buildPessoa(nome, ID);
    EmpresaBuilder empresa = new EmpresaBuilder()
                          .nome(nomeEmpresa)
                          .responsavel(responsavel);
    return empresa.build();
  }
}