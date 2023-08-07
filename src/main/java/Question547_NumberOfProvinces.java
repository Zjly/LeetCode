/**
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 * <p>
 * 示例 1：
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * <p>
 * 输出：3
 * 提示：
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */

public class Question547_NumberOfProvinces {
	public static void main(String[] args) {
		Solution547 solution547 = new Solution547();
		int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution547.findCircleNum(isConnected));
	}
}

class Solution547 {
	public int findCircleNum(int[][] isConnected) {
		int length = isConnected.length;

		int[] unionSet = new int[length];

		for(int i = 0; i < length; i++) {
			unionSet[i] = i;
		}

		for(int i = 1; i < length; i++) {
			for(int j = 0; j < i; j++) {
				if(isConnected[i][j] == 1) {
				    union(unionSet, i, j);
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < length; i++) {
			if(findRoot(unionSet, i) == i) {
			    count++;
			}
		}

		return count;
	}

	public int findRoot(int[] unionSet, int index) {
		if(unionSet[index] == index) {
		    return index;
		}

		int rootIndex = findRoot(unionSet, unionSet[index]);
		unionSet[index] = rootIndex;
		return rootIndex;
	}

	public void union(int[] unionSet, int index1, int index2) {
		int root1 = findRoot(unionSet, index1);
		int root2 = findRoot(unionSet, index2);

		if(root1 != root2) {
		    unionSet[root2] = root1;
		}
	}
}
