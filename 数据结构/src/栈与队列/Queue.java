package 栈与队列;

/**
 * Created by chaohui on 2020/8/7
 */
public interface Queue<E> {
    //入队
    void enqueue(E e);

    //出队
    E dequeue();

    //取队首元素
    E getFront();

    //获取队列中元素个数
    int getSize();

    //队列判空
    boolean isEmpty();
}
