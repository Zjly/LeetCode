import java.util.Arrays;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 * <p>
 * 注意：
 * 总人数少于1100人。
 * <p>
 * 示例
 * <p>
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

public class Question406_QueueReconstructionByHeight {
	public static void main(String[] args) {
		Solution406 solution406 = new Solution406();
		int[][] people = new int[][]{{2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}};
		System.out.println(Arrays.deepToString(people));
		System.out.println(Arrays.deepToString(solution406.reconstructQueue(people)));
	}
}

class Solution406 {
	public int[][] reconstructQueue(int[][] people) {
		// 二维数组排序
		Arrays.sort(people, (o1, o2) -> {
			// 第二维升序，第一维降序
			if(o1[1] == o2[1]) {
				if(o1[1] != 0) {
					return o2[0] - o1[0];
				} else {
					return o1[0] - o2[0];
				}
			}
			return o1[1] - o2[1];
		});

		// 依次排列插入每一个新的数据
		for(int i = 0; i < people.length; i++) {
			int[] current = people[i];
			int count = current[1];

			// 第二维为0的不需要排列
			if(count == 0) {
				continue;
			}

			// 寻找插入位置
			int j = 0;
			while(count > 0 && j < i) {
				// 如果在前方有比当前身高高的出现，则计数
				if(current[0] <= people[j][0]) {
					count--;
				}
				j++;
			}

			// 寻找到位置后进行交换
			for(int k = i; k > j; k--) {
				int[] p = people[k - 1];
				people[k - 1] = people[k];
				people[k] = p;
			}
		}

		return people;
	}
}
