import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * <p>
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 * <p>
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */

public class Question179_LargestNumber {
	public static void main(String[] args) {
		int[] nums = {1231, 123};
		Solution179 solution179 = new Solution179();
		System.out.println(solution179.largestNumber(nums));
	}
}

class Solution179 {
	public String largestNumber(int[] nums) {
		PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) -> {
			int minLength = Math.min(o1.length(), o2.length());
			int i = 0;
			for(; i < minLength; i++) {
				char c1 = o1.charAt(i);
				char c2 = o2.charAt(i);
				if(c1 < c2) {
					return 1;
				} else if(c1 > c2) {
					return -1;
				}
			}

			for(; i < o1.length() + o2.length(); i++) {
				char c1 = o1.charAt(i % o1.length());
				char c2 = o2.charAt(i % o2.length());
				if(c1 < c2) {
					return 1;
				} else if(c1 > c2) {
					return -1;
				}
			}

			return 0;
		});

		for(int num : nums) {
			priorityQueue.offer(String.valueOf(num));
		}

		StringBuilder stringBuilder = new StringBuilder();
		while(!priorityQueue.isEmpty()) {
			stringBuilder.append(priorityQueue.poll());
		}

		if(stringBuilder.charAt(0) == '0' && stringBuilder.length() > 1) {
		    return "0";
		}

		return stringBuilder.toString();
	}
}