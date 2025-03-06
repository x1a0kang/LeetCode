import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IsSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        return compare(root.left, root.right);
    }

    // 对比两个树，树1的左子树和树2的右子树相同，且树1的右子树和树2的左子树相同，这两个树对称
    public boolean compare(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return compare(root1.left, root2.right) && compare(root1.right, root2.left);
    }
}
