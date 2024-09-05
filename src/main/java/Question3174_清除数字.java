/**
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 3174. 清除数字
 * 算术评级: 2
 * 第 132 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1255
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 。
 * <p>
 * 你的任务是重复以下操作删除 所有 数字字符：
 * <p>
 * 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
 * 请你返回删除所有数字字符以后剩下的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * <p>
 * 输出："abc"
 * <p>
 * 解释：
 * <p>
 * 字符串中没有数字。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cb34"
 * <p>
 * 输出：""
 * <p>
 * 解释：
 * <p>
 * 一开始，我们对 s[2] 执行操作，s 变为 "c4" 。
 * <p>
 * 然后对 s[1] 执行操作，s 变为 "" 。
 */

import org.junit.jupiter.api.Test;

/**
 * @author ZhangLei
 * @version 2024/09/05 22:01
 */
public class Question3174_清除数字 {
    Solution3174 solution3174 = new Solution3174();

    @Test
    public void test() {
        String s = "af";
        System.out.println(solution3174.clearDigits(s));
    }
}

/**
 * @author Zhang Lei
 * @date 2024/09/05 22:02
 */
class Solution3174 {
    public String clearDigits(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}