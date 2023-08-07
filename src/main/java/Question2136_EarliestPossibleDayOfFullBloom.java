import java.util.Arrays;

/**
 * 2136. 全部开花的最早一天
 * 你有 n 枚花的种子。每枚种子必须先种下，才能开始生长、开花。播种需要时间，种子的生长也是如此。给你两个下标从 0 开始的整数数组 plantTime 和 growTime ，每个数组的长度都是 n ：
 * <p>
 * plantTime[i] 是 播种 第 i 枚种子所需的 完整天数 。每天，你只能为播种某一枚种子而劳作。无须 连续几天都在种同一枚种子，但是种子播种必须在你工作的天数达到 plantTime[i] 之后才算完成。
 * growTime[i] 是第 i 枚种子完全种下后生长所需的 完整天数 。在它生长的最后一天 之后 ，将会开花并且永远 绽放 。
 * 从第 0 开始，你可以按 任意 顺序播种种子。
 * <p>
 * 返回所有种子都开花的 最早 一天是第几天。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：plantTime = [1,4,3], growTime = [2,3,1]
 * 输出：9
 * 解释：灰色的花盆表示播种的日子，彩色的花盆表示生长的日子，花朵表示开花的日子。
 * 一种最优方案是：
 * 第 0 天，播种第 0 枚种子，种子生长 2 整天。并在第 3 天开花。
 * 第 1、2、3、4 天，播种第 1 枚种子。种子生长 3 整天，并在第 8 天开花。
 * 第 5、6、7 天，播种第 2 枚种子。种子生长 1 整天，并在第 9 天开花。
 * 因此，在第 9 天，所有种子都开花。
 * 示例 2：
 * <p>
 * <p>
 * 输入：plantTime = [1,2,3,2], growTime = [2,1,2,1]
 * 输出：9
 * 解释：灰色的花盆表示播种的日子，彩色的花盆表示生长的日子，花朵表示开花的日子。
 * 一种最优方案是：
 * 第 1 天，播种第 0 枚种子，种子生长 2 整天。并在第 4 天开花。
 * 第 0、3 天，播种第 1 枚种子。种子生长 1 整天，并在第 5 天开花。
 * 第 2、4、5 天，播种第 2 枚种子。种子生长 2 整天，并在第 8 天开花。
 * 第 6、7 天，播种第 3 枚种子。种子生长 1 整天，并在第 9 天开花。
 * 因此，在第 9 天，所有种子都开花。
 * 示例 3：
 * <p>
 * 输入：plantTime = [1], growTime = [1]
 * 输出：2
 * 解释：第 0 天，播种第 0 枚种子。种子需要生长 1 整天，然后在第 2 天开花。
 * 因此，在第 2 天，所有种子都开花。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == plantTime.length == growTime.length
 * 1 <= n <= 105
 * 1 <= plantTime[i], growTime[i] <= 104
 */

public class Question2136_EarliestPossibleDayOfFullBloom {
	public static void main(String[] args) {
		Solution2136 solution2136 = new Solution2136();
		int[] plantTime = {27, 5, 24, 17, 27, 4, 23, 16, 6, 26, 13, 17, 21, 3, 9, 10, 28, 26, 4, 10, 28, 2};
		int[] growTime = {26, 9, 14, 17, 6, 14, 23, 24, 11, 6, 27, 14, 13, 1, 15, 5, 12, 15, 23, 27, 28, 12};
		System.out.println(solution2136.earliestFullBloom(plantTime, growTime));
	}
}

class Solution2136 {
	public int earliestFullBloom(int[] plantTime, int[] growTime) {
		int[][] pg = new int[plantTime.length][2];
		for(int i = 0; i < pg.length; i++) {
			pg[i][0] = plantTime[i];
			pg[i][1] = growTime[i];
		}

		Arrays.sort(pg, (a, b) -> b[1] - a[1]);

		int pTime = pg[0][0];
		int gTime = pg[0][1];
		for(int i = 1; i < pg.length; i++) {
			pTime += pg[i][0];
			gTime = Math.max(gTime - pg[i][0], pg[i][1]);
		}

		return pTime + gTime;
	}
}