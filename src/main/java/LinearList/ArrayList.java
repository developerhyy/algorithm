package LinearList;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] data;
    private int size;

    public ArrayList(int capacity) {
        this.size = 0;
        data = (E[]) new Object[capacity];
    }

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E get(int index) {
        if(index <0 || index>=size)
            throw new IllegalArgumentException("数组下标越界...");
        return data[index];
    }

    public void set(int index, E e) {
        if(index <0 || index>=size)
            throw new IllegalArgumentException("数组下标越界...");
        data[index] = e;
    }

    public void add(int index, E e) {
        if(index < 0 || index>size)
            throw new IllegalArgumentException("数组下标越界...");
        if(size == data.length)
            grow(2*data.length);
        //往中间位置添加,插入位置后所有位置值往后移动一位
        for (int i = size-1; i >=index ; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;//添加成功
    }
    //o(1)
    public void addLast(E e){
        add(size,e);
    }
    //数组扩缩
    private void grow(int i) {
        /*	E[] newData = (E[]) new Object[newCapacity];
		for(int i=0; i<data.length; i++)
			newData[i] = data[i];

		data = newData;*/
        data= Arrays.copyOf(data,i);

    }

    public E remove(int index) {
        if(index <0 || index>=size)
            throw new IllegalArgumentException("数组下标越界...");
        E val=data[index];
        if(size < data.length >> 1){
            grow(data.length/2);
        }
        for (int i = index; i <size-1 ; i++) {
            data[i]=data[i+1];
        }
        data[size-1]=null;//pass
        size--;
        return val;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<100; i++){

            list.add(i, i);
        }

        for(int i=0; i<100; i++) {
            System.out.println("The " + i + "th element is: " + list.get(i));
        }

        for(int i=0; i<50; i+=8) {
            list.remove(i);
        }

        for(int i=0; i<list.getSize(); i++) {
            System.out.println("After removing, the " + i + "th element is: " + list.get(i));
        }

    }
}
