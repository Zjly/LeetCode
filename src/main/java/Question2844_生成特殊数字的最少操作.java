import org.junit.Test;

/**
 * 2844. 生成特殊数字的最少操作
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
 * <p>
 * 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
 * <p>
 * 返回最少需要多少次操作可以使 num 变成特殊数字。
 * <p>
 * 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "2245047"
 * 输出：2
 * 解释：删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
 * 可以证明要使数字变成特殊数字，最少需要删除 2 位数字。
 * 示例 2：
 * <p>
 * 输入：num = "2908305"
 * 输出：3
 * 解释：删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
 * 可以证明要使数字变成特殊数字，最少需要删除 3 位数字。
 * 示例 3：
 * <p>
 * 输入：num = "10"
 * 输出：1
 * 解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
 * 可以证明要使数字变成特殊数字，最少需要删除 1 位数字。
 * <p>
 * <p>
 * 提示
 * <p>
 * 1 <= num.length <= 100
 * num 仅由数字 '0' 到 '9' 组成
 * num 不含任何前导零
 */

public class Question2844_生成特殊数字的最少操作 {
    Solution2844 solution = new Solution2844();

    @Test
    public void test() {
        String num = "2245047";
        System.out.println(solution.minimumOperations(num));
    }
}

/**
 * @author Zhang Lei
 * @date 2024/7/25 下午10:21
 */
class Solution2844 {
    public int minimumOperations(String num) {
        boolean flag1 = true;
        boolean flag2 = true;
        int res1 = num.length();
        int res2 = num.length();
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (flag1) {
                if (c == '5') {
                    flag1 = false;
                }
            } else {
                if (c == '2' || c == '7') {
                    res1 = num.length() - i - 2;
                    break;
                }
            }

            if (flag2) {
                if (c == '0') {
                    flag2 = false;
                }
            } else {
                if (c == '0' || c == '5') {
                    res2 = num.length() - i - 2;
                    break;
                }
            }
        }

        if (!flag2) {
            res2 = Math.min(res2, num.length() - 1);
        }

        return Math.min(res1, res2);
    }
}