import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    public static List<List<Integer>> res;

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> result = permute.permute(new int[]{1, 2, 3});
        System.out.println(Arrays.deepToString(result.toArray()));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        // []不适合后续操作，先转移到ArrayList中
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        dfs(arr, new ArrayList<>());
        return res;
    }

    public void dfs(List<Integer> arr, List<Integer> list) {
        // 当数组内没有数据了，说明一个排列完成
        if (arr.isEmpty()) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 记录本轮被选择的元素，删除后递归，再添加
        Integer removed;
        for (int i = 0; i < arr.size(); i++) {
            // 加入排列
            list.add(arr.get(i));
            // 删除当前元素
            removed = arr.remove(i);
            // 递归
            dfs(arr, list);
            // 把删除的元素添加回原数组
            arr.add(i, removed);
            // 排列中当前元素
            list.removeLast();
        }
    }
}
