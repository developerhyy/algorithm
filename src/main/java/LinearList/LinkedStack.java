package LinearList;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {
    //好处：不要扩容，好实现
    //与数组实现相比top是一个Node<E>指针域
    static class Node<E>{
        public E data;//数据域
        public Node<E> next;//后继指针域

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> top;//栈顶，也是链表的头部（此处就不用管链表尾部了，简单实现，不维护链表尾部）
    private int size;

    public LinkedStack() {
        this.size = 0;
        this.top = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    /**
     * 注意思路
     * @param e
     */
    @Override
    public void push(E e) {
        Node<E> node = new Node(e,top);
        top = node;
        size++;
    }

    @Override
    public E pop() {
        if(size == 0)
            throw new EmptyStackException();
        E result = top.data;
        top = top.next;
        size--;
        return result;
    }

    @Override
    public E peek() {
        if(size == 0)
            throw new EmptyStackException();
        return top.data;
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<>();

        for(int i=0; i<20; i++) {
            stack.push(i+1);
        }

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        for(int i=0; i<18; i++) {
            System.out.println("The element is: " + stack.pop());
        }
    }
}
