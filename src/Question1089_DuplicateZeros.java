import java.util.Arrays;

/**
 * 1089. 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */

public class Question1089_DuplicateZeros {
	public static void main(String[] args) {
		Solution1089 solution1089 = new Solution1089();
		int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
		solution1089.duplicateZeros(arr);
		System.out.println(Arrays.toString(arr));
	}
}

class Solution1089 {
	public void duplicateZeros(int[] arr) {
		int index = 0;
		int count = 0;
		while(count < arr.length) {
			if(arr[index] == 0) {
				count += 2;
			} else {
				count++;
			}
			index++;
		}
		index--;

		int newIndex = arr.length - 1;
		if(count != arr.length) {
			arr[newIndex] = 0;
			newIndex--;
			index--;
		}

		while(newIndex >= 0) {
			if(arr[index] == 0) {
				arr[newIndex] = 0;
				newIndex--;
				arr[newIndex] = 0;
			} else {
				arr[newIndex] = arr[index];
			}

			newIndex--;
			index--;
		}
	}
}