/**
 * 765. 情侣牵手
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
 * <p>
 * 示例 1:
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * <p>
 * 示例 2:
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 */

public class Question765_CouplesHoldingHands {
	public static void main(String[] args) {
		int[] row = new int[]{0, 2, 1, 3};
		Solution765 solution765 = new Solution765();
		System.out.println(solution765.minSwapsCouples(row));
	}
}

class Solution765 {
	public int minSwapsCouples(int[] row) {
		UnionSet unionSet = new UnionSet(row.length / 2);

		for(int i = 0; i < row.length / 2; i++) {
			int index1 = row[i * 2] / 2;
			int index2 = row[i * 2 + 1] / 2;
			unionSet.union(index1, index2);
		}

		int[] length = new int[row.length / 2];
		for(int i = 0; i < row.length / 2; i++) {
			length[unionSet.findRoot(i)]++;
		}

		int result = 0;
		for(int i = 0; i < length.length; i++) {
			if(length[i] != 0) {
			    result += length[i] - 1;
			}
		}

		return result;
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
