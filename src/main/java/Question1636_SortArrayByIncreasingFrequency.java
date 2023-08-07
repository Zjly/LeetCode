import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 1636. 按照频率将数组升序排序
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 * <p>
 * 请你返回排序后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * 示例 3：
 * <p>
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */

public class Question1636_SortArrayByIncreasingFrequency {
	public static void main(String[] args) {

	}
}

class Solution1636 {
	public int[] frequencySort(int[] nums) {
		int[] counts = new int[201];
		for(int num : nums) {
			counts[num + 100]++;
		}

		ArrayList<int[]> arrayList = new ArrayList<>();
		for(int i = 0; i < counts.length; i++) {
			if(counts[i] != 0) {
			    arrayList.add(new int[]{counts[i], i + 100});
			}
		}

		arrayList.sort((a, b) -> {
			if(a[0] == b[0]) {
				return b[1] - a[1];
			}

			return a[0] - b[0];
		});

		int[] result = new int[nums.length];
		int index = 0;
		for(int[] count : arrayList) {
			for(int i = 0; i < count[0]; i++) {
				result[index] = count[1] - 100;
				index++;
			}
		}

		return result;
	}
}