import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> res;
    public static List<Integer> path;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(candidates, target, 0);
        return res;
    }

    public static void dfs(int[] candidates, int target, int start) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
