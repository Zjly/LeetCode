package CY26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author ZhangLei
 * @version 2026/03/08 00:09
 */
public class Question1980_找出不同的二进制字符串 {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }

    @Test
    public void test1() {
        String[] nums = {"00", "01"};
        String result = findDifferentBinaryString(nums);
        Assertions.assertFalse(Arrays.asList(nums).contains(result));
        Assertions.assertEquals(nums.length, result.length());
    }

    @Test
    public void test2() {
        String[] nums = {"111", "011", "001"};
        String result = findDifferentBinaryString(nums);
        Assertions.assertFalse(Arrays.asList(nums).contains(result));
        Assertions.assertEquals(nums.length, result.length());
    }
}
