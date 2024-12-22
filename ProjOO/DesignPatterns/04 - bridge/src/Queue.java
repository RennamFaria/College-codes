public abstract class Queue {
  protected Implementador implementador;

  public Queue(Implementador implementador) {
    this.implementador = implementador;
  }

  public void enqueue(Object o) {
    implementador.enqueue(o);
  }

  public Object dequeue(int i) {
    return implementador.dequeue(i);
  }

  public boolean isEmpty() {
    return implementador.isEmpty();
  }

  public int size() {
    return implementador.size();
  }
}