package LinearList;

public interface Deque<E> {
    public int size();
    public boolean empty();
    public void addFirst(E e);
    public void addLast(E e);
    public void removeFirst();
    public void removeLast();
    public E peekFirst();
    public E peekLast();
}
