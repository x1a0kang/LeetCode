public class ReverseList {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode temp;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
