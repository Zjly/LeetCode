public class Question724_FindPivotIndex {
	public static void main(String[] args) {

	}
}

class Solution724 {
	public int pivotIndex(int[] nums) {
		int length = nums.length;

		if(length == 0) {
		    return -1;
		} else if(length == 1) {
		    return 0;
		}

		int left = 0;
		int right = 0;
		for(int i = 1; i < length; i++) {
			right += nums[i];
		}

		if(left == right) {
			return 0;
		}

		for(int i = 1; i < length; i++) {
			left += nums[i - 1];
			right -= nums[i];
			if(left == right) {
			    return i;
			}
		}

		return -1;
	}
}
