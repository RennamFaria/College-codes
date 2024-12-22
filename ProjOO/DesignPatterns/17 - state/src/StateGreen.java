public class StateGreen implements State{
  public void warn(){
    System.out.println("-----");
    System.out.println("|   |");
    System.out.println("|   |\tGreen!");
    System.out.println("| O |");
    System.out.println("-----\n");
  }
}