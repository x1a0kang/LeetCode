import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 用map计数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 用最小堆进行排序
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        // Comparator的另一种方式，实现最大堆
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        pq.addAll(map.entrySet());
        // 弹出最大堆顶k个元素
        int index = 0;
        int[] res = new int[k];
        while (index < k) {
            res[index++] = pq.poll().getKey();
        }
        return res;
    }
}
