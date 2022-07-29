import java.util.ArrayList;
import java.util.HashMap;

/**
 * 952. 按公因数计算最大组件大小
 * 给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图：
 * <p>
 * 有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记；
 * 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。
 * 返回 图中最大连通组件的大小 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [4,6,15,35]
 * 输出：4
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [20,50,9,63]
 * 输出：2
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [2,3,6,7,4,12,21,39]
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 105
 * nums 中所有值都 不同
 */

public class Question952_LargestComponentSizeByCommonFactor {
	public static void main(String[] args) {
		Solution952 solution952 = new Solution952();
		int[] nums = {4, 6, 15, 35};
		System.out.println(solution952.largestComponentSize(nums));
	}
}

class Solution952 {
	public int largestComponentSize(int[] nums) {
		HashMap<Integer, Integer> numCount = new HashMap<>();

		ArrayList<Integer> primeNumberList = new ArrayList<>();
		int preNum = 2;

		int maxCount = 0;

		for(int num : nums) {
			// 寻找之后的质数
			if(num >= preNum) {
				addPrimeNumber(primeNumberList, preNum, num);
				preNum = num + 1;
			}

			// 寻找num的质因数
			for(int primeNumber : primeNumberList) {
				if(num < primeNumber) {
					continue;
				}

				boolean add = false;
				while(num % primeNumber == 0) {
					if(!add) {
						add = true;
						numCount.put(primeNumber, numCount.getOrDefault(primeNumber, 0) + 1);
						maxCount = Math.max(maxCount, numCount.get(primeNumber));
					}
					num = num / primeNumber;
				}
			}
		}

		return maxCount;
	}

	public void addPrimeNumber(ArrayList<Integer> primeNumberList, int preNum, int num) {
		for(int i = preNum; i <= num; i++) {
			boolean prime = true;

			// 遍历其中的每一个质数
			for(int primeNumber : primeNumberList) {
				// 确定为质数
				if(primeNumber * primeNumber > i) {
					break;
				}

				// 可以除尽 为合数
				if(i % primeNumber == 0) {
					prime = false;
					break;
				}
			}

			if(prime) {
				primeNumberList.add(i);
			}
		}
	}
}