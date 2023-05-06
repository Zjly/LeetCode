import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 1419. 数青蛙
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
 * <p>
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * <p>
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 * 示例 2：
 * <p>
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 * 示例 3：
 * <p>
 * 输入：croakOfFrogs = "croakcrook"
 * 输出：-1
 * 解释：给出的字符串不是 "croak" 的有效组合。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= croakOfFrogs.length <= 105
 * 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'
 */

public class Question1419_数青蛙 {
	Solution1419 solution1419 = new Solution1419();

	@Test
	public void test1() {
		String croakOfFrogs = "croakcroak";

		Assertions.assertEquals(1, solution1419.minNumberOfFrogs(croakOfFrogs));
	}

	@Test
	public void test2() {
		String croakOfFrogs = "crcoakroak";

		Assertions.assertEquals(2, solution1419.minNumberOfFrogs(croakOfFrogs));
	}
}

class Solution1419 {
	public int minNumberOfFrogs(String croakOfFrogs) {
		if(croakOfFrogs.length() % 5 != 0) {
			return -1;
		}

		int[] counts = new int[5];
		int minFrogs = 0;
		for(int i = 0; i < croakOfFrogs.length(); i++) {
			char c = croakOfFrogs.charAt(i);
			switch(c) {
				case 'c':
					counts[0]++;
					minFrogs = Math.max(minFrogs, counts[0]);
					break;
				case 'r':
					if(counts[0] > counts[1]) {
						counts[1]++;
					} else {
						return -1;
					}
					break;
				case 'o':
					if(counts[1] > counts[2]) {
						counts[2]++;
					} else {
						return -1;
					}
					break;
				case 'a':
					if(counts[2] > counts[3]) {
						counts[3]++;
					} else {
						return -1;
					}
					break;
				case 'k':
					if(counts[3] > counts[4]) {
						counts[0]--;
						counts[1]--;
						counts[2]--;
						counts[3]--;
					} else {
						return -1;
					}
					break;
			}
		}

		return counts[0] == 0 ? minFrogs : -1;
	}
}