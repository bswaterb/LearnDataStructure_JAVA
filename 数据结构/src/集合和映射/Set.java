package 集合和映射;

/**
 * Created by chaohui on 2020/8/9
 */
public interface Set<E> {
    //集合中不允许添加重复元素
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
