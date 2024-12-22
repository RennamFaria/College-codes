public class StateRed implements State{
  public void warn(){
    System.out.println("-----");
    System.out.println("| O |");
    System.out.println("|   |\tRed!");
    System.out.println("|   |");
    System.out.println("-----\n");
    
  }
}