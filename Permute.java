import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(Arrays.deepToString(permute.toArray()));
    }

    public static List<List<Integer>> res;

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        dfs(arr, new ArrayList<>());
        return res;
    }

    public static void dfs(List<Integer> arr, List<Integer> list) {
        if (arr.isEmpty()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            list.add(arr.get(i));
            arr.remove(i);
            dfs(arr, list);
            arr.add(i, list.getLast());
            list.removeLast();
        }
    }
}
