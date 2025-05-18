import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IsPalindromeList {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        // 先把链表中的节点都遍历出来
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size() - 1;
        // 然后左右指针判断是否回文
        while (left < right) {
            if (!Objects.equals(list.get(left), list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 空间复杂度是O1的方法时，先找到中点，反转后半部分链表，然后同时遍历前后两半链表
    public boolean isPalindrome2(ListNode head) {
        return false;
    }
}
