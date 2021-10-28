import java.util.HashSet;

/**
 * 869. 重新排序得到 2 的幂
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * 输入：1
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：10
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：16
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：24
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：46
 * 输出：true
 * <p>
 * 提示：
 * 1 <= N <= 10^9
 */

public class Question869_ReorderedPowerOf2 {
	public static void main(String[] args) {
		Solution869 solution869 = new Solution869();
		int n = 32;
		System.out.println(solution869.reorderedPowerOf2(n));
	}
}

class Solution869 {
	public boolean reorderedPowerOf2(int n) {
		HashSet<String> hashSet = new HashSet<>();
		for(int i = 0; i < 31; i++) {
			hashSet.add(getString(1 << i));
		}

		return hashSet.contains(getString(n));
	}

	public String getString(int num) {
		int[] count = new int[10];

		while(num != 0) {
			count[num % 10]++;
			num = num / 10;
		}

		StringBuilder stringBuilder = new StringBuilder();
		for(int j = 0; j < 10; j++) {
			stringBuilder.append(count[j]).append(",");
		}

		return stringBuilder.toString();
	}
}