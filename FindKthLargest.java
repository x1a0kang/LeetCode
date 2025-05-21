import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // java默认是小顶堆，堆内要维持k的大小
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        // 先加入k个元素
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        // 再从k位置开始遍历，保持栈内k个元素是最大的k个元素，那么堆顶就是第k大的元素
        for (int i = k; i < nums.length; i++) {
            // 如果当前元素小于堆顶，直接跳过，大于堆顶，弹出堆顶，加入当前元素
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.poll();
    }
}
