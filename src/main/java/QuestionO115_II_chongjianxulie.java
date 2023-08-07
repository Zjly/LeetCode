import java.util.ArrayList;

/**
 * 剑指 Offer II 115. 重建序列
 * 给定一个长度为 n 的整数数组 nums ，其中 nums 是范围为 [1，n] 的整数的排列。还提供了一个 2D 整数数组 sequences ，其中 sequences[i] 是 nums 的子序列。
 * 检查 nums 是否是唯一的最短 超序列 。最短 超序列 是 长度最短 的序列，并且所有序列 sequences[i] 都是它的子序列。对于给定的数组 sequences ，可能存在多个有效的 超序列 。
 * <p>
 * 例如，对于 sequences = [[1,2],[1,3]] ，有两个最短的 超序列 ，[1,2,3] 和 [1,3,2] 。
 * 而对于 sequences = [[1,2],[1,3],[1,2,3]] ，唯一可能的最短 超序列 是 [1,2,3] 。[1,2,3,4] 是可能的超序列，但不是最短的。
 * 如果 nums 是序列的唯一最短 超序列 ，则返回 true ，否则返回 false 。
 * 子序列 是一个可以通过从另一个序列中删除一些元素或不删除任何元素，而不改变其余元素的顺序的序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3], sequences = [[1,2],[1,3]]
 * 输出：false
 * 解释：有两种可能的超序列：[1,2,3]和[1,3,2]。
 * 序列 [1,2] 是[1,2,3]和[1,3,2]的子序列。
 * 序列 [1,3] 是[1,2,3]和[1,3,2]的子序列。
 * 因为 nums 不是唯一最短的超序列，所以返回false。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], sequences = [[1,2]]
 * 输出：false
 * 解释：最短可能的超序列为 [1,2]。
 * 序列 [1,2] 是它的子序列：[1,2]。
 * 因为 nums 不是最短的超序列，所以返回false。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3], sequences = [[1,2],[1,3],[2,3]]
 * 输出：true
 * 解释：最短可能的超序列为[1,2,3]。
 * 序列 [1,2] 是它的一个子序列：[1,2,3]。
 * 序列 [1,3] 是它的一个子序列：[1,2,3]。
 * 序列 [2,3] 是它的一个子序列：[1,2,3]。
 * 因为 nums 是唯一最短的超序列，所以返回true。
 */

public class QuestionO115_II_chongjianxulie {
	public static void main(String[] args) {
		SolutionO115_II solutionO115_ii = new SolutionO115_II();
		int[] nums = {1,2,3};
		int[][] sequences = {{1,2},{1,3},{2,3}};
		System.out.println(solutionO115_ii.sequenceReconstruction(nums, sequences));
	}
}

class SolutionO115_II {
	public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
		int n = nums.length;
		boolean[][] matrix = new boolean[n][n];

		int[] degree = new int[n];
		for(int[] sequence : sequences) {
			for(int i = 0; i < sequence.length - 1; i++) {
				if(!matrix[sequence[i] - 1][sequence[i + 1] - 1]) {
					degree[sequence[i + 1] - 1]++;
				}
				matrix[sequence[i] - 1][sequence[i + 1] - 1] = true;
			}
		}


		int[] result = new int[n];

		for(int i = 0; i < n; i++) {
			int count = 0;
			for(int j = 0; j < n; j++) {
				if(degree[j] == 0) {
					result[i] = j;
					degree[j] = -1;
					count++;
				}
			}

			if(count != 1) {
				return false;
			}

			for(int j = 0; j < n; j++) {
				if(matrix[result[i]][j]) {
					degree[j]--;
				}
			}
		}

		for(int i = 0; i < n; i++) {
			if(result[i] + 1 != nums[i]) {
			    return false;
			}
		}

		return true;
	}
}
