public class ListNode {
    int val;
    ListNode next;
    ListNode random;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getRandom() {
        return random;
    }

    public void setRandom(ListNode random) {
        this.random = random;
    }
}
