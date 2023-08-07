/**
 * 1750. 删除字符串两端相同字符后的最短长度
 * 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
 * <p>
 * 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
 * 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
 * 前缀和后缀在字符串中任意位置都不能有交集。
 * 前缀和后缀包含的所有字符都要相同。
 * 同时删除前缀和后缀。
 * 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ca"
 * 输出：2
 * 解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
 * 示例 2：
 * <p>
 * 输入：s = "cabaabac"
 * 输出：0
 * 解释：最优操作序列为：
 * - 选择前缀 "c" 和后缀 "c" 并删除它们，得到 s = "abaaba" 。
 * - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "baab" 。
 * - 选择前缀 "b" 和后缀 "b" 并删除它们，得到 s = "aa" 。
 * - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "" 。
 * 示例 3：
 * <p>
 * 输入：s = "aabccabba"
 * 输出：3
 * 解释：最优操作序列为：
 * - 选择前缀 "aa" 和后缀 "a" 并删除它们，得到 s = "bccabb" 。
 * - 选择前缀 "b" 和后缀 "bb" 并删除它们，得到 s = "cca" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含字符 'a'，'b' 和 'c' 。
 */

public class Question1750_MinimumLengthOfStringAfterDeletingSimilarEnds {
	public static void main(String[] args) {
		Solution1750 solution1750 = new Solution1750();
		String s = "cabaabac";
		System.out.println(solution1750.minimumLength(s));
	}
}

class Solution1750 {
	public int minimumLength(String s) {
		int left = 0;
		int right = s.length() - 1;
		while(left < right && s.charAt(left) == s.charAt(right)) {
		    while(left + 1 < s.length() && s.charAt(left) == s.charAt(left + 1)) {
		        left++;
		    }

			while(right - 1 >= 0 && s.charAt(right) == s.charAt(right - 1)) {
			    right--;
			}

			if(left >= right) {
			    return 0;
			}

			left++;
			right--;
		}

		return right - left + 1;
	}
}
