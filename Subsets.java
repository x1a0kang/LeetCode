import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> res;
    public static List<Integer> path;

    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        path = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    public static void dfs(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            dfs(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
