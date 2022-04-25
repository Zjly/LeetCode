import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 398. 随机数索引
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * <p>
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * <p>
 * 示例:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 * <p>
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 */

public class Question398_RandomPickIndex {
	public static void main(String[] args) {

	}
}

class Solution398 {
	HashMap<Integer, ArrayList<Integer>> hashMap;
	Random random;

	public Solution398(int[] nums) {
		hashMap = new HashMap<>();
		random = new Random();
		for(int i = 0; i < nums.length; i++) {
			ArrayList<Integer> indexArrayList = hashMap.getOrDefault(nums[i], new ArrayList<>());
			indexArrayList.add(i);
			hashMap.put(nums[i], indexArrayList);
		}
	}

	public int pick(int target) {
		ArrayList<Integer> indexArrayList = hashMap.get(target);
		int size = indexArrayList.size();
		return indexArrayList.get(random.nextInt(size));
	}
}

/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */