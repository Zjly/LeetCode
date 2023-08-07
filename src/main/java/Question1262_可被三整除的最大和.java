import java.util.ArrayList;
import java.util.Collections;

/**
 * 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 *
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 *
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 */

public class Question1262_可被三整除的最大和 {
}

/**
 * @author Zhang Lei
 * @date 2023/6/19 8:02
 */
class Solution1262 {
	public int maxSumDivThree(int[] nums) {
		ArrayList<Integer> oneList = new ArrayList<>();
		ArrayList<Integer> twoList = new ArrayList<>();

		int sum = 0;
		for (int num : nums) {
			sum += num;
			if (num % 3 == 1) {
			    oneList.add(num);
			} else if (num % 3 == 2) {
			    twoList.add(num);
			}
		}

		Collections.sort(oneList);
		Collections.sort(twoList);

		if (oneList.size() >= twoList.size()) {
		    return sum - diff(oneList, twoList);
		} else {
		    return sum - diff(twoList, oneList);
		}
	}

	private int diff(ArrayList<Integer> big, ArrayList<Integer> small) {
		int smallSize = small.size();

		if (smallSize == 0) {
			return zero(big, small);
		} else if (smallSize == 1) {
			return Math.min(zero(big, small), one(big, small));
		} else {
			return Math.min(Math.min(zero(big, small), one(big, small)), two(big, small));
		}
	}

	private int zero(ArrayList<Integer> big, ArrayList<Integer> small) {
		int bigLengthRemain = big.size() - small.size();
		int needSum = bigLengthRemain % 3;

		int sum = 0;
		for (int i = 0; i < needSum; i++) {
			sum += big.get(i);
		}

		return sum;
	}

	private int one(ArrayList<Integer> big, ArrayList<Integer> small) {
		int bigLengthRemain = big.size() - small.size() + 1;
		int needSum = bigLengthRemain % 3;

		int sum = 0;
		for (int i = 0; i < needSum; i++) {
			sum += big.get(i);
		}
		sum += small.get(0);

		return sum;
	}

	private int two(ArrayList<Integer> big, ArrayList<Integer> small) {
		int bigLengthRemain = big.size() - small.size() + 2;
		int needSum = bigLengthRemain % 3;

		int sum = 0;
		for (int i = 0; i < needSum; i++) {
			sum += big.get(i);
		}
		sum += small.get(0);
		sum += small.get(1);

		return sum;
	}
}
