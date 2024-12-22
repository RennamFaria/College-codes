public class Main {
  public static void main(String[] args) {
  Diretor diretor = new Diretor();

  Pessoa pessoa = diretor.buildPessoa("Igor Péres", "1234512345");

  Empresa empresa = diretor.buildEmpresa("Empresa Teste", "Carol de Neves", "10101010101010");

  System.out.println("Pessoa:");
  System.out.println(pessoa);

  System.out.println("\nEmpresa:");
  System.out.println(empresa);
  }
}