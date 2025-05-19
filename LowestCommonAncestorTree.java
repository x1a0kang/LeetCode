public class LowestCommonAncestorTree {
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        dfs(root, p, q);
        return res;
    }

    // 因为p和q一定不同，所以可以不需要temp，如果左右都是true，那一定是两个不同的节点，如果其中一个是true，当前节点又等于pq中的任意一个，那当前节点和之前是true的也肯定不是同一个
    // 用了Temp让判断条件看着更易读一点，就不改了
    public Temp dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new Temp();
        Temp left = dfs(root.left, p, q);
        Temp right = dfs(root.right, p, q);
        boolean hasP = left.hasP || right.hasP;
        boolean hasQ = left.hasQ || right.hasQ;

        if (root == p) {
            hasP = true;
        }
        if (root == q) {
            hasQ = true;
        }
        if (hasP && hasQ && res == null) {
            res = root;
        }
        return new Temp(hasP, hasQ);
    }

    class Temp {
        boolean hasP;
        boolean hasQ;

        public Temp(boolean hasP, boolean hasQ) {
            this.hasP = hasP;
            this.hasQ = hasQ;
        }

        public Temp() {
        }
    }

    // 大神的方法
    public TreeNode another(TreeNode root, TreeNode p, TreeNode q) {
        // 要想通的一点是，如果p在q的子树上，或者反过来，那先遇到的那个节点就是最近公共祖先，所以不需要再往下遍历
        if(root == null || root == p || root == q) return root;
        TreeNode left = another(root.left, p, q);
        TreeNode right = another(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
