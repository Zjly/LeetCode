import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2788. 按分隔符拆分字符串
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串数组 words 和一个字符 separator ，请你按 separator 拆分 words 中的每个字符串。
 * <p>
 * 返回一个由拆分后的新字符串组成的字符串数组，不包括空字符串 。
 * <p>
 * 注意
 * <p>
 * separator 用于决定拆分发生的位置，但它不包含在结果字符串中。
 * 拆分可能形成两个以上的字符串。
 * 结果字符串必须保持初始相同的先后顺序。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["one.two.three","four.five","six"], separator = "."
 * 输出：["one","two","three","four","five","six"]
 * 解释：在本示例中，我们进行下述拆分：
 * <p>
 * "one.two.three" 拆分为 "one", "two", "three"
 * "four.five" 拆分为 "four", "five"
 * "six" 拆分为 "six"
 * <p>
 * 因此，结果数组为 ["one","two","three","four","five","six"] 。
 * 示例 2：
 * <p>
 * 输入：words = ["$easy$","$problem$"], separator = "$"
 * 输出：["easy","problem"]
 * 解释：在本示例中，我们进行下述拆分：
 * <p>
 * "$easy$" 拆分为 "easy"（不包括空字符串）
 * "$problem$" 拆分为 "problem"（不包括空字符串）
 * <p>
 * 因此，结果数组为 ["easy","problem"] 。
 * 示例 3：
 * <p>
 * 输入：words = ["|||"], separator = "|"
 * 输出：[]
 * 解释：在本示例中，"|||" 的拆分结果将只包含一些空字符串，所以我们返回一个空数组 [] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * words[i] 中的字符要么是小写英文字母，要么就是字符串 ".,|$#@" 中的字符（不包括引号）
 * separator 是字符串 ".,|$#@" 中的某个字符（不包括引号）
 */

public class Question2788_按分隔符拆分字符串 {
    Solution2788 solution2788 = new Solution2788();

    @Test
    public void test() {
        List<String> words = new ArrayList<>();
        words.add("one.two.three");
        words.add("four.five");
        words.add("six");
        char separator = '.';
        List<String> result = solution2788.splitWordsBySeparator(words, separator);
        System.out.println(result);
    }
}

/**
 * @author Zhang Lei
 * @date 2024/1/20 19:48
 */
class Solution2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            String[] split = word.split("\\" + String.valueOf(separator));
            for (String s : split) {
                if (!"".equals(s)) {
                    result.add(s);
                }
            }
        }

        return result;
    }
}