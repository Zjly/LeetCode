import java.util.PriorityQueue;

/**
 * 1405. 最长快乐字符串
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 * <p>
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 * <p>
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 * 示例 2：
 * <p>
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 * 示例 3：
 * <p>
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 */

public class Question1405_LongestHappyString {
	public static void main(String[] args) {

	}
}

class Solution1405 {
	public String longestDiverseString(int a, int b, int c) {
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
		if(a > 0) priorityQueue.add(new int[]{0, a});
		if(b > 0) priorityQueue.add(new int[]{1, b});
		if(c > 0) priorityQueue.add(new int[]{2, c});

		StringBuilder stringBuilder = new StringBuilder();
		while(!priorityQueue.isEmpty()) {
			int[] cur = priorityQueue.poll();
			int n = stringBuilder.length();
			if(n >= 2 && stringBuilder.charAt(n - 1) - 'a' == cur[0] && stringBuilder.charAt(n - 2) - 'a' == cur[0]) {
				if(priorityQueue.isEmpty()) break;
				int[] next = priorityQueue.poll();
				stringBuilder.append((char)(next[0] + 'a'));
				if(--next[1] != 0) priorityQueue.add(next);
				priorityQueue.add(cur);
			} else {
				stringBuilder.append((char)(cur[0] + 'a'));
				if(--cur[1] != 0) priorityQueue.add(cur);
			}
		}
		return stringBuilder.toString();
	}
}

