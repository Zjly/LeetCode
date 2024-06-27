/**
 * 2734. 执行子串操作后的字典序最小字符串
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以完成以下行为：
 * <p>
 * 选择 s 的任一非空子字符串，可能是整个字符串，接着将字符串中的每一个字符替换为英文字母表中的前一个字符。例如，'b' 用 'a' 替换，'a' 用 'z' 替换。
 * 返回执行上述操作 恰好一次 后可以获得的 字典序最小 的字符串。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * 现有长度相同的两个字符串 x 和 字符串 y ，在满足 x[i] != y[i] 的第一个位置 i 上，如果  x[i] 在字母表中先于 y[i] 出现，则认为字符串 x 比字符串 y 字典序更小 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "cbabc"
 * 输出："baabc"
 * 解释：我们选择从下标 0 开始、到下标 1 结束的子字符串执行操作。
 * 可以证明最终得到的字符串是字典序最小的。
 * 示例 2：
 * <p>
 * 输入：s = "acbbc"
 * 输出："abaab"
 * 解释：我们选择从下标 1 开始、到下标 4 结束的子字符串执行操作。
 * 可以证明最终得到的字符串是字典序最小的。
 * 示例 3：
 * <p>
 * 输入：s = "leetcode"
 * 输出："kddsbncd"
 * 解释：我们选择整个字符串执行操作。
 * 可以证明最终得到的字符串是字典序最小的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 仅由小写英文字母组成
 */

public class Question2734_执行子串操作后的字典序最小字符串 {
}

/**
 * @author Zhang Lei
 * @date 2024/6/27 下午11:54
 */
class Solution2734 {
    public String smallestString(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        int status = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 初始
            if (status == 0) {
                if(c != 'a') {
                    status = 1;
                    stringBuilder.append((char)(c - 1));
                } else {
                    if (i != s.length() - 1) {
                        stringBuilder.append(c);
                    } else {
                        stringBuilder.append('z');
                    }
                }
            }
            // 字符子串修改
            else if (status == 1) {
                if(c != 'a') {
                    stringBuilder.append((char)(c - 1));
                } else {
                    status = 2;
                    stringBuilder.append(c);
                }
            }
            // 已修改
            else if (status == 2) {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}