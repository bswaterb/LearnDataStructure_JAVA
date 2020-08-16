package 栈与队列;

/**
 * Created by chaohui on 2020/8/7
 */
//栈接口
public interface Stack<E> {
    //获取栈内元素个数
    int getSize();

    //判断栈是否为空
    boolean isEmpty();

    //入栈
    void push(E e);

    //出栈
    E pop();

    //取栈顶元素
    E peek();

}
