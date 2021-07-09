import java.util.Arrays;

/**
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 * 示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：[3,2]
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */

public class Question17_10_FindMajorityElementLCCI {
	public static void main(String[] args) {

	}
}

class Solution17_10 {
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);

		int rNum = nums[nums.length / 2];
		int count = 0;
		for(int num : nums) {
			if(num == rNum) {
			    count++;
			}
		}

		if(count > nums.length / 2) {
		    return rNum;
		}
		return -1;
	}
}