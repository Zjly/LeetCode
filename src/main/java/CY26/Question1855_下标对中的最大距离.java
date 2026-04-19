package CY26;

/**
 * @author ZhangLei
 * @version 2026/04/19 12:48
 */
public class Question1855_下标对中的最大距离 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int index1 = nums1.length - 1;
        int index2 = nums2.length - 1;

        int res = 0;
        while (index1 >= 0 && index2 >= 0) {
            if (index1 > index2) {
                index1--;
            }

            if (nums1[index1] <= nums2[index2]) {
                res = Math.max(res, index2 - index1);
                index1--;
            } else {
                index2--;
            }
        }

        return res;
    }
}
