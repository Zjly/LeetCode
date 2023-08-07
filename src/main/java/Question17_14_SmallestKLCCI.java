import java.util.Arrays;

/**
 * 面试题 17.14. 最小K个数
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * <p>
 * 提示：
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 */

public class Question17_14_SmallestKLCCI {
	public static void main(String[] args) {
		Solution17_14 solution17_14 = new Solution17_14();
		int[] arr = {1,3,5,7,2,4,6,8};
		int k = 4;
		System.out.println(Arrays.toString(solution17_14.smallestK(arr, k)));
	}
}

class Solution17_14 {
	public int[] smallestK(int[] arr, int k) {
		KSort(arr, 0, arr.length - 1, k);
		return Arrays.copyOf(arr, k);
	}

	private void KSort(int[] arr, int begin, int end, int k) {
		if(begin >= k || begin >= end) {
		    return;
		}

		int standard = arr[begin];
		int left = begin;
		int right = end;
		while(left < right) {
		    while(left < right && arr[right] >= standard) {
			    right--;
		    }
		    arr[left] = arr[right];
		    while(left < right && arr[left] <= standard) {
			    left++;
		    }
		    arr[right] = arr[left];
		}

		arr[left] = standard;

		KSort(arr, begin, left - 1, k);
		KSort(arr, left + 1, end, k);
	}
}