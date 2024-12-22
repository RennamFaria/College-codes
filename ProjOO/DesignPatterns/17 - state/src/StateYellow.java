public class StateYellow implements State{
  public void warn(){
    System.out.println("-----");
    System.out.println("|   |");
    System.out.println("| O |\tYellow!");
    System.out.println("|   |");
    System.out.println("-----\n");
  }
}