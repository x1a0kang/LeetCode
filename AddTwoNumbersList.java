public class AddTwoNumbersList {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = new ListNode(0);
        ListNode cur = head;

        boolean flag = false;
        int val1;
        int val2;
        int sum;
        while (list1 != null || list2 != null) {
            if (list1 != null) {
                cur.next = list1;
            } else {
                cur.next = list2;
            }

            val1 = list1 == null ? 0 : list1.val;
            val2 = list2 == null ? 0 : list2.val;
            sum = val1 + val2;
            if (flag) {
                sum += 1;
            }
            if (sum > 9) {
                sum -= 10;
                flag = true;
            } else {
                flag = false;
            }
            cur.next.val = sum;

            list1 = list1 == null ? null : list1.next;
            list2 = list2 == null ? null : list2.next;
            cur = cur.next;
        }

        if (flag) {
            cur.next = new ListNode(1);
        }

        return head.next;
    }
}
