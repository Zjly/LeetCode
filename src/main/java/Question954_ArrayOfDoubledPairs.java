/**
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= arr.length <= 3 * 104
 * arr.length 是偶数
 * -105 <= arr[i] <= 105
 */

import java.util.HashMap;
import java.util.TreeSet;

public class Question954_ArrayOfDoubledPairs {
	public static void main(String[] args) {
		Solution954 solution954 = new Solution954();
		int[] arr = {4, -2, 2, -4};
		System.out.println(solution954.canReorderDoubled(arr));
	}
}

class Solution954 {
	public boolean canReorderDoubled(int[] arr) {
		HashMap<Integer, Integer> numCountHashMap = new HashMap<>();
		for(int num : arr) {
			numCountHashMap.put(num, numCountHashMap.getOrDefault(num, 0) + 1);
		}

		TreeSet<Integer> keySet = new TreeSet<>(numCountHashMap.keySet());

		for(int num : keySet) {
			if(numCountHashMap.get(num) == 0) {
				continue;
			}
			if(num >= 0) {
				if(numCountHashMap.containsKey(num * 2) && numCountHashMap.get(num * 2) >= numCountHashMap.get(num)) {
					numCountHashMap.put(num * 2, numCountHashMap.get(num * 2) - numCountHashMap.get(num));
					numCountHashMap.put(num, 0);
				} else {
					return false;
				}
			} else {
				if(num % 2 == 0 && numCountHashMap.containsKey(num / 2) && numCountHashMap.get(num / 2) >= numCountHashMap.get(num)) {
					numCountHashMap.put(num / 2, numCountHashMap.get(num / 2) - numCountHashMap.get(num));
					numCountHashMap.put(num, 0);
				} else {
					return false;
				}
			}

		}

		return true;
	}
}
