package 堆和优先队列;

import 数组.Array;

/**
 * Created by chaohui on 2020/8/11
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>();
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("0号索引无父亲节点！");
        return (index - 1) / 2;
    }

    //返回左儿子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回右儿子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //将加入的元素上浮到合适位置
    private void siftUp(int k) {
        //如果k>0且 k的父亲节点小于k，则需要在大顶堆中进行交换
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //查看堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("堆为空！");
        }
        return data.get(0);
    }

    //向堆中取出元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    //将取出的元素下沉
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            //如果右孩子比左孩子的值要大
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            //如果父亲节点的值大于等于左右孩子的最大值，那么退出循环
            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
                //否则将父亲节点与左右孩子中最大的那个节点进行交换
            else
                data.swap(k, j);
            //继续下沉
            k = j;
        }
    }

    //取出堆中最大元素并替换为元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

}
