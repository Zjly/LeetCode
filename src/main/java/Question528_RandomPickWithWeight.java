import java.util.Random;

/**
 * 528. 按权重随机选择
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 * <p>
 * 示例 1：
 * 输入：
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * 输出：
 * [null,0]
 * 解释：
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
 * <p>
 * 示例 2：
 * 输入：
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * 输出：
 * [null,1,1,1,1,0]
 * 解释：
 * Solution solution = new Solution([1, 3]);
 * solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 1
 * solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
 * <p>
 * 由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
 * [null,1,1,1,1,0]
 * [null,1,1,1,1,1]
 * [null,1,1,1,0,0]
 * [null,1,1,1,0,1]
 * [null,1,0,1,0,0]
 * ......
 * 诸若此类。
 * <p>
 * 提示：
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex 将被调用不超过 10000 次
 * 通过次数9,953提交次数21,139
 */

public class Question528_RandomPickWithWeight {
	public static void main(String[] args) {
		Solution528 solution528 = new Solution528(new int[]{1});
		System.out.println(solution528.pickIndex());
	}
}

class Solution528 {
	private final double[] preSum;

	public Solution528(int[] w) {
		double sum = 0;
		preSum = new double[w.length];

		for(int ww : w) {
			sum += ww;
		}

		preSum[0] = w[0] / sum;
		for(int i = 1; i < preSum.length; i++) {
			preSum[i] = preSum[i - 1] + w[i] / sum;
		}
	}

	public int pickIndex() {
		Random random = new Random();
		double rNum = random.nextDouble();

		int left = 0;
		int right = preSum.length - 1;

		while(left < right) {
			int mid = (left + right) / 2;
			if(preSum[mid] < rNum) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}
}

/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */