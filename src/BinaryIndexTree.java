/**
 * 树状数组
 */
public class BinaryIndexTree {
	int[] binaryIndexTree;

	/**
	 * 根据给定数组初始化树状数组
	 * @param nums 给定数组
	 */
	public BinaryIndexTree(int[] nums) {
		binaryIndexTree = new int[nums.length + 1];
		for(int i = 0; i < nums.length; i++) {
			update(i + 1, nums[i]);
		}
	}

	/**
	 * 更新树状数组
	 * @param index 待更新的位置
	 * @param val 待增加的数值，即与原本数之差val_new - val_old
	 */
	public void update(int index, int val) {
		for(int i = index; i < binaryIndexTree.length; i += lowBit(i)) {
			binaryIndexTree[i] += val;
		}
	}

	/**
	 * 获得[1, index]之间的数之和
	 * @param index 索引
	 * @return 数之和
	 */
	public int getSum(int index) {
		int sum = 0;
		for(int i = index; i > 0; i -= lowBit(i)) {
			sum += binaryIndexTree[i];
		}
		return sum;
	}

	/**
	 * 获取数num的最低位
	 * @param num 待获取的数
	 * @return 最低位数 例如num = 6(110) 返回最低位2(10)
	 */
	public int lowBit(int num) {
		return num & (-num);
	}
}
