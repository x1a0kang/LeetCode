public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode cur = null;
        ListNode res = null;
        ListNode index = null;
        if (list1.val >= list2.val) {
            cur = list1;
            res = list2;
            index = list2;
        } else {
            cur = list2;
            res = list1;
            index = list1;
        }

        ListNode temp;
        while (cur != null) {
            if (index.next != null && cur.val >= index.next.val) {
                index = index.next;
            } else {
                temp = index.next;
                index.next = cur;
                cur = cur.next;
                index.next.next = temp;
            }
        }

        return res;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dum.next;
    }
}
