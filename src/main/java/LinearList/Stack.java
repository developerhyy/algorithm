package LinearList;

/**
 * 业务很少用到，但底层和算法中经常用到，比如二叉树便利，算数表达式，编译器，内存模型的操作数栈，栈帧等等
 * @param <E>
 */
public interface Stack<E> {
    public int size();
    public boolean empty();
    public void push(E e);
    //弹栈
    public E pop();
    //查栈顶（不弹栈）
    public E peek();
}
