public class MajorityElement {
    // 摩尔投票算法，选取一个数作为众数，遇到相同的数就+1，不相同就-1，如果票数为零，就选当前的数作为众数，继续计票，直到数组的最后
    // 因为众数大于半数，票数一定大于其他元素，最后一定是众数的票数大于零
    public int majorityElement(int[] nums) {
        int vote = 0;
        int res = 0;
        for (int num : nums) {
            if (vote == 0) {
                res = num;
            }
            if (num == res) {
                vote++;
            } else {
                vote--;
            }
        }
        return res;
    }
}
