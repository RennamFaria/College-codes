package entities.UserTypes;

import entities.User;
import services.Library;
import utils.PrintHelper;

public class Librarian extends User {
  private String department;
  private String jobTitle;
  private Library library;
  private int maxLoan;

  public Librarian(String name, String ID, String email, String phoneNumber, String department, String jobTitle, Library library) {
    super(name, ID, email);
    super.role = "Employee";
    this.department = department;
    this.jobTitle = jobTitle;
    this.library = library;
    this.maxLoan = 5;
  }

  public String getDepartment() {
    return this.department;
  }

  public void setDepartment(String departament) {
    this.department = departament;
  }

  public String getJobTitle() {
    return this.jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public Library getLibrary() {
    return this.library;
  }

  public void setLibrary(Library library) {
    this.library = library;
  }

  @Override
  public int getMaxLoan() {
    return this.maxLoan;
  }

  @Override
  public void printUserInfo() {
    PrintHelper.printUser(this);

    System.out.println("Department: " + getDepartment());
    System.out.println("Job Title: " + getJobTitle());
    System.out.println("Acting Library: " + getLibrary());
  }
}
