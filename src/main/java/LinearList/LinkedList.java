package LinearList;

public class LinkedList<E> implements List<E> {
    /**
     * 升级1：将单链表中终端结点的指针端由空指针改为指向头结点，就使整个单链表形成一个环，这种头尾相连的单链表称为单循环链表，简称循环链表
     *
     * 升级2：双向循环链表是单向循环链表的每个结点中，再设置一个指向其前驱结点的指针域
     * 好处：可以进行两个方向的查找，但是插入和删除时比较麻烦
     */
    private class Node{
        private E data;//数据域
        private Node next;//后指针域
        private Node prev;//前指针域（双向循环链表）

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }

        public String toString(){
            return data.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E o) {
        Node p = head;
        while(p != null) {
            if(p.data.equals(o))
                return true;
            p = p.next;
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        int i = 0;
        Node prev = head;
        while (prev!=null){
            i++;
            if(prev.data.equals(e)){
                return i;
            }
            prev = prev.next;
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if(index<0 || index >= size) {
            throw new IllegalArgumentException("非法下标...");
        }

        Node p = head;
        for(int i=0; i<index; i++)
            p = p.next;

        return p.data;
    }

    @Override
    public void set(int index, E e) {
        if(index<0 || index >= size) {
            throw new IllegalArgumentException("非法下标...");
        }

        Node p = head;
        for(int i=0; i<index; i++)
            p = p.next;

        p.data = e;
    }

    @Override
    public void add(int index, E e) {
        if(index < 0 || index>size)
            throw new IllegalArgumentException("下标越界...");
        if(index == 0){
            addFirst(e);
        }else if(index ==size){
            addLast(e);
        }else{
            Node prev = head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = new Node(e,prev.next);
            size++;
        }
    }

    public void addFirst(E e){
        Node node = new Node(e,head);
        head = node;
        size++;
    }

    public void addLast(E e){
        Node node = new Node(e,null);
        if(head == null){
            head = node;
        }else{
            Node prev = head;
            while(prev.next != null){
                prev = prev.next;
            }
            prev.next=node;

        }
        //维护了尾节点后

//        Node node1 = new Node(e,tail);
//        if(head == null){
//            head = node1;
//            tail = node1;
//        }else if (tail == null) {
//            tail = node1;
//        }
        size ++;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index>=size)
            throw new IllegalArgumentException("下标越界...");

        if(index == 0){
            return removeFirst();
        }else if(index ==size - 1){
            return removeLast();
        }else {
            Node prev = head;
            //找到index的前一个节点
            for (int i = 0; i < index-1; i++) {
                prev = prev.next;
            }
            Node temp = prev.next;
            prev.next = prev.next.next;
            temp.next = null;
            size--;
            return temp.data;
        }
    }
    public E removeFirst(){
        if(head == null)
            return null;
        E result = head.data;
        head = head.next;
        size --;
        return result;
    }
    public E removeLast(){
        if(head == null)
            return null;
        E result;
        //就一个节点
        if(head.next == null){
            result = head.data;
            head = null;
        }else{
            //此处没有维护向前指针，所以只能head一个个往下找
            //找倒数第二个节点
            Node prev = head;
            while (prev.next.next != null) {
                prev = prev.next;
            }
            result = prev.next.data;
            prev.next=null;
        }
        size--;
        return result;
    }
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        for(int i=0; i<10; i++)
            list.add(i, i);

        for(int i=0; i<10; i++) {
            System.out.println("The " + i + "th element is: " + list.get(i));
        }

        list.remove(0);

        for(int i=0; i<list.getSize(); i++) {
            System.out.println("After removing, the " + i + "th element is: " + list.get(i));
        }

    }
}
