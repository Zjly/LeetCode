package CY26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangLei
 * @version 2026/03/07 19:39
 */
public class Question1888_使二进制字符串字符交替的最少反转次数 {
    public int minFlips(String s) {
        int zeroCountF = 0;
        int oneCountF = 0;

        int zeroCountE = operations(s);
        int oneCountE = s.length() - zeroCountE;

        int res = Math.min(zeroCountE, oneCountE);
        if (s.length() % 2 == 0) {
            return res;
        }

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';

            if (i % 2 == num) {
                oneCountF++;
                oneCountE--;
            } else {
                zeroCountF++;
                zeroCountE--;
            }

            res = Math.min(res, Math.min(zeroCountF, oneCountF) + Math.min(zeroCountE, oneCountE));
        }

        return res;
    }

    private int operations(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' != i % 2) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test1() {
        Assertions.assertEquals(4, minFlips("001000000010"));
    }
}
