package 栈与队列;

import 数组.Array;

/**
 * Created by chaohui on 2020/8/7
 */
public class ArrayStack<E> implements Stack<E> {
    //基于 数组.Array 实现的栈
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    //获取栈内元素个数
    @Override
    public int getSize() {
        return array.getSize();
    }

    //判断栈是否为空
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    //向栈内压入元素e
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    //从栈顶弹出元素e
    @Override
    public E pop() {
        return array.removeLast();
    }

    //取栈顶元素
    @Override
    public E peek() {
        return array.get(array.getSize() - 1);
    }

    //获得栈容量
    public int getCapacity() {
        return array.getCapacity();
    }

    //重写toString方法，输出栈内所有元素
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append("，");
            }
        }
        res.append("] top");
        return res.toString();
    }

}
