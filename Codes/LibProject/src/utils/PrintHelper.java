package utils;

import java.util.List;

import entities.Book;
import entities.User;
import services.Library;

public class PrintHelper {

  public static void printBook(Book book) {
    System.out.println("Title: " + book.getTitle());
    System.out.println("Authors: " + String.join(", ", book.getAuthors()));
    System.out.println("Category: " + book.getCategory());
    System.out.println("Available: " + book.getAvailable() + "\n");
  }

  public static void printBooks(List<Book> books) {
    for (Book book : books) {
      printBook(book);
    }
  }

  public static void printUser(User user) {
    System.out.println("---" + user.getRole() + "---");
    System.out.println("Name: " + user.getName());
    System.out.println("ID: " + user.getID());
    System.out.println("Email: " + user.getEmail());
    System.out.println("Phone Number: " + user.getPhoneNumber());
    System.out.println("Books loaned: ");
    printBooks(user.getBooksLoaned());
    System.out.println();
  }

  public static void printLibrary(Library library) {
    List<Book> books = library.getAllBooks();
    System.out.println("Library Books:");
    printBooks(books);
  }
}