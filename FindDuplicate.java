public class FindDuplicate {
    // 把数组整体看做链表，nums[i]当做当前节点的next指针，然后就会发现一定有环，剩下的就快慢指针解决即可
    // 理解起来比较抽象，不行就看leetcode题解
    public static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow!= fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }
}
