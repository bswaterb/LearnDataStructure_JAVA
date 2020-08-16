package 线段树;

/**
 * Created by chaohui on 2020/8/10
 */
public class IntegerMerger implements Merger<Integer> {
    @Override
    public Integer merge(Integer a, Integer b) {
        return a + b;
    }
}
