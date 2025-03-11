public class MaxPathSumTree {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;
        // 左右如果小于零，直接排除
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        max = Math.max(max, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}
