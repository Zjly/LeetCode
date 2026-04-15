package CY26;

import java.util.Objects;

/**
 * @author ZhangLei
 * @version 2026/04/15 23:08
 */
public class Question2515_到目标字符串的最短距离 {
    public int closestTarget(String[] words, String target, int startIndex) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (Objects.equals(words[(i + startIndex) % words.length], target)) {
                int dis = Math.min(i, words.length - i);
                res = Math.min(res, dis);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
