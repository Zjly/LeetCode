import java.util.Arrays;
import java.util.LinkedList;

/**
 * 1030. 距离顺序排列矩阵单元格
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * <p>
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * <p>
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 * <p>
 * 示例 1：
 * <p>
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 * <p>
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 * <p>
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 * <p>
 * 提示：
 * <p>
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 */

public class Question1030 {
	public static void main(String[] args) {
		Solution1030 solution1030 = new Solution1030();
		int[][] result = solution1030.allCellsDistOrder(2, 3, 1, 2);
		System.out.println(Arrays.deepToString(result));
	}
}

class Solution1030 {
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
		LinkedList<int[]> list = new LinkedList<>();
		list.add(new int[]{r0, c0});

		// 离指定单元格的距离
		int distance = 1;

		while(list.size() != R * C) {
			// 逐层逐距离加入列表中
			for(int i = 0; i < distance; i++) {
				int j = distance - i;

				// 向四个方向计算距离
				if(r0 + i < R && c0 + j < C) {
					list.add(new int[]{r0 + i, c0 + j});
				}

				if(r0 - j >= 0 && c0 + i < C) {
					list.add(new int[]{r0 - j, c0 + i});
				}

				if(r0 + j < R && c0 - i >= 0) {
					list.add(new int[]{r0 + j, c0 - i});
				}

				if(r0 - i >= 0 && c0 - j >= 0) {
					list.add(new int[]{r0 - i, c0 - j});
				}
			}

			distance++;
		}

		return list.toArray(new int[list.size()][2]);
	}
}
