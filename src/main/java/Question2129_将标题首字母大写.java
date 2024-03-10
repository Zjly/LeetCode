import java.util.Locale;

/**
 * 代码
 * 测试用例
 * 测试结果
 * 测试结果
 * 2129. 将标题首字母大写
 * 第 69 场双周赛
 * Q1
 * 1275
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 * <p>
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
 * 否则，将单词首字母大写，剩余字母变成小写。
 * 请你返回 大写后 的 title 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：title = "capiTalIze tHe titLe"
 * 输出："Capitalize The Title"
 * 解释：
 * 由于所有单词的长度都至少为 3 ，将每个单词首字母大写，剩余字母变为小写。
 * 示例 2：
 * <p>
 * 输入：title = "First leTTeR of EACH Word"
 * 输出："First Letter of Each Word"
 * 解释：
 * 单词 "of" 长度为 2 ，所以它保持完全小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 * 示例 3：
 * <p>
 * 输入：title = "i lOve leetcode"
 * 输出："i Love Leetcode"
 * 解释：
 * 单词 "i" 长度为 1 ，所以它保留小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= title.length <= 100
 * title 由单个空格隔开的单词组成，且不含有任何前导或后缀空格。
 * 每个单词由大写和小写英文字母组成，且都是 非空 的。
 */

public class Question2129_将标题首字母大写 {
}

/**
 * @author Zhang Lei
 * @date 2024/3/11 0:08
 */
class Solution2129 {
    public String capitalizeTitle(String title) {
        String[] split = title.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            if (s.length() <= 2) {
                stringBuilder.append(s.toLowerCase()).append(" ");
            } else {
                char c = s.charAt(0);
                if (c >= 'a') {
                    c = (char)(c - 'a' + 'A');
                }
                String ss = s.substring(1);
                ss = ss.toLowerCase();
                stringBuilder.append(c).append(ss).append(" ");
            }
        }

        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}