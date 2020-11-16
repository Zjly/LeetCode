package Explanation;

import java.util.Arrays;
import java.util.LinkedList;

public class EQuestion406 {
	public static void main(String[] args) {
		Solution406 solution406 = new Solution406();
		int[][] people = new int[][]{{2, 4}, {3, 4}, {9, 0}, {0, 6}, {7, 1}, {6, 0}, {7, 3}, {2, 5}, {1, 1}, {8, 0}};
		System.out.println(Arrays.deepToString(people));
		System.out.println(Arrays.deepToString(solution406.reconstructQueue(people)));
	}
}

class Solution406 {
	/**
	 * 解题思路：先排序再插入
	 * 1.排序规则：按照先H高度降序，K个数升序排序
	 * 2.遍历排序后的数组，根据K插入到K的位置上
	 * <p>
	 * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
	 */
	public int[][] reconstructQueue(int[][] people) {
		// [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
		// 再一个一个插入。
		// [7,0]
		// [7,0], [7,1]
		// [7,0], [6,1], [7,1]
		// [5,0], [7,0], [6,1], [7,1]
		// [5,0], [7,0], [5,2], [6,1], [7,1]
		// [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
		Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

		LinkedList<int[]> list = new LinkedList<>();
		for(int[] i : people) {
			list.add(i[1], i);
		}

		return list.toArray(new int[list.size()][2]);
	}
}
