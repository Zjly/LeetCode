import java.util.HashMap;
import java.util.HashSet;

/**
 * 1726. 同积元组
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,4,6]
 * 输出：8
 * 解释：存在 8 个满足题意的元组：
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,4,5,10]
 * 输出：16
 * 解释：存在 16 个满足题意的元组：
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 104
 * nums 中的所有元素 互不相同
 */

public class Question1726_TupleWithSameProduct {
	public static void main(String[] args) {

	}
}

class Solution1726 {
	public int tupleSameProduct(int[] nums) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				int product = nums[i] * nums[j];
				hashMap.put(product, hashMap.getOrDefault(product, 0) + 1);
			}
		}

		int sum = 0;
		for(int key : hashMap.keySet()) {
			int value = hashMap.get(key);
			int pairs = value * (value - 1) / 2;
			sum += pairs * 8;
		}

		return sum;
	}
}