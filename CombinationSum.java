import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> res;
    private List<Integer> path;

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int start) {
        // 每次选择后从target中减去当前元素，因此当target小于0时，说明当前元素已经大于target，不需要继续递归了
        if (target <= 0) {
            // 如果target等于0，说明已经找到一个组合，加入结果集
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        // start用于跳过已经选用的元素，因为是组合，12和21是重复的，所以到2时，不用再往回选1，因为在选1时，一定有12出现过了
        for (int i = start; i < candidates.length; i++) {
            // 选择元素
            path.add(candidates[i]);
            // 因为每个元素可以重复选择，所以这里i不用加一
            dfs(candidates, target - candidates[i], i);
            // 删除元素
            path.removeLast();
        }
    }
}
