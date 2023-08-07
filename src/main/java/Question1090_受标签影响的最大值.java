import java.util.Arrays;

/**
 * 1090. 受标签影响的最大值
 * 我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还会给出两个整数 numWanted 和 useLimit 。
 * <p>
 * 从 n 个元素中选择一个子集 s :
 * <p>
 * 子集 s 的大小 小于或等于 numWanted 。
 * s 中 最多 有相同标签的 useLimit 项。
 * 一个子集的 分数 是该子集的值之和。
 * <p>
 * 返回子集 s 的最大 分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 * 示例 2：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
 * 输出：12
 * 解释：选出的子集是第一项，第二项和第三项。
 * 示例 3：
 * <p>
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
 * 输出：16
 * 解释：选出的子集是第一项和第四项。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == values.length == labels.length
 * 1 <= n <= 2 * 104
 * 0 <= values[i], labels[i] <= 2 * 104
 * 1 <= numWanted, useLimit <= n
 */

public class Question1090_受标签影响的最大值 {
}

class Solution1090 {
	public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
		int[][] vls = new int[values.length][2];
		for(int i = 0; i < values.length; i++) {
			vls[i][0] = values[i];
			vls[i][1] = labels[i];
		}

		Arrays.sort(vls, (a, b) -> b[0] - a[0]);
		int[] counts = new int[20001];
		int sum = 0;
		for(int[] vl : vls) {
			int value = vl[0];
			int label = vl[1];

			if(counts[label] < useLimit) {
				counts[label]++;
				sum += value;
				numWanted--;

				if(numWanted == 0) {
					break;
				}
			}
		}

		return sum;
	}
}