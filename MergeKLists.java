import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    // 也可以分治，两两合并，递归
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode temp;
        while (!pq.isEmpty()) {
            temp = pq.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next != null) {
                pq.add(temp.next);
            }
        }

        return head.next;
    }
}
