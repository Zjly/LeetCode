package CY26;

/**
 * @author ZhangLei
 * @version 2026/04/18 19:41
 */
public class Question3783_整数的镜像距离 {
    public int mirrorDistance(int n) {
        return Math.abs(n - Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString()));
    }
}
