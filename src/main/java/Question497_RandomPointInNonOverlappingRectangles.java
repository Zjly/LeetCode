import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

/**
 * 497. 非重叠矩形中的随机点
 * 给定一个由非重叠的轴对齐矩形的数组 rects ，其中 rects[i] = [ai, bi, xi, yi] 表示 (ai, bi) 是第 i 个矩形的左下角点，(xi, yi) 是第 i 个矩形的右上角角点。设计一个算法来随机挑选一个被某一矩形覆盖的整数点。矩形周长上的点也算做是被矩形覆盖。所有满足要求的点必须等概率被返回。
 * <p>
 * 在一个给定的矩形覆盖的空间内任何整数点都有可能被返回。
 * <p>
 * 请注意 ，整数点是具有整数坐标的点。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int[][] rects) 用给定的矩形数组 rects 初始化对象。
 * int[] pick() 返回一个随机的整数点 [u, v] 在给定的矩形所覆盖的空间内。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入:
 * ["Solution","pick","pick","pick","pick","pick"]
 * [[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
 * 输出:
 * [null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]
 * <p>
 * 解释：
 * Solution solution = new Solution([[-2, -2, 1, 1], [2, 2, 4, 6]]);
 * solution.pick(); // 返回 [1, -2]
 * solution.pick(); // 返回 [1, -1]
 * solution.pick(); // 返回 [-1, -2]
 * solution.pick(); // 返回 [-2, -2]
 * solution.pick(); // 返回 [0, 0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= rects.length <= 100
 * rects[i].length == 4
 * -109 <= ai < xi <= 109
 * -109 <= bi < yi <= 109
 * xi - ai <= 2000
 * yi - bi <= 2000
 * 所有的矩形不重叠。
 * pick 最多被调用 104 次。
 */

public class Question497_RandomPointInNonOverlappingRectangles {
	public static void main(String[] args) {
		int[][] rects = {{-2, -2, -1, -1}, {1, 0, 3, 0}};
		Solution497 solution497 = new Solution497(rects);
		System.out.println(Arrays.toString(solution497.pick()));
	}
}

class Solution497 {
	Random random;
	int[][] rects;
	TreeMap<Double, Integer> ratioTreeMap;

	public Solution497(int[][] rects) {
		random = new Random();
		this.rects = rects;

		int[] area = new int[rects.length];
		int sumArea = 0;
		for(int i = 0; i < rects.length; i++) {
			area[i] = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
			sumArea += area[i];
		}

		double[] ratio = new double[rects.length];
		ratio[0] = 1.0 * area[0] / sumArea;
		for(int i = 1; i < rects.length; i++) {
			ratio[i] = ratio[i - 1] + 1.0 * area[i] / sumArea;
		}

		ratioTreeMap = new TreeMap<>();
		for(int i = 0; i < rects.length; i++) {
			ratioTreeMap.put(ratio[i], i);
		}
	}

	public int[] pick() {
		double pickRectNum = random.nextDouble();
		int pickRectIndex = ratioTreeMap.get(ratioTreeMap.ceilingKey(pickRectNum));

		int[] pickRect = rects[pickRectIndex];
		int xLength = pickRect[2] - pickRect[0];
		int yLength = pickRect[3] - pickRect[1];

		int randomX = random.nextInt(xLength + 1);
		int randomY = random.nextInt(yLength + 1);

		return new int[]{pickRect[0] + randomX, pickRect[1] + randomY};
	}
}

/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */