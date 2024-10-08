//mport java.util.Arrays;
import services.BookManager;
import services.ExternalCatalogAdapter;
import services.ExternalCatalogService;
import services.Library;

public class Main {
  public static void main(String[] args) {
    BookManager bookManager = new BookManager();
    ExternalCatalogService externalService = new ExternalCatalogService();
    ExternalCatalogAdapter adapter = new ExternalCatalogAdapter(externalService);
    Library library = new Library(bookManager, adapter);

    library.searchBook("Some Book Title");
    library.listBooks();
  }
}

///////////Aplicar principios de SOLID////////////////////////

//Usuários
  //estudante 
  //funcionário
  //professor

//Funções para implementar
  //Busca de livros: por titulo, autor ou categoria
    //adaptar

  //Empréstimo de livros: apenas livros que estejam disponíveis
    //Verificar a elegibilidade do usuário para realizar o empréstimo
    //operaçoes principais em interface simplificada

  //Devolução de livros: apenas livros que estejam emprestados
  
  //consulta informações de livros: livros, titulo, autor, categoria ou disponibilidade
    //de forma hierárquica de consulta, apenas funcionarios?

  //consulta informações de usuários: historico de emprestimo, livros emprestados e devolvidos
    //de forma separada de consulta, difere de usuarios e funcionarios?


//usar interface de linhas de comando
//usar banco de dados ou salvar em memória?

//Requisitos:
  //Integração com Sistemas Externos: `ExternalCatalogAdapter`

  //Interface Simplificada para Operações: `LibraryFacade`

  //Gerenciamento Hierárquico de Categorias: `BookCategory`

  //Abstração e Implementação para Diferentes Usuários: `User`, `StudentUserType`, `TeacherUserType`

  //Gerenciamento Centralizado de Configurações: `ConfigurationManager`

  //Notificações aos Usuários: `BookAvailabilityNotifier`

  //Coordenação de Interações do Sistema: `LibraryMediator`

  //Aprovação de Empréstimos: `BookAvailabilityHandler`, `UserEligibilityHandler`, `LoanLimitHandler`
