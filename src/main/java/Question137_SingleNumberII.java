import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */

public class Question137_SingleNumberII {
	public static void main(String[] args) {

	}
}

class Solution137 {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int num : nums) {
			hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
		}

		for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			if(entry.getValue() == 1) {
			    return entry.getKey();
			}
		}

		return 0;
	}
}