import java.util.*;

/**
 * 864. 获取所有钥匙的最短路径
 * 给定一个二维网格 grid ，其中：
 * <p>
 * '.' 代表一个空房间
 * '#' 代表一堵
 * '@' 是起点
 * 小写字母代表钥匙
 * 大写字母代表锁
 * 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
 * <p>
 * 假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
 * <p>
 * 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = ["@.a.#","###.#","b.A.B"]
 * 输出：8
 * 解释：目标是获得所有钥匙，而不是打开所有锁。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = ["@..aA","..B#.","....b"]
 * 输出：6
 * 示例 3:
 * <p>
 * <p>
 * 输入: grid = ["@Aa"]
 * 输出: -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 30
 * grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
 * 钥匙的数目范围是 [1, 6]
 * 每个钥匙都对应一个 不同 的字母
 * 每个钥匙正好打开一个对应的锁
 */

public class Question864_ShortestPathToGetAllKeys {
	public static void main(String[] args) {
		Solution864 solution864 = new Solution864();
		String[] grid = {"@...a", ".###A", "b.BCc"};
		System.out.println(solution864.shortestPathAllKeys(grid));
	}
}

class Solution864 {
	public int shortestPathAllKeys(String[] grid) {
		int rowLength = grid.length;
		int columnLength = grid[0].length();

		// 寻找起点
		State beginState = null;
		int k = 0;
		for(int i = 0; i < rowLength; i++) {
			for(int j = 0; j < columnLength; j++) {
				if(grid[i].charAt(j) == '@') {
					beginState = new State(i, j);
				}

				if(grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
					k++;
				}
			}
		}

		// 遍历队列
		Queue<State> stateQueue = new LinkedList<>();
		stateQueue.offer(beginState);

		// 储存遍历过的状态
		HashSet<String> arrived = new HashSet<>();
		assert beginState != null;
		arrived.add(beginState.toString());

		// 最短路径长度A
		int path = 0;

		// 方向
		int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		// 广度优先搜索
		while(!stateQueue.isEmpty()) {
			path++;
			int size = stateQueue.size();
			for(int i = 0; i < size; i++) {
				State currentState = stateQueue.poll();
				for(int[] dir : dirs) {
					assert currentState != null;
					int nextRow = currentState.row + dir[0];
					int nextColumn = currentState.column + dir[1];
					if(nextRow >= 0 && nextRow < rowLength && nextColumn >= 0 && nextColumn < columnLength && grid[nextRow].charAt(nextColumn) != '#') {
						char nextChar = grid[nextRow].charAt(nextColumn);
						State nextState = new State(nextRow, nextColumn, currentState);

						boolean through = false;
						if(nextChar >= 'a' && nextChar <= 'f') {
							through = true;
							nextState.keys.add(nextChar);
							if(nextState.keys.size() == k) {
								return path;
							}
						} else if(nextChar >= 'A' && nextChar <= 'F' && nextState.keys.contains((char)(nextChar - 'A' + 'a'))) {
							through = true;
						} else if(nextChar == '.' || nextChar == '@') {
							through = true;
						}

						if(through && !arrived.contains(nextState.toString())) {
							arrived.add(nextState.toString());
							stateQueue.add(nextState);
						}
					}
				}
			}
		}

		return -1;
	}

	static class State {
		int row;
		int column;
		HashSet<Character> keys = new HashSet<>();

		public State(int row, int column) {
			this.row = row;
			this.column = column;
		}

		public State(int row, int column, State parent) {
			this.row = row;
			this.column = column;
			this.keys = (HashSet<Character>)parent.keys.clone();
		}

		@Override
		public String toString() {
			return "State{" +
					"row=" + row +
					", column=" + column +
					", keys=" + keys +
					'}';
		}
	}
}