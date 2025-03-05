public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        int gap = 0;
        while (fast.next != null) {
            fast = fast.next;
            gap++;
            if (gap == n + 1) {
                slow = slow.next;
                gap--;
            }
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
