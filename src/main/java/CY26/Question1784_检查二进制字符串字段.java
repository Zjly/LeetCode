package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/06 01:10
 */
public class Question1784_检查二进制字符串字段 {
    public boolean checkOnesSegment(String s) {
        boolean zeroMode = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zeroMode = true;
            } else if (c == '1' && zeroMode) {
                return false;
            }
        }

        return true;
    }
}
