import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangLei
 * @version 2024/08/15 22:40
 */
public class Question3148_矩阵中的最大得分 {
    Solution3148 solution3148 = new Solution3148();

    @Test
    public void test() {
        List<Integer> row1 = new ArrayList<>();
        row1.add(4);
        row1.add(3);
        row1.add(2);

        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(2);
        row2.add(1);

        List<List<Integer>> grid = new ArrayList<>();
        grid.add(row1);
        grid.add(row2);

        System.out.println(solution3148.maxScore(grid));
    }
}

/**
 * @author Zhang Lei
 * @date 2024/08/15 22:40
 */
class Solution3148 {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dp = new int[m][n];
        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = Integer.MIN_VALUE;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid.get(i).get(j) - grid.get(i).get(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid.get(i).get(j) - grid.get(i - 1).get(j);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1] + grid.get(i).get(j) - grid.get(i).get(j - 1),
                            dp[i - 1][j] + grid.get(i).get(j) - grid.get(i - 1).get(j));
                }

                maxScore = Math.max(maxScore, dp[i][j]);
                dp[i][j] = Math.max(dp[i][j], 0);
            }
        }

        return maxScore;
    }
}