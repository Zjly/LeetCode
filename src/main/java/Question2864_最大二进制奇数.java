/**
 * 2864. 最大二进制奇数
 * 第 364 场周赛
 * Q1
 * 1238
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
 * <p>
 * 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
 * <p>
 * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
 * <p>
 * 注意 返回的结果字符串 可以 含前导零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "010"
 * 输出："001"
 * 解释：因为字符串 s 中仅有一个 '1' ，其必须出现在最后一位上。所以答案是 "001" 。
 * 示例 2：
 * <p>
 * 输入：s = "0101"
 * 输出："1001"
 * 解释：其中一个 '1' 必须出现在最后一位上。而由剩下的数字可以生产的最大数字是 "100" 。所以答案是 "1001" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅由 '0' 和 '1' 组成
 * s 中至少包含一个 '1'
 */

public class Question2864_最大二进制奇数 {
}

/**
 * @author Zhang Lei
 * @date 2024/3/13 0:07
 */
class Solution2864 {
    public String maximumOddBinaryNumber(String s) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zero++;
            } else {
                one++;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < one - 1; i++) {
            stringBuilder.append('1');
        }

        for (int i = 0; i < zero; i++) {
        	stringBuilder.append('0');
        }

        stringBuilder.append('1');
        return stringBuilder.toString();
    }
}