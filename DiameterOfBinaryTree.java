public class DiameterOfBinaryTree {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int temp = Math.max(left, right);
        return Math.max(leftDepth + rightDepth, temp);
    }


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

    // 官方题解，在深度优先遍历时计算经过的节点数
    public int diameterOfBinaryTree1(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
