public class FIFOQueue extends Queue {
  public FIFOQueue(Implementador implementador) {
    super(implementador);
  }

  @Override
  public Object dequeue() {
    return implementador.dequeue(0); // Remover o elemento no índice 0
  }
}