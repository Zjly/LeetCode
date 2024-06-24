import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Question503_NextGreaterElementII {
    Solution503_2 solution5032 = new Solution503_2();

    @Test
    public void test() {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(solution5032.nextGreaterElements(nums)));
    }
}

class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] nextBigNum = new int[nums.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < nums[i]) {
                int[] p = stack.pop();
                nextBigNum[p[1]] = nums[i];
            }

            stack.push(new int[]{nums[i], i});
        }

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek()[0] < num) {
                int[] p = stack.pop();
                nextBigNum[p[1]] = num;
            }
        }

        while (!stack.empty()) {
            int[] p = stack.pop();
            nextBigNum[p[1]] = -1;
        }

        return nextBigNum;
    }
}

/**
 * @author Zhang Lei
 * @date 2024/6/24 10:41
 */
class Solution503_2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] nextGreater = new int[nums.length];
        Arrays.fill(nextGreater, Integer.MIN_VALUE);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!deque.isEmpty() && nums[deque.peek()] < num) {
                int index = deque.pop();
                nextGreater[index] = num;
            }
            deque.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!deque.isEmpty() && nums[deque.peek()] < num) {
                int index = deque.pop();
                if (nextGreater[index] == Integer.MIN_VALUE) {
                    nextGreater[index] = num;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nextGreater[i] == Integer.MIN_VALUE) {
                nextGreater[i] = -1;
            }
        }

        return nextGreater;
    }
}