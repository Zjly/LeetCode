package CY26;

/**
 * @author ZhangLei
 * @version 2026/04/08 22:30
 */
public class Question3653_区间乘法查询后的异或I {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        final int MOD = 1000000007;
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1]; i += query[2]) {
                long num = ((long)nums[i] * query[3]) % MOD;
                nums[i] = (int)num;
            }
        }

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }
}
