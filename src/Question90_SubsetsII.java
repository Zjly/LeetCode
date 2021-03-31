import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */

public class Question90_SubsetsII {
	public static void main(String[] args) {

	}
}

class Solution90 {
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> ans = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		dfs(nums, 0, false);
		return result;
	}

	public void dfs(int[] nums, int i, boolean last) {
		if(i == nums.length) {
			result.add(new ArrayList<>(ans));
			return;
		}

		dfs(nums, i + 1, false);
		if(!last && i > 0 && nums[i] == nums[i - 1]) {
		    return;
		}
		ans.add(nums[i]);
		dfs(nums, i + 1, true);
		ans.remove(ans.size() - 1);
	}
}
