import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 659. 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * <p>
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * <p>
 * 示例 2：
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * <p>
 * 示例 3：
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 * <p>
 * 提示：
 * 输入的数组长度范围为 [1, 10000]
 */

public class Question659_SplitArrayIntoConsecutiveSubsequences {
	public static void main(String[] args) {
		Solution659 solution659 = new Solution659();
		int[] nums = new int[]{1, 2, 3, 4, 4, 5};
		System.out.println(solution659.isPossible(nums));

	}
}

class Solution659 {
	public boolean isPossible(int[] nums) {
		HashMap<Integer, Integer> remainCountHashMap = new HashMap<>();
		HashMap<Integer, Integer> numEndCountHashMap = new HashMap<>();

		// 初始化哈希表
		for(int num : nums) {
			remainCountHashMap.put(num, remainCountHashMap.getOrDefault(num, 0) + 1);
			numEndCountHashMap.put(num, 0);
		}

		for(int num : nums) {
			if(remainCountHashMap.get(num) > 0) {
				// 存在结尾为num - 1的子序列
				if(numEndCountHashMap.containsKey(num - 1) && numEndCountHashMap.get(num - 1) > 0) {
					remainCountHashMap.put(num, remainCountHashMap.get(num) - 1);
					numEndCountHashMap.put(num - 1, numEndCountHashMap.get(num - 1) - 1);
					numEndCountHashMap.put(num, numEndCountHashMap.get(num) + 1);
				}
				// 新建子序列，判断后续字符是否足够
				else if(remainCountHashMap.containsKey(num + 1) && remainCountHashMap.get(num + 1) > 0 && remainCountHashMap.containsKey(num + 2) && remainCountHashMap.get(num + 2) > 0) {
					remainCountHashMap.put(num, remainCountHashMap.get(num) - 1);
					remainCountHashMap.put(num + 1, remainCountHashMap.get(num + 1) - 1);
					remainCountHashMap.put(num + 2, remainCountHashMap.get(num + 2) - 1);
					numEndCountHashMap.put(num + 2, numEndCountHashMap.get(num + 2) + 1);
				}
				// 不满足要求
				else {
					return false;
				}
			}
		}

		return true;
	}
}
