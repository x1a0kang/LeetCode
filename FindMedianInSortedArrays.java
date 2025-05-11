class FindMedianInSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        FindMedianInSortedArrays f = new FindMedianInSortedArrays();
        System.out.println(f.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        double median;
        // 判断是奇数还是偶数，偶数需要计算两个位置的平均值
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            median = get(nums1, nums2, midIndex);
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            median = (get(nums1, nums2, midIndex1) + get(nums1, nums2, midIndex2)) / 2.0;
        }
        return median;
    }

    // 用双指针分别在两个数组内移动
    public int get(int[] nums1, int[] nums2, int index) {
        int pos1 = 0, pos2 = 0;
        while (pos1 < nums1.length && pos2 < nums2.length && index > 0) {
            // 哪个数组内的数小，就移动那个数组内的指针
            if (nums1[pos1] <= nums2[pos2]) {
                pos1++;
            } else {
                pos2++;
            }
            index--;
        }
        // 可能有一个数组内先走完，剩下的都在另一个数组内走
        if (pos1 >= nums1.length) {
            return nums2[pos2 + index];
        }
        if (pos2 >= nums2.length) {
            return nums1[pos1 +index];
        }
        // 如果两个数组都没走完，那取相对较小的那一个
        return Math.min(nums1[pos1], nums2[pos2]);
    }
}