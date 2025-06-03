import java.util.*;

public class BuildTreeFromLayer {
    public static void main(String[] args) {
        BuildTreeFromLayer buildTreeFromLayer = new BuildTreeFromLayer();
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        for (String s : split) {
            if ("null".equalsIgnoreCase(s)) {
                arr.add(null);
            } else {
                arr.add(Integer.parseInt(s));
            }
        }
        TreeNode treeNode = buildTreeFromLayer.buildTree(arr);
        LevelOrderTree levelOrderTree = new LevelOrderTree();
        List<List<Integer>> order = levelOrderTree.levelOrder(treeNode);
        System.out.println(Arrays.deepToString(order.toArray()));
    }

    /**
     * 根据层序遍历列表构建二叉树
     *
     * @param arr 层序遍历节点值列表，null表示缺失节点
     * @return 构建完成的二叉树根节点
     */
    public TreeNode buildTree(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            return null;
        }
        // 初始化队列用于层序构建
        Queue<TreeNode> queue = new LinkedList<>();
        // 创建根节点
        TreeNode root = new TreeNode(arr.getFirst());
        queue.add(root);
        int i = 1;
        // 层序构建二叉树
        while (i < arr.size()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                continue;
            }
            // 构建左子树，要判断是否是null，否则会抛出空指针异常
            if (arr.get(i) != null) {
                poll.left = new TreeNode(arr.get(i));
                queue.add(poll.left);
            }
            i++;
            // 构建右子树，要判断是否是null，否则会抛出空指针异常
            if (i < arr.size() && arr.get(i) != null) {
                poll.right = new TreeNode(arr.get(i));
                queue.add(poll.right);
            }
            i++;
        }
        return root;
    }
}
