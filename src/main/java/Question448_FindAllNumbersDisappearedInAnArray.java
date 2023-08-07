import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 */

public class Question448_FindAllNumbersDisappearedInAnArray {
	public static void main(String[] args) {
		Solution448 solution448 = new Solution448();
		int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
		System.out.println(solution448.findDisappearedNumbers(nums));
	}
}

class Solution448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		boolean[] have = new boolean[nums.length];
		for(int num : nums) {
			have[num - 1] = true;
		}

		List<Integer> result = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			if(!have[i]) {
				result.add(i + 1);
			}
		}

		return result;
	}
}