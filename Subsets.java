import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private List<List<Integer>> res;
    private List<Integer> path;

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        // 添加空集
        res.add(new ArrayList<>());
        path = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int start) {
        // start用于跳过已经选用的元素，因为子集是组合，12和21是重复的，所以到2时，不用再往回选1，因为在选1时，一定有12出现过了
        for (int i = start; i < nums.length; i++) {
            // 加入当前元素
            path.add(nums[i]);
            // 加入结果集
            res.add(new ArrayList<>(path));
            dfs(nums, i + 1);
            // 删除当前元素
            path.removeLast();
        }
    }
}
