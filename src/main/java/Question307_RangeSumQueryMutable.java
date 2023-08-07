/**
 * 307. 区域和检索 - 数组可修改
 * 给你一个数组 nums ，请你完成两类查询。
 * <p>
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
 */

public class Question307_RangeSumQueryMutable {
	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[]{1, 3, 5});
		System.out.println(numArray.sumRange(0, 2));
		numArray.update(1, 2);
		System.out.println(numArray.sumRange(0, 2));
	}

	static class NumArray {
		int[] nums;
		int[] binaryIndexTree;

		public int lowBit(int num) {
			return num & (-num);
		}

		public int query(int index) {
			int sum = 0;
			for(int i = index; i > 0; i -= lowBit(i)) {
				sum += binaryIndexTree[i];
			}
			return sum;
		}

		public void add(int index, int val) {
			for(int i = index; i < binaryIndexTree.length; i += lowBit(i)) {
				binaryIndexTree[i] += val;
			}
		}

		public NumArray(int[] nums) {
			this.nums = nums;
			binaryIndexTree = new int[nums.length + 1];
			for(int i = 0; i < nums.length; i++) {
				add(i + 1, nums[i]);
			}
		}

		public void update(int index, int val) {
			add(index + 1, val - nums[index]);
			nums[index] = val;
		}

		public int sumRange(int left, int right) {
			return query(right + 1) - query(left);
		}
	}

	/*
	 * Your NumArray object will be instantiated and called as such:
	 * NumArray obj = new NumArray(nums);
	 * obj.update(index,val);
	 * int param_2 = obj.sumRange(left,right);
	 */
}


