import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 970. 强整数
 * 给定三个整数 x 、 y 和 bound ，返回 值小于或等于 bound 的所有 强整数 组成的列表 。
 * <p>
 * 如果某一整数可以表示为 xi + yj ，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个 强整数 。
 * <p>
 * 你可以按 任何顺序 返回答案。在你的回答中，每个值 最多 出现一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 20 + 30
 * 3 = 21 + 30
 * 4 = 20 + 31
 * 5 = 21 + 31
 * 7 = 22 + 31
 * 9 = 23 + 30
 * 10 = 20 + 32
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= x, y <= 100
 * 0 <= bound <= 106
 */

public class Question970_强整数 {
	public static void main(String[] args) {
		Solution970 solution970 = new Solution970();
		int x = 1;
		int y = 2;
		int bound = 100;
		System.out.println(solution970.powerfulIntegers(x, y, bound));
	}
}

class Solution970 {
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		ArrayList<Integer> hashSetX = new ArrayList<>();
		ArrayList<Integer> hashSetY = new ArrayList<>();
		int result = 1;
		hashSetX.add(result);
		while(x != 1 && result < bound) {
			result *= x;
			hashSetX.add(result);
		}

		result = 1;
		hashSetY.add(result);
		while(y != 1 && result < bound) {
			result *= y;
			hashSetY.add(result);
		}

		HashSet<Integer> resultSet = new HashSet<>();
		for(int numX : hashSetX) {
			for(int numY : hashSetY) {
				if(numX + numY <= bound) {
				    resultSet.add(numX + numY);
				} else {
				    break;
				}
			}
		}

		return new ArrayList<>(resultSet);
	}
}