import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // java默认是小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.poll();
    }
}
