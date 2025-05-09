public class ReverseKGroupList {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        // 记录待反转子链表的前置节点
        ListNode pre = dummy;
        // 待反转子链表的起始节点
        ListNode start = head;
        // 待反转子链表的终止节点
        ListNode end = start;
        // 记录待反转子链表的后置节点
        ListNode next;
        while (true) {
            // 找到待反转子链表的终止节点
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果终止节点为空，则是长度不足，不需要反转，终止循环
            if (end == null) {
                break;
            }
            // 记录待反转子链表的后置节点
            next = end.next;
            // 断开终止节点的后续节点，这一步很重要，为了后续的反转做准备
            end.next = null;

            // 反转
            reverse(start);

            // 反转后end成为头结点，start成为尾节点，因此让前置节点pre连接到头结点end，尾节点start连接到后置节点next，这样之前断开的链表又重新连上了
            pre.next = end;
            start.next = next;

            // 进入下一轮循环，下一轮的前置节点就是本轮的尾节点start，下一轮的start就是本轮的next，end和start保持一致，在每轮的开始向后寻找
            pre = start;
            start = next;
            end = start;
        }
        return dummy.next;
    }

    public void reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
