import java.util.Arrays;
import java.util.Comparator;

/**
 * 2418. 按身高排序
 * 给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
 * <p>
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 * <p>
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
 * 输出：["Mary","Emma","John"]
 * 解释：Mary 最高，接着是 Emma 和 John 。
 * 示例 2：
 * <p>
 * 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * 输出：["Bob","Alice","Bob"]
 * 解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == names.length == heights.length
 * 1 <= n <= 103
 * 1 <= names[i].length <= 20
 * 1 <= heights[i] <= 105
 * names[i] 由大小写英文字母组成
 * heights 中的所有值互不相同
 */

public class Question2418_按身高排序 {
	public static void main(String[] args) {

	}
}

class Solution2418 {
	public String[] sortPeople(String[] names, int[] heights) {
		Integer[] indexes = new Integer[names.length];
		for(int i = 0; i < names.length; i++) {
			indexes[i] = i;
		}

		Arrays.sort(indexes, (a, b) -> heights[b] - heights[a]);
		String[] result = new String[names.length];
		for(int i = 0; i < names.length; i++) {
			result[i] = names[indexes[i]];
		}

		return result;
	}
}
