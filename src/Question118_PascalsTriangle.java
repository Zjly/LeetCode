import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */

public class Question118_PascalsTriangle {
	public static void main(String[] args) {
		Solution118 solution118 = new Solution118();

		List<List<Integer>> result = solution118.generate(5);
		System.out.println(Arrays.deepToString(result.toArray()));
	}
}

class Solution118 {
	public List<List<Integer>> generate(int numRows) {
		ArrayList<List<Integer>> result = new ArrayList<>();

		for(int row = 1; row <= numRows; row++) {
			ArrayList<Integer> arrayList = new ArrayList<>();

			// 构造后续层
			arrayList.add(1);
			for(int index = 1; index < row - 1; index++) {
				arrayList.add(result.get(row - 2).get(index - 1) + result.get(row - 2).get(index));
			}

			// 第一层不需要加入最后的1
			if(row != 1) {
				arrayList.add(1);
			}
			result.add(arrayList);
		}

		return result;
	}
}
