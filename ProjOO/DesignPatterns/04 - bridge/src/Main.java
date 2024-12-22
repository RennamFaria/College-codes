
public class Main {
  public static void main(String[] args) {
    Queue arrayListQueue = new FIFOQueue(new ArrayListQueue());
    arrayListQueue.enqueue("Teste 1");
    arrayListQueue.enqueue("Teste 2");

    System.out.println(arrayListQueue.dequeue());
  }
}