package 链表与递归;

/**
 * Created by chaohui on 2020/8/8
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    //根据传入的数组建立链表
    public ListNode(int arr[]) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("传入数组为空！");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    //重写toString
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
