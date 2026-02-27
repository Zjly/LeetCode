package CY26;

/**
 * @author ZhangLei
 * @version 2026/02/28 00:08
 */
public class Question1680_连接连续二进制数字 {
    public int concatenatedBinary(int n) {
        final long MOD = 1000000007;
        long result = 0;

        for (int i = 1; i <= n; i++) {
            String binaryString = Integer.toBinaryString(i);
            result <<= binaryString.length();
            result = result % MOD;
            result += i;
            result = result % MOD;
        }

        return (int)(result % 1000000007L);
    }
}
