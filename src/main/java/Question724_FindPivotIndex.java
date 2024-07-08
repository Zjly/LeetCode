import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Question724_FindPivotIndex {
    Solution724_2 solution7242 = new Solution724_2();

    @Test
    public void test() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        Assertions.assertEquals(3, solution7242.pivotIndexFail(nums));
    }

    @Test
    public void test2() {
        int[] nums = {-1, -1, -1, -1, -1, 0};
        Assertions.assertEquals(2, solution7242.pivotIndexFail(nums));
    }
}

class Solution724 {
    public int pivotIndex(int[] nums) {
        int length = nums.length;

        if (length == 0) {
            return -1;
        } else if (length == 1) {
            return 0;
        }

        int left = 0;
        int right = 0;
        for (int i = 1; i < length; i++) {
            right += nums[i];
        }

        if (left == right) {
            return 0;
        }

        for (int i = 1; i < length; i++) {
            left += nums[i - 1];
            right -= nums[i];
            if (left == right) {
                return i;
            }
        }

        return -1;
    }
}

class Solution724_2 {
    // 失败 原因是没有考虑到负数 仅仅通过大小来判断游标的位置是不合理的
    public int pivotIndexFail(int[] nums) {
        int length = nums.length;

        if (length == 0) {
            return -1;
        } else if (length == 1) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (left < right) {
            if (leftSum >= rightSum) {
                rightSum += nums[right];
                right--;
            } else {
                leftSum += nums[left];
                left++;
            }
        }

        return leftSum == rightSum ? left : -1;
    }
}
