package library;

import library.services.LibraryFacade;

public class Main {
    public static void main(String[] args) {
        LibraryFacade library = new LibraryFacade();
        // Exemplos de uso
        library.searchBooksByTitle("Some Book Title");
        library.loanBook("User123", "Book123");
        library.returnBook("User123", "Book123");
    }
}

