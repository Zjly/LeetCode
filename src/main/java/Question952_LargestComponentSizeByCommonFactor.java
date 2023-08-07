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
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		System.out.println(solution952.largestComponentSize(nums));
	}
}

class Solution952 {
	public int largestComponentSize(int[] nums) {
		int maxNum = 0;
		for(int num : nums) {
			maxNum = Math.max(num, maxNum);
		}

		// 得到所有质数
		ArrayList<Integer> primeNumberList = new ArrayList<>();
		addPrimeNumber(primeNumberList, maxNum);

		// 计算连通
		UnionSet unionSet = new UnionSet(primeNumberList.size() + nums.length);
		for(int i = 0; i < nums.length; i++) {
			int num = nums[i];
			for(int j = 0; j < primeNumberList.size(); j++) {
				int primeNumber = primeNumberList.get(j);
				boolean added = false;

				while(num % primeNumber == 0) {
					num /= primeNumber;
					if(!added) {
						added = true;
						unionSet.union(i, j + nums.length);
					}
				}
			}
		}

		int maxCount = 0;
		int[] count = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			count[unionSet.findRoot(i)]++;
			maxCount = Math.max(maxCount, count[unionSet.findRoot(i)]);
		}

		return maxCount;
	}

	public void addPrimeNumber(ArrayList<Integer> primeNumberList, int maxNum) {
		for(int i = 2; i <= maxNum; i++) {
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

	class UnionSet {
		private final int[] unionSet;
		private final int[] ranks;
		private int count;

		public UnionSet(int length) {
			unionSet = new int[length];
			ranks = new int[length];
			count = length;

			for(int i = 0; i < length; i++) {
				unionSet[i] = i;
				ranks[i] = 1;
			}
		}

		public int findRoot(int index) {
			while(index != unionSet[index]) {
				index = unionSet[index];
			}

			return index;
		}

		public void union(int index1, int index2) {
			int root1 = findRoot(index1);
			int root2 = findRoot(index2);

			if(root1 != root2) {
				if(ranks[root1] > ranks[root2]) {
					unionSet[root2] = root1;
				} else if(ranks[root1] < ranks[root2]) {
					unionSet[root1] = root2;
				} else {
					unionSet[root2] = root1;
					ranks[root1]++;
				}

				count--;
			}
		}

		public boolean isConnected(int index1, int index2) {
			return findRoot(index1) == findRoot(index2);
		}

		public int getConnectCount() {
			return count;
		}

		public int[] getUnionSet() {
			return unionSet;
		}
	}
}