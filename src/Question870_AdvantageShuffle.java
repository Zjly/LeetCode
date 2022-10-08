import java.util.Arrays;

/**
 * 870. 优势洗牌
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * <p>
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= 105
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 109
 */

public class Question870_AdvantageShuffle {
	public static void main(String[] args) {
		Solution870 solution870 = new Solution870();
		int[] nums1 = {12, 24, 8, 32};
		int[] nums2 = {13, 25, 32, 11};
		System.out.println(Arrays.toString(solution870.advantageCount(nums1, nums2)));
	}
}

class Solution870 {
	public int[] advantageCount(int[] nums1, int[] nums2) {
		int length = nums2.length;
		int[][] nums2Index = new int[length][2];

		for(int i = 0; i < length; i++) {
			nums2Index[i][0] = nums2[i];
			nums2Index[i][1] = i;
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2Index, (a, b) -> b[0] - a[0]);

		int[] result = new int[length];
		int left = 0;
		int right = length - 1;
		for(int i = 0; i < length; i++) {
			if(nums2Index[i][0] < nums1[right]) {
			    result[nums2Index[i][1]] = nums1[right];
				right--;
			} else {
				result[nums2Index[i][1]] = nums1[left];
				left++;
			}
		}

		return result;
	}
}
