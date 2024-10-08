package library.services;

import library.models.Book;

import java.util.List;

public class LibraryFacade {
    private ExternalCatalogAdapter catalogAdapter;
    private LibraryMediator mediator;

    public LibraryFacade() {
        catalogAdapter = new ExternalCatalogAdapter();
        mediator = new LibraryMediator();
    }

    public List<Book> searchBooksByTitle(String title) {
        return catalogAdapter.searchBooks(title);
    }

    public void loanBook(String userId, String bookId) {
        mediator.loanBook(userId, bookId);
    }

    public void returnBook(String userId, String bookId) {
        mediator.returnBook(userId, bookId);
    }
}
