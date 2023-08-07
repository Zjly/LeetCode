import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * <p>
 * 示例 1：
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * <p>
 * 示例 2：
 * 输入：mat =
 * [[1,0,0,0],
 * [1,1,1,1],
 * [1,0,0,0],
 * [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 * <p>
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] 不是 0 就是 1
 */

public class Question1337_TheKWeakestRowsInAMatrix {
	public static void main(String[] args) {
		Solution1337 solution1337 = new Solution1337();
		int[][] mat = {{1, 0}, {0, 0}, {1, 0}};
		System.out.println(Arrays.toString(solution1337.kWeakestRows(mat, 3)));
	}
}

class Solution1337 {
	public int[] kWeakestRows(int[][] mat, int k) {
		class RowCount {
			final int count;
			final int index;

			public RowCount(int count, int index) {
				this.count = count;
				this.index = index;
			}
		}

		ArrayList<RowCount> arrayList = new ArrayList<>();
		for(int i = 0; i < mat.length; i++) {
			arrayList.add(new RowCount(count(mat[i]), i));
		}

		arrayList.sort((o1, o2) -> {
			if(o1.count == o2.count) {
				return o1.index - o2.index;
			}
			return o1.count - o2.count;
		});

		int[] result = new int[k];
		for(int i = 0; i < k; i++) {
			result[i] = arrayList.get(i).index;
		}

		return result;
	}

	private int count(int[] row) {
		int left = 0;
		int right = row.length - 1;
		int mid;
		while(left < right) {
			mid = (left + right) / 2;
			if(row[mid] == 1) {
				if(left == mid) {
					if(row[right] == 1) {
						return right + 1;
					} else {
						right -= 1;
					}
				} else {
					left = mid;
				}
			} else {
				right = mid - 1;
			}
		}

		if(row[left] == 1) {
			return left + 1;
		} else {
		    return left;
		}
	}
}