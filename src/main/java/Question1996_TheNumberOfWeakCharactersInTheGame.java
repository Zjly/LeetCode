import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1996. 游戏中弱角色的数量
 * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
 * <p>
 * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
 * <p>
 * 返回 弱角色 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：properties = [[5,5],[6,3],[3,6]]
 * 输出：0
 * 解释：不存在攻击和防御都严格高于其他角色的角色。
 * 示例 2：
 * <p>
 * 输入：properties = [[2,2],[3,3]]
 * 输出：1
 * 解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 * 示例 3：
 * <p>
 * 输入：properties = [[1,5],[10,4],[4,3]]
 * 输出：1
 * 解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= properties.length <= 105
 * properties[i].length == 2
 * 1 <= attacki, defensei <= 105
 */

public class Question1996_TheNumberOfWeakCharactersInTheGame {
	public static void main(String[] args) {
		Solution1996 solution1996 = new Solution1996();
		int[][] properties = {{7, 9}, {10, 7}, {6, 9}, {10, 4}, {7, 5}, {7, 10}};
		System.out.println(solution1996.numberOfWeakCharacters(properties));
	}
}

class Solution1996 {
	public int numberOfWeakCharacters(int[][] properties) {
		Arrays.sort(properties, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return o2[1] - o1[1];
			}
			return o1[0] - o2[0];
		});

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		int count = 0;

		for(int[] property : properties) {
			while(!priorityQueue.isEmpty() && property[1] > priorityQueue.peek()) {
				priorityQueue.poll();
				count++;
			}

			priorityQueue.offer(property[1]);
		}

		return count;
	}
}