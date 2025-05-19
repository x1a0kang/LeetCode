public class FlattenTree {
    public static void main(String[] args) {
        FlattenTree ft = new FlattenTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        ft.flatten(root);
    }

    // 核心原理是：左子树的最右节点，连接到右子树的第一个节点
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        // 这个修改连接的操作必须在后面做，否则会影响遍历
        if (root.left != null) {
            // 找到左子树的最后一个节点
            TreeNode last = getLast(root.left);
            // 左子树的最后一个节点，连接到右子树的第一个节点
            last.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    // 找到最右节点
    private TreeNode getLast(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // 不递归的方法，把左子树的最右节点连接到根的右节点，再把根的右子树连接改成左子树，根向右节点移动，依次循环到null也就是右子树的底部
    public void another(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        // 从根节点出发
        while (cur != null) {
            TreeNode move = cur.left;
            // 找到左子树的最右节点
            while (move != null && move.right != null) {
                move = move.right;
            }
            // 交换位置
            if (move != null) {
                move.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            // 此时，当前节点已没有左子树，只要向右移动即可
            cur = cur.right;
        }
    }
}
