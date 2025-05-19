public class KthSmallestInBST {
    int k;
    int res;

    // 核心原理是二叉搜索树的中序遍历是递增数组，第k小的数就是中序遍历的第k个数
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        this.k = k;
        dfs(root);
        return res;
    }

    // 中序遍历
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        // 这里root是第n个数，每次计数k减一，如果当前k等于1，当前root的值就是res
        if (k == 1) {
            res = root.val;
        }
        k--;
        // 如果k等于0，说明已经遍历了超过k个数，后面直接跳过
        if (k == 0) {
            return;
        }
        dfs(root.right);
    }
}
