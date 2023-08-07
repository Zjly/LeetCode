import java.util.*;

/**
 * 1345. 跳跃游戏 IV
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * 每一步，你可以从下标 i 跳到下标：
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * 注意：任何时候你都不能跳到数组外面。
 * <p>
 * 示例 1：
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * <p>
 * 示例 2：
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * <p>
 * 示例 3：
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * <p>
 * 示例 4：
 * 输入：arr = [6,1,9]
 * 输出：2
 * <p>
 * 示例 5：
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 */

public class Question1345_JumpGameIV {
	public static void main(String[] args) {
		Solution1345 solution1345 = new Solution1345();
		int[] arr = {7, 7, 7, 7, 11};
		System.out.println(solution1345.minJumps(arr));
	}
}

class Solution1345 {
	public int minJumps(int[] arr) {
		HashMap<Integer, List<Integer>> numIndexHashMap = new HashMap<>();
		// 创建索引哈希表
		for(int i = 0; i < arr.length; i++) {
			List<Integer> list = numIndexHashMap.getOrDefault(arr[i], new ArrayList<>());
			list.add(i);
			numIndexHashMap.put(arr[i], list);
		}

		Queue<Integer> indexQueue = new LinkedList<>();
		Set<Integer> indexArriveSet = new HashSet<>();
		Set<Integer> numArriveSet = new HashSet<>();
		indexQueue.add(0);
		indexArriveSet.add(0);

		int jumpCount = 0;
		while(true) {
			int size = indexQueue.size();
			for(int i = 0; i < size; i++) {
				int index = indexQueue.poll();
				if(index == arr.length - 1) {
					return jumpCount;
				}

				if(index > 0 && !indexArriveSet.contains(index - 1)) {
					indexQueue.offer(index - 1);
					indexArriveSet.add(index - 1);
				}

				if(index < arr.length - 1 && !indexArriveSet.contains(index + 1)) {
					indexQueue.offer(index + 1);
					indexArriveSet.add(index + 1);
				}

				if(!numArriveSet.contains(arr[index])) {
					numArriveSet.add(arr[index]);

					List<Integer> list = numIndexHashMap.get(arr[index]);
					for(Integer nextIndex : list) {
						if(!indexArriveSet.contains(nextIndex)) {
							indexQueue.offer(nextIndex);
							indexArriveSet.add(nextIndex);
						}
					}
				}

			}
			jumpCount++;
		}
	}
}