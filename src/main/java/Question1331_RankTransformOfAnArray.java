import java.util.*;

/**
 * 1331. 数组序号转换
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * <p>
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * <p>
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 * 示例 2：
 * <p>
 * 输入：arr = [100,100,100]
 * 输出：[1,1,1]
 * 解释：所有元素有相同的序号。
 * 示例 3：
 * <p>
 * 输入：arr = [37,12,28,9,100,56,80,5,12]
 * 输出：[5,3,4,2,8,6,7,1,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= arr.length <= 105
 * -109 <= arr[i] <= 109
 */

public class Question1331_RankTransformOfAnArray {
	public static void main(String[] args) {

	}
}

class Solution1331 {
	public int[] arrayRankTransform(int[] arr) {
		HashSet<Integer> hashSet = new HashSet<>();
		for(int num : arr) {
			hashSet.add(num);
		}

		List<Integer> sorted = new ArrayList<>(hashSet);
		Collections.sort(sorted);

		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for(int i = 0; i < sorted.size(); i++) {
			hashMap.put(sorted.get(i), i + 1);
		}

		for(int i = 0; i < arr.length; i++) {
			arr[i] = hashMap.get(arr[i]);
		}

		return arr;
	}
}