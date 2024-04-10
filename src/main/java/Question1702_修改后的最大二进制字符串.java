import org.junit.jupiter.api.Test;

/**
 * 1702. 修改后的最大二进制字符串
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
 * <p>
 * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 * 比方说， "00010" -> "10010"
 * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 * 比方说， "00010" -> "00001"
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：binary = "000110"
 * 输出："111011"
 * 解释：一个可行的转换为：
 * "000110" -> "000101"
 * "000101" -> "100101"
 * "100101" -> "110101"
 * "110101" -> "110011"
 * "110011" -> "111011"
 * 示例 2：
 * <p>
 * 输入：binary = "01"
 * 输出："01"
 * 解释："01" 没办法进行任何转换。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= binary.length <= 105
 * binary 仅包含 '0' 和 '1' 。
 */

public class Question1702_修改后的最大二进制字符串 {
    Solution1702 solution1702 = new Solution1702();

    @Test
    public void test() {
        String binary = "1101";
        System.out.println(solution1702.maximumBinaryString(binary));
    }
}

/**
 * @author Zhang Lei
 * @date 2024/4/10 下午1:25
 */
class Solution1702 {
    public String maximumBinaryString(String binary) {
        int zeros = 0;
        int beginIndex = -1;
        for (int i = 0; i < binary.length(); i++) {
            if (beginIndex == -1 && binary.charAt(i) == '0') {
                beginIndex = i;
            }

            if (binary.charAt(i) == '0') {
                zeros++;
            }
        }

        if (zeros == 0) {
            return binary;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < beginIndex; i++) {
            stringBuilder.append('1');
        }

        for (int i = beginIndex; i < binary.length(); i++) {
            if (zeros == 1) {
                stringBuilder.append('0');
            } else {
                stringBuilder.append('1');
            }
            zeros--;
        }

        return stringBuilder.toString();
    }
}