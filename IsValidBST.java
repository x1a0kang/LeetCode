import java.util.Deque;
import java.util.LinkedList;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 核心原理，不能仅通过left<root<right判断，否则可能在下层出现右子树的节点比左子树的节点小的情况，所以必须传入最大和最小值
    public boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }

    // 二叉树搜索树的中序遍历，结果一定是递增数组
    public boolean another(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
