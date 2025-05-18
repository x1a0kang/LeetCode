import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals m = new MergeIntervals();
        int[][] merged = m.merge(new int[][]{{1, 4}, {4, 5}});
        for (int[] i : merged) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println(Arrays.deepToString(merged));
    }

    public int[][] merge(int[][] intervals) {
        // 先根据每个区间的开头排序
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 如果当前数组的左边界小于前一个数组的右边界，合并，否则不重合，直接加入res
            if (interval[0] <= res.getLast()[1]) {
                res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
