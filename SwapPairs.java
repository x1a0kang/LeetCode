public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode listNode = swapPairs(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            // 交换
            prev.next = cur.next;
            cur.next = prev.next.next;
            prev.next.next = cur;
            // 交换后cur只要走一步，pre要走两步（这里必须要可视化才容易看出，更直观的方法是用node1和node2替代cur）
            prev = prev.next.next;
            cur = cur.next;
        }

        return dummy.next;
    }
}
