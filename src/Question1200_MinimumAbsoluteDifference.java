import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */

public class Question1200_MinimumAbsoluteDifference {
	public static void main(String[] args) {

	}
}

class Solution1200 {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);

		int minAbs = Integer.MAX_VALUE;
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i + 1] - arr[i] < minAbs) {
			    minAbs = arr[i + 1] - arr[i];
				result = new ArrayList<>();
				result.add(Arrays.asList(arr[i], arr[i + 1]));
			} else if(arr[i + 1] - arr[i] == minAbs) {
				result.add(Arrays.asList(arr[i], arr[i + 1]));
			}
		}

		return result;
	}
}