import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * <p>
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 5 * 104
 */

public class Question386_LexicographicalNumbers {
	public static void main(String[] args) {
		Solution386 solution386 = new Solution386();
		int n = 110;
		System.out.println(solution386.lexicalOrder(n));
	}
}

class Solution386 {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>();
		int number = 1;
		for(int i = 0; i < n; i++) {
			result.add(number);
			if(number * 10 <= n) {
				number *= 10;
			} else {
				while(number % 10 == 9 || number + 1 > n) {
					number /= 10;
				}
				number++;
			}
		}
		return result;
	}
}