package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/11 22:18
 */
public class Question1009_十进制整数的反码 {
    public int bitwiseComplement(int n) {
        String binaryString = Integer.toBinaryString(n);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < binaryString.length(); i++) {
            stringBuilder.append(binaryString.charAt(i) == '0' ? '1' : '0');
        }

        return Integer.valueOf(stringBuilder.toString(), 2);
    }
}
