package 数组;


/**
 * Created by chaohui on 2020/8/6
 */
public class Array<E> {
    private E[] data;
    private int size;

    //构造方法，传入数组容量
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参构造，默认开辟容量10
    public Array() {
        this(10);
        size = 0;
    }

    //获取数组包含元素的个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //数组判空
    public boolean isEmpty() {
        return size == 0;
    }

    //向数组尾添加元素(顺序添加）
    public void addLast(E e) {
        add(size, e);
    }

    //向数组头添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //向数组内指定下标添加元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("传参有误，下标不能小于0或大于数组元素个数");
        }
        //如果此时数组已满，则对其进行扩容
        if (size == data.length) {
            resize(data.length * 2);
        }
        //将index右边的数组元素向右移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        //在index下标处插入元素e
        data[index] = e;
        size++;
    }

    //获取指定下标的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("获取失败，下标不合法！");
        }
        return data[index];
    }

    //修改index下标位置的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("修改失败，下标不合法！");
        }
        data[index] = e;
    }

    //查找数组中是否存在元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //寻找并返回数组中元素e的下标，若不存在此元素，则返回 -1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //将数组中指定下标位置元素移除，并返回被删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("删除失败，下标不合法！");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; //释放空间
        //当数组元素个数小于总容量的1/4时，对其进行缩容操作
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    //移除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    //移除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    //移除一个指定元素，如果这个元素不存在则不进行任何操作
    public boolean removeElement(E e) {
        int index;
        //如果数组中存在此元素，则删除它
        if ((index = find(e)) != -1) {
            remove(index);
            return true;
        }
        //否则不进行其他操作
        return false;
    }

    //移除数组中所有指定元素
    public boolean removeAllElement(E e) {
        int index;
        while ((index = find(e)) != -1) {
            remove(index);
        }
        if (index == -1) {
            //数组中已没有元素e
            return true;
        } else {
            return false;
        }
    }

    //扩容数组
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("索引不合法！");
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //重写toString方法输出数组元素
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size= %d,capacity= %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
