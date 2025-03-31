public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int index;
        while (start <= end) {
            index = start + (end - start) / 2;
            if (nums[index] == target) {
                return index;
            }
            if (nums[index] < target) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums, 2));
    }
}
