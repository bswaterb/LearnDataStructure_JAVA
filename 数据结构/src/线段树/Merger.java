package 线段树;

/**
 * Created by chaohui on 2020/8/10
 */
public interface Merger<E> {
    //将a和b转为一个元素（通过加减操作、合并操作等）进行返回
    E merge(E a, E b);
}
