package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/05 00:01
 */
public class Question1758_生成交替二进制字符串的最少操作数 {
    public int minOperations(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' != i % 2) {
                count++;
            }
        }
        return Math.min(count, s.length() - count);
    }
}
