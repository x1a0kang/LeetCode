import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildTree {
    private static Map<Integer, Integer> map;

    public static void main(String[] args) {
        LevelOrderTree levelOrderTree = new LevelOrderTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        List<List<Integer>> order = levelOrderTree.levelOrder(root);
        System.out.println(Arrays.toString(order.toArray()));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd || pStart > preorder.length - 1 || iStart > inorder.length - 1) {
            return null;
        }
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        if (index != -1) {
            root.left = buildTree(preorder, pStart + 1, pStart + (index - iStart), inorder, iStart, index - 1);
            root.right = buildTree(preorder, pStart + (index - iStart) + 1, pEnd, inorder, index + 1, iEnd);
        }
        return root;
    }
}
