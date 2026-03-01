package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/01 10:53
 */
public class Question1689_十二进制数的最少数目 {
    public int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); i++) {
            int c = n.charAt(i) - '0';
            res = Math.max(res, c);
        }

        return res;
    }
}
