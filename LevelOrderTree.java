import java.util.*;

public class LevelOrderTree {
    public static void main(String[] args) {
        LevelOrderTree levelOrderTree = new LevelOrderTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrderTree.levelOrder(root);
        System.out.println(Arrays.deepToString(lists.toArray()));
    }

    // 核心原理，用队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 先加入根节点
        queue.add(root);
        // 答案列表
        List<List<Integer>> res = new ArrayList<>();
        // 每层列表
        List<Integer> level = new ArrayList<>();
        // 记录当前层加入了多少个节点
        int size = queue.size();
        while (!queue.isEmpty()) {
            // 弹出节点，再加入弹出节点的左右子节点
            TreeNode poll = queue.poll();
            level.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
            // 如果当前层的list已经和size大小相同，说明当前层已经全部弹出，清空当前层列表，queue里剩下的都是下一层的节点，更新size
            if (level.size() == size) {
                res.add(level);
                level = new ArrayList<>();
                size = queue.size();
            }
        }
        return res;
    }
}
