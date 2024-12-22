import java.util.Vector;

public class VectorQueue implements Implementador {
  private Vector<Object> list = new Vector<>();

  @Override
  public void enqueue(Object o) {
    list.add(o);
  }

  @Override
  public Object dequeue(int i) {
    if (!isEmpty()) {
      return list.remove(i);
    }
    return null;
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public int size() {
    return list.size();
  }
}