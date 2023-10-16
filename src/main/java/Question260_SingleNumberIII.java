import java.util.HashMap;
import java.util.Map;

/**
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * <p>
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * <p>
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * <p>
 * 提示：
 * 2 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 */

public class Question260_SingleNumberIII {
	public static void main(String[] args) {

	}
}

class Solution260 {
	public int[] singleNumber(int[] nums) {
		int[] result = new int[2];
		int index = 0;

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int num : nums) {
			hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
		}

		for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			if(entry.getValue() == 1) {
				result[index] = entry.getKey();
				index++;
			}
		}

		return result;
	}
}

class Solution260_2 {
	public int[] singleNumber(int[] nums) {
		int xorSum = 0;
		for (int num : nums) {
			xorSum = xorSum ^ num;
		}

		int sign = xorSum & -xorSum;
		int num1 = 0;
		int num2 = 0;
		for (int num : nums) {
			if ((num & sign) == 0) {
			    num1 = num1 ^ num;
			} else {
			    num2 = num2 ^ num;
			}
		}

		return new int[]{num1, num2};
	}
}