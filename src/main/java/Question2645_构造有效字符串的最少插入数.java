import org.junit.jupiter.api.Test;

/**
 * 2645. 构造有效字符串的最少插入数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
 * <p>
 * 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "b"
 * 输出：2
 * 解释：在 "b" 之前插入 "a" ，在 "b" 之后插入 "c" 可以得到有效字符串 "abc" 。
 * 示例 2：
 * <p>
 * 输入：word = "aaa"
 * 输出：6
 * 解释：在每个 "a" 之后依次插入 "b" 和 "c" 可以得到有效字符串 "abcabcabc" 。
 * 示例 3：
 * <p>
 * 输入：word = "abc"
 * 输出：0
 * 解释：word 已经是有效字符串，不需要进行修改。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 50
 * word 仅由字母 "a"、"b" 和 "c" 组成。
 */

public class Question2645_构造有效字符串的最少插入数 {
    Solution2645 solution2645 = new Solution2645();

    @Test
    public void test() {
        String word = "b";
        System.out.println(solution2645.addMinimum(word));
    }

    @Test
    public void test2() {
        String word = "aaa";
        System.out.println(solution2645.addMinimum(word));
    }
}

/**
 * @author Zhang Lei
 * @date 2024/1/11 17:00
 */
class Solution2645 {
    public int addMinimum(String word) {
        int beginIndex = 0;
        int count = 0;
        int[] insertCount;
        do {
            insertCount = getInsertCount(word, beginIndex);
            count += insertCount[0];
            beginIndex = insertCount[1];
        } while (insertCount[1] != -1);

        return count;
    }

    public int[] getInsertCount(String word, int beginIndex) {
        if (beginIndex >= word.length()) {
            return new int[]{0, -1};
        }

        if (word.charAt(beginIndex) == 'a') {
            int index = beginIndex + 1;

            if (index == word.length()) {
                return new int[]{2, -1};
            } else {
                if (word.charAt(index) == 'b') {
                    index++;
                    if (index == word.length()) {
                        return new int[]{1, -1};
                    } else {
                        if (word.charAt(index) == 'c') {
                            return new int[]{0, index + 1};
                        } else {
                            return new int[]{1, index};
                        }
                    }
                } else if (word.charAt(index) == 'c') {
                    return new int[]{1, index + 1};
                } else {
                    return new int[]{2, index};
                }
            }
        } else if (word.charAt(beginIndex) == 'b') {
            int index = beginIndex + 1;

            if (index == word.length()) {
                return new int[]{2, -1};
            } else {
                if (word.charAt(index) == 'c') {
                    return new int[]{1, index + 1};
                } else {
                    return new int[]{2, index};
                }
            }
        } else {
            return new int[]{2, beginIndex + 1};
        }
    }
}