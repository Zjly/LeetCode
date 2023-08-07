import java.lang.reflect.Array;
import java.util.Arrays;

public class Question1640_CheckArrayFormationThroughConcatenation {
	public static void main(String[] args) {
		int[] arr = new int[]{91, 4, 64, 78};
		int[][] pieces = new int[][]{{78}, {64, 4}, {91}};

		Solution1640 solution1640 = new Solution1640();
		System.out.println(solution1640.canFormArray(arr, pieces));
	}
}

class Solution1640 {
	public boolean canFormArray(int[] arr, int[][] pieces) {
		// 排序以便于折半查找
		Arrays.sort(pieces, (o1, o2) -> o1[0] < o2[0] ? -1 : 1);
		int index = 0;

		// 遍历每一个值
		while(index < arr.length) {
			int arrCurrent = arr[index];

			int[] piecesCurrent = findArr(pieces, arrCurrent);
			if(piecesCurrent == null) {
				return false;
			}

			// 顺序不一致返回false
			for(int i : piecesCurrent) {
				if(i != arr[index]) {
					return false;
				}
				index++;
			}
		}

		return true;
	}

	/**
	 * 折半查找
	 * @param pieces 待查找二维数组
	 * @param num 待查找的数
	 * @return 查到完毕后的一维数组
	 */
	public int[] findArr(int[][] pieces, int num) {
		int left = 0;
		int right = pieces.length - 1;

		while(left <= right) {
			int mid = (left + right) / 2;
			int midNum = pieces[mid][0];

			if(midNum == num) {
				return pieces[mid];
			} else if(midNum < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return null;
	}
}