import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：[3]
 * <p>
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * 示例 3：
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * <p>
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */

public class Question229_MajorityElementII {
	public static void main(String[] args) {

	}
}

class Solution229 {
	public List<Integer> majorityElement(int[] nums) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int num : nums) {
			hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
		}
		int count = nums.length / 3;

		List<Integer> result = new ArrayList<>();
		for(HashMap.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			if(entry.getValue() > count) {
			    result.add(entry.getKey());
			}
		}

		return result;
	}
}
