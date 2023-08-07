import java.util.PriorityQueue;

/**
 * LCP 33. 蓄水
 * 给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
 * <p>
 * 升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
 * 蓄水：将全部水桶接满水，倒入各自对应的水缸
 * 每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 * <p>
 * 注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 * <p>
 * 示例 1：
 * <p>
 * 输入：bucket = [1,3], vat = [6,8]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * 第 1 次操作升级 bucket[0]；
 * 第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
 * vat1.gif
 * <p>
 * 示例 2：
 * <p>
 * 输入：bucket = [9,0,1], vat = [0,2,2]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * 第 1 次操作均选择升级 bucket[1]
 * 第 2~3 次操作选择蓄水，即可完成蓄水要求。
 * <p>
 * 提示：
 * <p>
 * 1 <= bucket.length == vat.length <= 100
 * 0 <= bucket[i], vat[i] <= 10^4
 */

public class QuestionLCP33_蓄水 {
}

class SolutionLCP33 {
	public int storeWater(int[] bucket, int[] vat) {
		PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

		int moveCount = 0;
		for(int i = 0; i < bucket.length; i++) {
			int b = bucket[i];
			int v = vat[i];

			if(v != 0) {
				if(b == 0) {
					b++;
					moveCount++;
				}

				priorityQueue.offer(new int[]{(b + v - 1) / b, b, v});
			}
		}

		if(priorityQueue.isEmpty()) {
		    return 0;
		}

		int minMoveCount = Integer.MAX_VALUE;
		while(!priorityQueue.isEmpty()) {
			if(moveCount + 1 >= minMoveCount) {
			    break;
			}
		    int[] needMax = priorityQueue.poll();
			minMoveCount = Math.min(minMoveCount, moveCount + needMax[0]);

			needMax[1]++;
			needMax[0] = (needMax[1] + needMax[2] - 1) / needMax[1];
			moveCount++;
			priorityQueue.offer(needMax);
		}

		return minMoveCount;
	}
}