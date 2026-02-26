package CY26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangLei
 * @version 2026/02/26 14:11
 */
public class Question1404_将二进制表示减到1的步骤数 {
    public int numSteps(String s) {
        int count = 0;
        boolean flip = false;
        int index = s.length() - 1;
        while (index >= 0) {
            boolean zero = s.charAt(index) == '0';

            if (index == 0 && !flip && !zero) {
                return count;
            }

            if (flip) {
                if (zero) {
                    flip = false;
                }

                zero = !zero;
            }

            if (zero) {
                count += 1;
            } else {
                count += 2;
                flip = true;
            }

            index--;
        }

        return count;
    }

    @Test
    public void test1() {
        Assertions.assertEquals(8, numSteps("10101"));
    }
}
