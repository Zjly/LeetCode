package CY26;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangLei
 * @version 2026/02/23 22:29
 */
public class Question1461_检查一个字符串是否包含所有长度为K的二进制子串 {
	@Test
	public void test1() {
		assert Solution1461.hasAllCodes("00110110", 2);
	}

	@Test
	public void test2() {
		assert Solution1461.hasAllCodes("0110", 1);
	}

	@Test
	public void test3() {
		assert !Solution1461.hasAllCodes("0110", 2);
	}

	@Test
	public void test4() {
		assert Solution1461.hasAllCodes("00110", 2);
	}
}

class Solution1461 {
    public static boolean hasAllCodes(String s, int k) {
        // 1.前置判断长度是否满足最小限制 2^k+k-1
        if (s.length() < (1 << k) + k - 1) {
			return false;
        }

		// 2.初始化相关变量
	    // 子串代表的数值
		long sum = 0;
		// 使用二进制例如"1101"存储每个数位上是否已经达成
	    boolean[] sign = new boolean[1 << k];

		// 3.初始化第一个字符
	    for (int i = 0; i < k; i++) {
		    sum += (long)(s.charAt(i) - '0') << (k - i - 1);
	    }
		sign[Math.toIntExact(sum)] = true;

		// 4.计算后续每一个数位的值，直至结束
	    for (int i = 1; i < s.length() - k + 1; i++) {
		    // 减去前序字符的代表值
		    sum -= (long)(s.charAt(i - 1) - '0') << (k - 1);
			// 整体左移一位
		    sum = sum << 1;
			// 加上新字符的代表值
		    sum += (long)(s.charAt(i + k - 1) - '0');
			// 统计数字存在
		    sign[Math.toIntExact(sum)] = true;
	    }

		// 5.判断是否每个数字都被true了
	    for (long i = 0; i < (1L << k); i++) {
		    if (!sign[Math.toIntExact(i)]) {
		        return false;
		    }
	    }

		return true;
    }
}