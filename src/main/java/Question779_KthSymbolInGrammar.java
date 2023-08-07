/**
 * 779. 第K个语法符号
 * 我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * 示例 2:
 * <p>
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 示例 3:
 * <p>
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 30
 * 1 <= k <= 2n - 1
 */

public class Question779_KthSymbolInGrammar {
	public static void main(String[] args) {
		Solution779 solution779 = new Solution779();
		int n = 4;
		int k = 10;
		System.out.println(solution779.kthGrammar(n, k));
	}
}

class Solution779 {
	public int kthGrammar(int n, int k) {
		int[] arr = new int[n];
		k--;
		int x = 0;
		for(int i = 0; i < arr.length; i++) {
			x = x ^ k % 2;
			k = k / 2;
		}

		return x;
	}
}
