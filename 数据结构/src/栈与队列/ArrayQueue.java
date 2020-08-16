package 栈与队列;

import 数组.Array;

/**
 * Created by chaohui on 2020/8/7
 */
//数组队列，单向线性
public class ArrayQueue<E> implements Queue<E> {
    //基于 数组.Array 实现的队列
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    //入队
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    //出队
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    //取队首元素
    @Override
    public E getFront() {
        return array.get(0);
    }

    //获取队列元素个数
    @Override
    public int getSize() {
        return array.getSize();
    }

    //队列判空
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    //重写toString
    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
