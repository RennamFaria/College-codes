public class Main {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore();

     State Green = new StateGreen();
     State Yellow = new StateYellow();
     State Red = new StateRed();
     State Off = new StateOff();
  
    for(int i = 0; i < 3; i++) {

      semaphore.setSignal(Green);
      
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        System.err.println("Error: " + e.getMessage());
      }

      semaphore.setSignal(Yellow);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.err.println("Error: " + e.getMessage());
      }

      semaphore.setSignal(Red);
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }

    semaphore.setSignal(Off);
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
}