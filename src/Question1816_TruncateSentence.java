/**
 * 1816. 截断句子
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 * <p>
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s​​​​​​ 和一个整数 k​​​​​​ ，请你将 s​​ 截断 ​，​​​使截断后的句子仅含 前 k​​​​​​ 个单词。返回 截断 s​​​​​​ 后得到的句子。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello how are you Contestant", k = 4
 * 输出："Hello how are you"
 * 解释：
 * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
 * 前 4 个单词为 ["Hello", "how", "are", "you"]
 * 因此，应当返回 "Hello how are you"
 * 示例 2：
 * <p>
 * 输入：s = "What is the solution to this problem", k = 4
 * 输出："What is the solution"
 * 解释：
 * s 中的单词为 ["What", "is" "the", "solution", "to", "this", "problem"]
 * 前 4 个单词为 ["What", "is", "the", "solution"]
 * 因此，应当返回 "What is the solution"
 * 示例 3：
 * <p>
 * 输入：s = "chopper is not a tanuki", k = 5
 * 输出："chopper is not a tanuki"
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 500
 * k 的取值范围是 [1,  s 中单词的数目]
 * s 仅由大小写英文字母和空格组成
 * s 中的单词之间由单个空格隔开
 * 不存在前导或尾随空格
 */

public class Question1816_TruncateSentence {
	public static void main(String[] args) {
		Solution1816 solution1816 = new Solution1816();
		String s = "chopper is not a tanuki";
		int k = 2;
		System.out.println(solution1816.truncateSentence(s, k));
	}
}

class Solution1816 {
	public String truncateSentence(String s, int k) {
		int index = 0;
		int count = 0;
		while(index < s.length()) {
			if(s.charAt(index) == ' ') {
				count++;
				if(count == k) {
					break;
				}
			}
			index++;
		}

		return s.substring(0, index);
	}
}