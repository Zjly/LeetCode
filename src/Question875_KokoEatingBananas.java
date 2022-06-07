/**
 * 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */

public class Question875_KokoEatingBananas {
	public static void main(String[] args) {
		Solution875 solution875 = new Solution875();
		int[] piles = {980628391,681530205,734313996,168632541};
		int h = 819870953;
		System.out.println(solution875.minEatingSpeed(piles, h));
	}
}

class Solution875 {
	public int minEatingSpeed(int[] piles, int h) {
		long sum = 0;
		int max = 0;
		for(int pile : piles) {
			sum += pile;
			max = Math.max(max, pile);
		}

		int min = (int)Math.ceil(1.0 * sum / h);

		int mid = (min + max) / 2;
		while(min < max) {
			int sumH = 0;
			for(int pile : piles) {
				sumH += (int)Math.ceil(1.0 * pile / mid);
			}
			if(sumH > h) {
				min = mid + 1;
			} else if(sumH <= h) {
				max = mid;
			}
			mid = (min + max) / 2;
		}

		return min;
	}
}