import java.util.Arrays;

// TODO 暂未解决
/**
 * 321. 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 * 说明: 请尽可能地优化你算法的时间和空间复杂度。
 * <p>
 * 示例 1:
 * 输入:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * 输出:
 * [9, 8, 6, 5, 3]
 * <p>
 * 示例 2:
 * 输入:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * 输出:
 * [6, 7, 6, 0, 4]
 * <p>
 * 示例 3:
 * 输入:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * 输出:
 * [9, 8, 9]
 */

public class Question321_CreateMaximumNumber {
	public static void main(String[] args) {
		Solution321 solution321 = new Solution321();
		int[] nums1 = new int[]{4, 1, 1, 4};
		int[] nums2 = new int[]{4, 3, 1, 3};

		for(int i = 8; i <= 8; i++) {
			int[] result = solution321.maxNumber(nums1, nums2, i);
			System.out.println(Arrays.toString(result));
		}
	}
}

class Solution321 {
	int[] result;
	int index;
	int[] indexArray;

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		result = new int[k];

		// 两个数组的当前索引位置
		indexArray = new int[]{0, 0};

		// 逐个添加数字
		for(index = 0; index < k; index++) {
			int maxNumber = getMaxNumberAndLocation(nums1, nums2, k, indexArray, index);
			if(index == k) {
				break;
			}
			if(maxNumber == -1) {
				break;
			}
			result[index] = maxNumber;
		}

		return result;
	}

	public int getMaxNumberAndLocation(int[] nums1, int[] nums2, int k, int[] indexArray, int index) {
		// 剩余待添加数字数量
		int totalRemain = k - index - 1;

		// 两个数组在当前索引下所剩余的数字个数
		int remain1 = nums1.length - indexArray[0];
		int remain2 = nums2.length - indexArray[1];

		// 最大值以及位置
		int maxNum = -1;
		int maxLocation = -1;
		int maxIndex = -1;
		boolean isEqual = false;
		int[] indexArray1 = indexArray.clone();
		int[] indexArray2 = indexArray.clone();
		boolean isFirst = true;

		// 在数组1内寻找
		for(int j = indexArray[0]; j < nums1.length; j++) {
			int currentNum = nums1[j];
			int currentRemain = nums1.length - j - 1 + remain2;

			// 接下来的数字剩余不足以满足总剩余，即后方的数字都无法满足要求
			if(currentRemain < totalRemain) {
				break;
			}

			// 找到更大值
			if(currentNum > maxNum) {
				maxNum = currentNum;
				maxLocation = 0;
				maxIndex = j;
			}
		}

		// 在数组2内寻找
		for(int j = indexArray[1]; j < nums2.length; j++) {
			int currentNum = nums2[j];
			int currentRemain = nums2.length - j - 1 + remain1;
			if(currentRemain < totalRemain) {
				break;
			}

			if(currentNum > maxNum) {
				maxNum = currentNum;
				maxLocation = 1;
				maxIndex = j;
				isEqual = false;
			} else if(currentNum == maxNum && isFirst && maxLocation == 0) {
				isFirst = false;
				indexArray1[0] = maxIndex + 1;
				indexArray2[1] = j + 1;

				isEqual = true;
			}
		}

		if(isEqual) {
			result[index] = maxNum;
			boolean isOver = equalTreatment(nums1, nums2, k, indexArray1, indexArray2, index);
			if(isOver) {
				return -1;
			}

			if(this.index == k) {
				return result[this.index - 1];
			}
			return result[this.index];
		}

		// 更改当前索引位置
		if(maxLocation == 0) {
			indexArray[0] = maxIndex + 1;
		} else if(maxLocation == 1) {
			indexArray[1] = maxIndex + 1;
		}

		return maxNum;
	}

	public boolean equalTreatment(int[] nums1, int[] nums2, int k, int[] indexArray1, int[] indexArray2, int index) {
		int[] result1 = result.clone();
		int[] result2 = result.clone();

		for(int i = index + 1; i < k; i++) {
			if(Arrays.equals(indexArray1, indexArray2)) {
				result = result1;
				indexArray = indexArray1;
				this.index = i - 1;
				return false;
			}

			int num1 = getMaxNumberAndLocation(nums1, nums2, k, indexArray1, i);
			if(this.index > i) {
				return false;
			}
			int num2 = getMaxNumberAndLocation(nums1, nums2, k, indexArray2, i);
			if(this.index > i) {
				return false;
			}

			result1[i] = num1;
			result2[i] = num2;

			if(num1 > num2) {
				result = result1;
				indexArray = indexArray1;
				this.index = i;
				return false;
			}
			if(num1 < num2) {
				result = result2;
				indexArray = indexArray2;
				this.index = i;
				return false;
			}
		}

		result = result1;
		indexArray = indexArray1;
		this.index = k;
		return true;
	}
}
