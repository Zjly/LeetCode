import java.util.ArrayList;
import java.util.Arrays;

/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 * <p>
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 */

public class Question16_19_水域大小 {
}

class Solution16_19 {
	public int[] pondSizes(int[][] land) {
		ArrayList<Integer> list = new ArrayList<>();
		int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
		for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[0].length; j++) {
				int size = dfs(land, dirs, i, j);
				if (size > 0) {
					list.add(size);
				}
			}
		}

		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}

		Arrays.sort(res);
		return res;
	}

	private int dfs(int[][] land, int[][] dirs, int x, int y) {
		if (x < 0 || x >= land.length || y < 0 || y >= land[0].length || land[x][y] != 0) {
			return 0;
		}

		int size = 0;
		land[x][y] = -1;
		for (int[] dir : dirs) {
			size += dfs(land, dirs, x + dir[0], y + dir[1]);
		}

		return size + 1;
	}
}