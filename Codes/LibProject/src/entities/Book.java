package entities;
import java.util.List;

public class Book {
  private String title;
  private String ID;
  private List<String> authors;
  private String category;
  private boolean available;

  public Book(String title, String ID, List<String> authors, String category, boolean available) {
    this.title = title;
    this.ID = ID;
    this.authors = authors;
    this.category = category;
    this.available = available;
  }
  
  public String getTitle() {
    return this.title;
  }

  public String getID() {
    return this.ID;
  }

  public List<String> getAuthors(){
    return this.authors;
  }
  
  public String getCategory(){
    return this.category;
  }

  public boolean isAvailable() {
    return available;
}

public void setAvailable(boolean available) {
    this.available = available;
}
}