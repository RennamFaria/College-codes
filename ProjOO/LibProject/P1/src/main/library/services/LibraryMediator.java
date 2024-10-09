package library.services;

import library.models.Book;
import library.models.Loan;
import library.models.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LibraryMediator {
    private Map<String, Book> books;
    private Map<String, User> users;
    private Map<String, Loan> loans;

    public LibraryMediator() {
        books = new HashMap<>();
        users = new HashMap<>();
        loans = new HashMap<>();
    }

    public void loanBook(String userId, String bookId) {
        Book book = books.get(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            Loan loan = new Loan(userId, bookId, new Date(), null);
            loans.put(userId + bookId, loan);
        }
    }

    public void returnBook(String userId, String bookId) {
        Loan loan = loans.get(userId + bookId);
        if (loan != null) {
            loan.setReturnDate(new Date());
            Book book = books.get(bookId);
            if (book != null) {
                book.setAvailable(true);
            }
        }
    }
}
