import java.util.Arrays;
import java.util.Random;

/**
 * 478. 在圆内随机生成点
 * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
 * randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1.0, 0.0, 0.0], [], [], []]
 * 输出: [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
 * 解释:
 * Solution solution = new Solution(1.0, 0.0, 0.0);
 * solution.randPoint ();//返回[-0.02493，-0.38077]
 * solution.randPoint ();//返回[0.82314,0.38945]
 * solution.randPoint ();//返回[0.36572,0.17248]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 < radius <= 108
 * -107 <= x_center, y_center <= 107
 * randPoint 最多被调用 3 * 104 次
 */

public class Question478_GenerateRandomPointInACircle {
	public static void main(String[] args) {
		Solution478 solution478 = new Solution478(10, 5, -7.5);
		System.out.println(Arrays.toString(solution478.randPoint()));
	}
}

class Solution478 {
	double radius;
	double x_center;
	double y_center;
	Random random;

	public Solution478(double radius, double x_center, double y_center) {
		this.radius = radius;
		this.x_center = x_center;
		this.y_center = y_center;
		random = new Random();
	}

	public double[] randPoint() {
		while(true) {
			double x = random.nextDouble() * (2 * radius) - radius;
			double y = random.nextDouble() * (2 * radius) - radius;
			if(x * x + y * y <= radius * radius) {
				return new double[]{x_center + x, y_center + y};
			}
		}
	}
}

/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */