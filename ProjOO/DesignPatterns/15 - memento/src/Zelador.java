import java.util.Stack;

public class Zelador {
    private Stack<PCDMemento> mementos;
    private static final int MAX_MEMENTOS = 3;

    public Zelador() {
        this.mementos = new Stack<PCDMemento>();
    }

    public void addMemento(PCDMemento memento) {
        if (mementos.size() == MAX_MEMENTOS) {
            mementos.remove(0);
        }
        mementos.push(memento);
    }

    public PCDMemento getMemento() {
        return mementos.isEmpty() ? null : mementos.pop();
    }

    public boolean hasMementos() {
        return !mementos.isEmpty();
    }
}