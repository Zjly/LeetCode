import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */

public class Question78_Subsets {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 4};
		Solution78 solution78 = new Solution78();
		System.out.println(solution78.subsets(nums));
	}
}

class Solution78 {
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> ans = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		dfs(nums, 0);

		return result;
	}

	public void dfs(int[] nums, int i) {
		if(i == nums.length) {
			result.add(new ArrayList<>(ans));
			return;
		}

		ans.add(nums[i]);
		dfs(nums, i + 1);
		ans.remove(ans.size() - 1);
		dfs(nums, i + 1);
	}
}