package 链表与递归;

/**
 * Created by chaohui on 2020/8/8
 */
public class Sum {
    //递归求解数组元素和
    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    //计算arr[l..n]区间内所有数字的和
    public static int sum(int[] arr, int l) {
        //递归出口
        if (l == arr.length) {
            return 0;
        } else {
            return arr[l] + sum(arr, l + 1);
        }
    }
}
