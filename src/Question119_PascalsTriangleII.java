import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */

public class Question119_PascalsTriangleII {
	public static void main(String[] args) {
		Solution119 solution119 = new Solution119();
		System.out.println(solution119.getRow(5));
	}
}

class Solution119 {
	public List<Integer> getRow(int rowIndex) {
		int[] array = new int[rowIndex + 1];
		array[0] = 1;
		for(int i = 1; i <= rowIndex; i++) {
			// 保存当前位置数据以免被覆盖
			int last = 1;
			for(int j = 1; j <= i / 2; j++) {
				int p = array[j];
				array[j] = last + array[j];
				last = p;
			}
			// 后半部分无需计算直接拷贝即可
			for(int j = i; j >= i / 2 + 1; j--) {
				array[j] = array[i - j];
			}
		}

		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < rowIndex + 1; i++) {
			list.add(array[i]);
		}
		return list;
	}
}
