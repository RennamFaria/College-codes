package services;
import java.util.ArrayList;
import java.util.List;

import entities.Book;

public class BookManager {
  List<Book> books = new ArrayList<>();
  
  public void addBook(Book book){
    this.books.add(book);
  }
  
  public void removeBook(Book book){
    this.books.remove(book);
  }

  public List<Book> getAllBooks(){
    return this.books;
  }
}