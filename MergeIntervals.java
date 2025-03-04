import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] merged = merge(new int[][]{{1, 4}, {4, 5}});
        for (int[] i : merged) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] merge(int[][] intervals) {
        // 先根据每个区间的开头排序
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= res.getLast()[1]) {
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
