package CY26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangLei
 * @version 2026/03/03 00:16
 */
public class Question1545_找出第N个二进制字符串中的第K位 {
    public char findKthBit(int n, int k) {
        long mid = 1L << (n - 1);

        char kthBit;
        if (k == mid) {
            kthBit = mid == 1 ? '0' : '1';
        } else if (k < mid) {
            kthBit = findKthBit(n - 1, k);
        } else {
            kthBit = findKthBit(n - 1, Math.toIntExact(2 * mid - k)) == '0' ? '1' : '0';
        }
        return kthBit;
    }

    @Test
    public void test1() {
        Assertions.assertEquals('0', findKthBit(3, 1));
    }

    @Test
    public void test2() {
        Assertions.assertEquals('1', findKthBit(4, 11));
    }

    @Test
    public void test3() {
        Assertions.assertEquals('1', findKthBit(2, 3));
    }

    @Test
    public void test4() {
        Assertions.assertEquals('1', findKthBit(3, 3));
    }
}
