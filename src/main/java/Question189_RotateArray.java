/*
189. 旋转数组
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

示例 2:
输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]

说明:
尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
 */

public class Question189_RotateArray {
	public static void main(String[] args) {
		Solution189 solution189 = new Solution189();
		int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
		int k = 7;
		solution189.rotate(nums, k);
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
}

class Solution189 {
	public void rotate(int[] nums, int k) {
		int length = nums.length;

		if(length == 0 || length == 1) {
			return;
		}

		k = k % length;

		if(k == 0) {
		    return;
		}

		// 以最大公因数的轮数进行替换
		int count = gcd(length, k);

		for(int i = 0; i < count; i++) {
			int p = nums[i];
			int index = i;
			int circleCount = length / count;

			// 每轮替换次数为length / count
			for(int j = 0; j < circleCount - 1; j++) {
				int nextIndex = (index - k + length) % length;
				nums[index] = nums[nextIndex];
				index = nextIndex;
			}
			nums[index] = p;
		}
	}

	public int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
}