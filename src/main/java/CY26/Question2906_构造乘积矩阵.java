package CY26;

/**
 * @author ZhangLei
 * @version 2026/03/24 21:25
 */
public class Question2906_构造乘积矩阵 {
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;

        // 将二维展平为一维视角
        // pre[i] = 位置 i 之前所有元素的乘积
        long[] pre = new long[total];
        // suf[i] = 位置 i 之后所有元素的乘积
        long[] suf = new long[total];

        // 计算前缀积
        pre[0] = 1;
        for (int i = 1; i < total; i++) {
            int r = (i - 1) / m, c = (i - 1) % m;
            pre[i] = pre[i - 1] * grid[r][c] % MOD;
        }

        // 计算后缀积
        suf[total - 1] = 1;
        for (int i = total - 2; i >= 0; i--) {
            int r = (i + 1) / m, c = (i + 1) % m;
            suf[i] = suf[i + 1] * grid[r][c] % MOD;
        }

        // 构造结果矩阵
        int[][] ans = new int[n][m];
        for (int i = 0; i < total; i++) {
            int r = i / m, c = i % m;
            ans[r][c] = (int) (pre[i] * suf[i] % MOD);
        }

        return ans;
    }
}
