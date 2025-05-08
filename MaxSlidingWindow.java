import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    // 维护一个单调队列，让获取当前窗口最大值是常数时间复杂度
    // 单调队列的原则是，当前数加入队列时，之前的比当前数小的数全部删除，因为之前的更小的数会比当前的数更早离开窗口，在窗口内也比当前数小，没有在队列中的必要
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        // 先让右指针走到窗口大小
        for (int i = 0; i < k; i++) {
            // 之前的比当前数小的数全部删除
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        // 此时第一个窗口形成，填入第一个最大值
        res[0] = deque.getFirst();
        // 窗口平移
        for (int i = k; i < nums.length; i++) {
            // 如果窗口左边界是单调队列的第一个值，从队列中删除
            if (deque.getFirst().equals(nums[i - k])) {
                deque.removeFirst();
            }
            // 之前的比当前数小的数全部删除
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            // 填入当前窗口的最大值
            res[i - k + 1] = deque.getFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
