import java.util.*;

public class LevelOrderTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(Arrays.deepToString(lists.toArray()));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        int size = queue.size();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            level.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
            if (level.size() == size) {
                res.add(level);
                level = new ArrayList<>();
                size = queue.size();
            }
        }
        return res;
    }
}
