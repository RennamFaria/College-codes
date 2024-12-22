public class Semaphore {
  public final State Green, Yellow, Red, Off;

  private State signal;
  
  public Semaphore(){
    this.Green = new StateGreen();
    this.Yellow = new StateYellow();
    this.Red = new StateRed();
    this.Off = new StateOff();
  }

  public void setSignal(State signal){
    this.signal = signal;
    signal.warn();
  }

  public void warn(){
    signal.warn();
  }
  
}