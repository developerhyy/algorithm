package LinearList;

public interface List<E> {
    //计算表的长度n
    public int getSize();
    //判断表是否为空
    public boolean isEmpty();
    //判断表中是否包含某个元素o
    boolean contains(E o);
    public int indexOf(E e);
    //在表中查找某个元素o
    public E get(int index);
    //设置第i个元素，0≤i < n
    public void set(int index, E e);
    //将新元素插入第i个位置，0≤i < n
    public void add(int index, E e);
    //删除第i个元素，0≤i < n
    public E remove(int index);
}
