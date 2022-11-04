/**
 * 754. 到达终点数字
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * <p>
 * 你可以做一些数量的移动 numMoves :
 * <p>
 * 每次你可以选择向左或向右移动。
 * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 * 示例 2:
 * <p>
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3 。
 * <p>
 * <p>
 * 提示:
 * <p>
 * -109 <= target <= 109
 * target != 0
 */

public class Question754_ReachANumber {
	public static void main(String[] args) {
		Solution754 solution754 = new Solution754();
		System.out.println(solution754.reachNumber(-1000000000));
	}
}

class Solution754 {
	public int reachNumber(int target) {
		target = target > 0 ? target : -target;
		int xCeil = (int)Math.ceil((-1 + Math.sqrt(1 + 8.0 * target)) * 0.5);
		while((xCeil + 1) / 2 % 2 != target % 2) {
		    xCeil++;
		}

		return xCeil;
	}
}