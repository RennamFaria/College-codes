package entities.UserTypes;

import entities.User;
import utils.PrintHelper;

public class Professor extends User {
  private String department;
  private int maxLoan;

  public Professor(String name, String ID, String email, String phoneNumber, String department) {
    super(name, ID, email);
    super.role = "Professor";
    this.department = department;
    this.maxLoan = 3;
  }

  public String getDepartment() {
    return this.department;
  }

  public void setDepartment(String departament) {
    this.department = departament;
  }

  @Override
  public int getMaxLoan() {
    return this.maxLoan;
  }

  @Override
  public void printUserInfo() {
    PrintHelper.printUser(this);

    System.out.println("Department: " + getDepartment());
  }
}
