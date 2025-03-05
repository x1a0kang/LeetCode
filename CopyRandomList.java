import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    public static void main(String[] args) {

    }

    public ListNode copyRandomList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curNew = dummy;
        ListNode curOld = head;
        Map<ListNode, ListNode> map = new HashMap<>();
        while (curOld != null) {
            curNew.next = new ListNode(curOld.val);
            map.put(curOld, curNew.next);
            curNew = curNew.next;
            curOld = curOld.next;
        }

        curNew = dummy.next;
        curOld = head;
        while (curNew != null) {
            curNew.random = map.get(curOld.random);
            curNew = curNew.next;
            curOld = curOld.next;
        }

        return dummy.next;
    }

    // 拼接+拆分，构建新链表时，把原链表的节点放在新链表节点前，第二遍遍历时，老链表节点random的next就是新节点的random
//    public Node copyRandomList(Node head) {
//        if(head == null) return null;
//        Node cur = head;
//        // 1. 复制各节点，并构建拼接链表
//        while(cur != null) {
//            Node tmp = new Node(cur.val);
//            tmp.next = cur.next;
//            cur.next = tmp;
//            cur = tmp.next;
//        }
//        // 2. 构建各新节点的 random 指向
//        cur = head;
//        while(cur != null) {
//            if(cur.random != null)
//                cur.next.random = cur.random.next;
//            cur = cur.next.next;
//        }
//        // 3. 拆分两链表
//        cur = head.next;
//        Node pre = head, res = head.next;
//        while(cur.next != null) {
//            pre.next = pre.next.next;
//            cur.next = cur.next.next;
//            pre = pre.next;
//            cur = cur.next;
//        }
//        pre.next = null; // 单独处理原链表尾节点
//        return res;      // 返回新链表头节点
//    }
}
