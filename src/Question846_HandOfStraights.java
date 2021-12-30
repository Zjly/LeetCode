import java.util.*;

/**
 * 846. 一手顺子
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * <p>
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 * <p>
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 */

public class Question846_HandOfStraights {
	public static void main(String[] args) {
		Solution846 solution846 = new Solution846();
		int[] hand = {53, 78, 62, 108, 83, 56, 66, 110, 49, 104, 117, 123, 86, 131, 94, 107, 84, 103, 42, 127, 100, 50, 55, 97, 81, 93, 71, 45, 63, 39, 91, 87, 129, 126, 84, 125, 73, 95, 116, 47, 106, 52, 121, 54, 38, 68, 69, 76, 89, 90, 57, 67, 86, 114, 64, 87, 79, 92, 115, 60, 51, 105, 132, 101, 59, 130, 44, 85, 80, 82, 48, 65, 128, 102, 74, 61, 40, 46, 98, 111, 109, 119, 72, 43, 112, 120, 58, 113, 77, 88, 41, 118, 75, 85, 124, 122, 96, 83, 99, 70};
		int groupSize = 50;
		System.out.println(solution846.isNStraightHand(hand, groupSize));
	}
}

class Solution846 {
	public boolean isNStraightHand(int[] hand, int groupSize) {
		if(hand.length % groupSize != 0) {
			return false;
		}

		HashMap<Integer, Integer> cardsCountHashMap = new HashMap<>();

		Arrays.sort(hand);
		for(int card : hand) {
			cardsCountHashMap.put(card, cardsCountHashMap.getOrDefault(card, 0) + 1);
		}

		TreeSet<Integer> set = new TreeSet<>(cardsCountHashMap.keySet());
		for(int key : set) {
			if(cardsCountHashMap.get(key) == 0) {
				continue;
			}

			int cardCount = cardsCountHashMap.get(key);
			for(int i = key; i < groupSize + key; i++) {
				if(cardsCountHashMap.containsKey(i) && cardsCountHashMap.get(i) >= cardCount) {
					cardsCountHashMap.put(i, cardsCountHashMap.getOrDefault(i, 0) - cardCount);
				} else {
					return false;
				}
			}
		}

		return true;
	}
}