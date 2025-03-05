import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IsPalindromeList {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!Objects.equals(list.get(left), list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
