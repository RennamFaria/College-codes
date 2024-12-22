public interface Implementador {
  void enqueue(Object o);
  Object dequeue(int i);
  boolean isEmpty();
  int size();
}