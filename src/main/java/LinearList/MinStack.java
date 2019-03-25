package LinearList;

import java.util.EmptyStackException;

public class MinStack {
        /** initialize your data structure here. */
        //压栈和删除更新最小值
        //并且维护两个栈：普通栈和最小值栈
        public class Stack<E>{
             class Node<E>{
                public E data;//数据域
                public Node<E> next;//后继指针域

                public Node(E data, Node<E> next) {
                    this.data = data;
                    this.next = next;
                }
            }
            private Node<E> head;
            private int size;

            public Stack() {
                this.size = 0;
                this.head = null;
            }
            public void push(E x) {
                Node node = new Node(x,head);
                head = node;
                size++;
            }
            public boolean empty() {
                return size == 0;
            }

            public E pop() {
                E result = head.data;
                head = head.next;
                size--;
                return result;

            }

            public E peek() {
                if(size<=0)
                    throw new EmptyStackException();
                return (E)head.data;
            }
        }

    private Stack<Integer> data;
    private Stack<Integer> min;
    public MinStack() {
        data = new Stack();
        min = new Stack();
    }

    public void push(int x) {
        data.push(x);
        if(min.empty() || x<= min.peek())
            min.push(x);
    }

    public void pop() {
        int i = data.pop();
        if (!min.empty() || i== min.peek()) {
            min.pop();
        }
    }

    public int top() {

        //System.out.println(data.peek());
        return data.peek();

    }

    public int getMin() {
        System.out.println(min.peek());
        return min.peek();
    }




    public static void main(String[] args) {
     /*   MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        //minStack.push(-3);
        minStack.getMin();   //--> 返回 -3.
        minStack.pop();
        minStack.top();     // --> 返回 0.
        minStack.getMin();   //--> 返回 -2.*/

        MinStack obj = new MinStack();
         obj.push(1);
         obj.push(0);
        obj.pop();
       int param_3 = obj.top();
       int param_4 = obj.getMin();
    }
}
