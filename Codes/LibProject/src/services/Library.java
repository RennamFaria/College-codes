package services;

public interface Library {
  void searchBook(String title);
  void loanBook();
  void returnBook();
  void getBookInfo();
  void listBooks();
}
