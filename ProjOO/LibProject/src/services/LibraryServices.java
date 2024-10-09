package services;

import java.util.List;

import entities.Book;
import entities.UserTypes.Librarian;

import java.util.ArrayList;

import utils.PrintHelper;

public class LibraryServices implements Library {  // Renamed to LibraryImpl to reflect it implements the Library interface
  private BookManager bookManager;
  private ExternalCatalog externalCatalog;
  private List<Librarian> employees;

  public LibraryServices(BookManager bookManager, ExternalCatalog externalCatalog) {
    this.bookManager = bookManager;
    this.externalCatalog = externalCatalog;
    this.employees = new ArrayList<>();
  }

  @Override
  public void searchBook(String title) {
    List<Book> books = bookManager.getAllBooks();
    boolean found = false;

    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        System.out.println("--Book found!--");
        PrintHelper.printBook(book);
        found = true;
        break;
      }
    }

    if (!found) {
      List<Book> externalBooks = externalCatalog.searchBooks("title", title);
      for (Book book : externalBooks) {
        if (book.getTitle().equalsIgnoreCase(title)) {
          System.out.println("--External book found!--");
          PrintHelper.printBook(book);
          found = true;
          break;
        }
    }
    }
    if (!found) {
      System.out.println("Book not found.");
    }
  }

  @Override
  public void loanBook() {
    // Implementation for loaning a book
  }

  @Override
  public void returnBook() {
    // Implementation for returning a book
  }

  @Override
  public void getBookInfo() {
    // Implementation for getting book information
  }

  public List<Book> getAllBooks() {
    return bookManager.getAllBooks();
  }

  @Override
  public void listBooks() {
    List<Book> books = bookManager.getAllBooks();
    PrintHelper.printBooks(books);
  }
}
