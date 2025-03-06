public class MaxDepthTree {

    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        res += Math.max(left, right) + 1;
        return res;
    }
}
