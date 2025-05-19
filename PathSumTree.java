import java.util.HashMap;
import java.util.Map;

public class PathSumTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 22));
    }

    public static int pathSum(TreeNode root, long targetSum) {
        if (root == null) return 0;
        int res = 0;
        res = dfs(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    public static int dfs(TreeNode root, long targetSum) {
        if (root == null) return 0;
        int res = 0;
        if (targetSum == root.val) {
            res++;
        }
        res += dfs(root.left, targetSum - root.val);
        res += dfs(root.right, targetSum - root.val);
        return res;
    }

    // 前缀和方式，有数组类似题
    public int pathSumAnother(TreeNode root, int targetSum) {
        // 哈希表记录之前所有的前缀和，和出现的次数
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfsAnother(root, prefix, 0, targetSum);
    }

    public int dfsAnother(TreeNode root, Map<Long, Integer> prefix, long cur, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res;
        // cur是当前的前缀和
        cur += root.val;
        // 用当前前缀和减target，如果差值在之前的前缀和里出现过，说明存在和为target的路径
        res = prefix.getOrDefault(cur - targetSum, 0);
        // 当前前缀和加入哈希表
        prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
        // 递归左右子节点
        res += dfsAnother(root.left, prefix, cur, targetSum);
        res += dfsAnother(root.right, prefix, cur, targetSum);

        // 这步很关键，当前前缀和减一，因为只能向下
        prefix.put(cur, prefix.getOrDefault(cur, 0) - 1);
        return res;
    }
}
