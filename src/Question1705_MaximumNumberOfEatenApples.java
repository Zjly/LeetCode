import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1705. 吃苹果的最大数目
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 * <p>
 * 示例 1：
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 * <p>
 * 示例 2：
 * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * 输出：5
 * 解释：你可以吃掉 5 个苹果：
 * - 第一天到第三天，你吃的都是第一天长出来的苹果。
 * - 第四天和第五天不吃苹果。
 * - 第六天和第七天，你吃的都是第六天长出来的苹果。
 * <p>
 * 提示：
 * apples.length == n
 * days.length == n
 * 1 <= n <= 2 * 104
 * 0 <= apples[i], days[i] <= 2 * 104
 * 只有在 apples[i] = 0 时，days[i] = 0 才成立
 */

public class Question1705_MaximumNumberOfEatenApples {
	public static void main(String[] args) {
		Solution1705 solution1705 = new Solution1705();
		int[] apples = {1, 2, 3, 5, 2};
		int[] days = {3, 2, 1, 4, 2};
		System.out.println(solution1705.eatenApples(apples, days));
	}
}

class Solution1705 {
	public int eatenApples(int[] apples, int[] days) {
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		int eaten = 0;
		int length = apples.length;

		for(int i = 0; i < length; i++) {
			// 加入今日生长苹果
			if(apples[i] != 0) {
				priorityQueue.offer(new int[]{i + days[i], apples[i]});
			}

			// 丢弃已经腐烂的苹果
			while(!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= i) {
				priorityQueue.poll();
			}

			// 取队列顶的苹果并吃
			if(!priorityQueue.isEmpty()) {
				int[] todayEat = priorityQueue.poll();
				todayEat[1] -= 1;
				eaten += 1;
				if(todayEat[1] != 0) {
					priorityQueue.offer(todayEat);
				}
			}
		}

		int day = length;
		while(!priorityQueue.isEmpty()) {
			// 丢弃已经腐烂的苹果
			while(!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= day) {
				priorityQueue.poll();
			}

			// 取队列顶的苹果并吃
			if(!priorityQueue.isEmpty()) {
				int[] todayEat = priorityQueue.poll();
				int canEat = Math.min(todayEat[0] - day, todayEat[1]);
				eaten += canEat;
				day += canEat;
			}
		}

		return eaten;
	}
}