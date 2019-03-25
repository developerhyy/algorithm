package LinearList;

public interface Queue<E> {
    public int size();
    public boolean empty();
    //入队
    public void enqueue(E e);
    //出队
    public E dequeue();
    //查对首
    public E peek();
}
