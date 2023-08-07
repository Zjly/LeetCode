/**
 * 1447. 最简分数
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 * 示例 3：
 * <p>
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 * 示例 4：
 * <p>
 * 输入：n = 1
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Question1447_SimplifiedFractions {
	public static void main(String[] args) {
		Solution1447 solution1447 = new Solution1447();
		System.out.println(solution1447.simplifiedFractions(4));
	}
}

class Solution1447 {
	public List<String> simplifiedFractions(int n) {
		List<String> result = new ArrayList<String>();

		for(int i = 2; i <= n; i++) {
			for(int j = 1; j < i; j++) {
				if(gcd(j, i) == 1) {
					result.add(j + "/" + i);
				}
			}
		}

		return result;
	}

	public int gcd(int a, int b) {
		return b != 0 ? gcd(b, a % b) : a;
	}
}