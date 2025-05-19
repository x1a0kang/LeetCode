import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildTree {
    private static Map<Integer, Integer> map;

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        LevelOrderTree levelOrderTree = new LevelOrderTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree.buildTree(preorder, inorder);
        List<List<Integer>> order = levelOrderTree.levelOrder(root);
        System.out.println(Arrays.toString(order.toArray()));
    }

    // 核心原理就是找到根节点，从中序中找到左右子树的范围，然后递归
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        // 记录中序数组中所有数字的下标，方便后续直接定位
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd || pStart > preorder.length - 1 || iStart > inorder.length - 1) {
            return null;
        }
        // 前序第一个节点是根节点
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        // 从中序中找到根节点的下标，左边是左子树，右边是右子树
        int index = map.get(rootVal);
        if (index != -1) {
            root.left = buildTree(preorder, pStart + 1, pStart + (index - iStart), inorder, iStart, index - 1);
            root.right = buildTree(preorder, pStart + (index - iStart) + 1, pEnd, inorder, index + 1, iEnd);
        }
        return root;
    }
}
