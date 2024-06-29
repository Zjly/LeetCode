/**
 * 2710. 移除字符串中的尾随零
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "51230100"
 * 输出："512301"
 * 解释：整数 "51230100" 有 2 个尾随零，移除并返回整数 "512301" 。
 * 示例 2：
 * <p>
 * 输入：num = "123"
 * 输出："123"
 * 解释：整数 "123" 不含尾随零，返回整数 "123" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num.length <= 1000
 * num 仅由数字 0 到 9 组成
 * num 不含前导零
 */

public class Question2710_移除字符串中的尾随零 {
}

/**
 * @author Zhang Lei
 * @date 2024/6/29 下午11:02
 */
class Solution2710 {
    public String removeTrailingZeros(String num) {
        int index = -1;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                index = i;
            }
        }

        return num.substring(0, index + 1);
    }
}