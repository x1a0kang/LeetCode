import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    // 也可以分治，两两合并，递归
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        // 维护一个最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        // 先把所有头节点都放进去
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode temp;
        // 一直弹出堆顶元素，并加入弹出元素的next
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
