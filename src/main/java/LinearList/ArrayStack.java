package LinearList;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {

    private static final int DEFAUT_CAPACITY=10;
    private E[] data;
    private int size;
    //栈顶指针
    private int top;

    public ArrayStack() {
        this(DEFAUT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
        this.top = -1;//初始化栈顶指针,,-1才对
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public void push(E e) {
        if(size == data.length){
            grow(data.length * 2);
        }
        data[++top] = e;
        size++;
    }

    private void grow(int capacity) {
        //优化
        if(capacity <= DEFAUT_CAPACITY)
            return;
        data = Arrays.copyOf(data,capacity);
    }

    @Override
    public E pop() {
        //校验
        if(size ==0)
            throw new EmptyStackException();
        //E result = data[top];
        //data[top] = null;
        //top--;
        size--;
        if(size < data.length/2){
            grow(data.length / 2);
        }
        //优化
        return data[top--];
    }

    @Override
    public E peek() {
        //校验
        if(size ==0)
            throw new EmptyStackException();
        return data[top];
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();

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
