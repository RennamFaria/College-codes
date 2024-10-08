package entities.UserTypes;

import entities.User;
import utils.PrintHelper;

public class Student extends User {
  private String major;
  private int maxLoan;

  public Student(String name, String ID, String email, String phoneNumber, String major, int year) {
    super(name, ID, email);
    super.role = "Student";
    this.major = major;
    this.maxLoan = 1;
  }

  public String getMajor() {
    return this.major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  @Override
  public int getMaxLoan() {
    return this.maxLoan;
  }

  @Override
  public void printUserInfo() {
    PrintHelper.printUser(this);

    System.out.println("Major: " + getMajor());
  }
}