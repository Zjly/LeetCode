import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * 473. 火柴拼正方形
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * <p>
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 * <p>
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 108
 */

public class Question473_MatchsticksToSquare {
	public static void main(String[] args) {
		Solution473 solution473 = new Solution473();
		int[] matchsticks = {20, 13, 19, 19, 4, 15, 10, 5, 5, 15, 14, 11, 3, 20, 11};
		System.out.println(solution473.makesquare(matchsticks));
	}
}

class Solution473 {
	boolean square = false;
	int[] matchsticks;
	int edgeLength;

	public boolean makesquare(int[] matchsticks) {
		this.matchsticks = matchsticks;

		int sum = 0;
		for(int length : matchsticks) {
			sum += length;
		}
		if(sum % 4 != 0) {
			return false;
		}
		edgeLength = sum / 4;

		Arrays.sort(matchsticks);

		dfs(matchsticks.length - 1, 0, 0, 0, 0);

		return square;
	}

	public void dfs(int index, int edge1, int edge2, int edge3, int edge4) {
		if(edge1 == edgeLength && edge2 == edgeLength && edge3 == edgeLength && edge4 == edgeLength) {
			square = true;
			return;
		}

		if(square || index < 0 || edge1 > edgeLength || edge2 > edgeLength || edge3 > edgeLength || edge4 > edgeLength) {
			return;
		}

		dfs(index - 1, edge1 + matchsticks[index], edge2, edge3, edge4);

		dfs(index - 1, edge1, edge2 + matchsticks[index], edge3, edge4);

		dfs(index - 1, edge1, edge2, edge3 + matchsticks[index], edge4);

		dfs(index - 1, edge1, edge2, edge3, edge4 + matchsticks[index]);
	}
}
