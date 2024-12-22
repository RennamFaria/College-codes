import java.util.ArrayList;

public class ArrayListQueue implements Implementador {
  private ArrayList<Object> list = new ArrayList<>();

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