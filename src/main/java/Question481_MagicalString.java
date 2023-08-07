/**
 * 481. 神奇字符串
 * 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
 * <p>
 * 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
 * s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。上面的出现次数正是 s 自身。
 * <p>
 * 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6
 * 输出：3
 * 解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 */

public class Question481_MagicalString {
	public static void main(String[] args) {
		Solution481 solution481 = new Solution481();
		System.out.println(solution481.magicalString(7));
	}
}

class Solution481 {
	public int magicalString(int n) {
		int quick = 3;
		int slow = 2;
		boolean[] array = new boolean[n + 2];
		array[0] = true;
		array[1] = false;
		array[2] = false;

		while(quick < n) {
			if(array[slow]) {
				array[quick] = !array[quick - 1];
				quick += 1;
			} else {
				array[quick] = !array[quick - 1];
				array[quick + 1] = array[quick];
				quick += 2;
			}
			slow += 1;
		}

		int count = 0;
		for(int i = 0; i < n; i++) {
			if(array[i]) {
			    count++;
			}
		}
		return count;
	}
}