import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 464. 我能赢吗
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
 * <p>
 * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
 * <p>
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 * <p>
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家是否能稳赢则返回 true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：maxChoosableInteger = 10, desiredTotal = 11
 * 输出：false
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 * 示例 2:
 * <p>
 * 输入：maxChoosableInteger = 10, desiredTotal = 0
 * 输出：true
 * 示例 3:
 * <p>
 * 输入：maxChoosableInteger = 10, desiredTotal = 1
 * 输出：true
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= maxChoosableInteger <= 20
 * 0 <= desiredTotal <= 300
 */

public class Question464_CanIWin {
	public static void main(String[] args) {
		Solution464 solution464 = new Solution464();
		int maxChoosableInteger = 4;
		int desiredTotal = 6;
		System.out.println(solution464.canIWin(maxChoosableInteger, desiredTotal));
	}
}

class Solution464 {
	Map<Integer, Boolean> memo = new HashMap<>();

	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if((1 + maxChoosableInteger) * (maxChoosableInteger) / 2 < desiredTotal) {
			return false;
		}
		return dfs(maxChoosableInteger, 0, desiredTotal, 0);
	}

	public boolean dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int currentTotal) {
		if(!memo.containsKey(usedNumbers)) {
			boolean res = false;
			for(int i = 0; i < maxChoosableInteger; i++) {
				if(((usedNumbers >> i) & 1) == 0) {
					if(i + 1 + currentTotal >= desiredTotal) {
						res = true;
						break;
					}
					if(!dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, currentTotal + i + 1)) {
						res = true;
						break;
					}
				}
			}
			memo.put(usedNumbers, res);
		}
		return memo.get(usedNumbers);
	}
}
