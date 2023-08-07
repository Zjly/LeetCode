import java.util.Arrays;

/**
 * 881. 救生艇
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * <p>
 * 示例 1：
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * <p>
 * 示例 2：
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * <p>
 * 示例 3：
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * <p>
 * 提示：
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 */

public class Question881_BoatsToSavePeople {
	public static void main(String[] args) {

	}
}

class Solution881 {
	public int numRescueBoats(int[] people, int limit) {
		int count = 0;

		Arrays.sort(people);
		int p = 0;
		int q = people.length - 1;

		while(p < q) {
		    if(people[p] + people[q] <= limit) {
		        p++;
		    }
			q--;
			count++;
		}

		if(p == q) {
			count++;
		}

		return count;
	}
}