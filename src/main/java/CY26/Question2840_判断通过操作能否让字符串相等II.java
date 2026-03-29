package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/30 00:04
 */
public class Question2840_判断通过操作能否让字符串相等II {
    public boolean checkStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[][] counts = new int[26][2];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a'][i % 2]++;
            counts[s2.charAt(i) - 'a'][i % 2]--;
        }

        for (int i = 0; i < 26; i++) {
            if (counts[i][0] != 0 || counts[i][1] != 0) {
                return false;
            }
        }

        return true;
    }
}
