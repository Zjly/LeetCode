import java.util.HashMap;

/**
 * 2085. 统计出现过一次的公共字符串
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个字符串数组 words1 和 words2 ，请你返回在两个字符串数组中 都恰好出现一次 的字符串的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
 * 输出：2
 * 解释：
 * - "leetcode" 在两个数组中都恰好出现一次，计入答案。
 * - "amazing" 在两个数组中都恰好出现一次，计入答案。
 * - "is" 在两个数组中都出现过，但在 words1 中出现了 2 次，不计入答案。
 * - "as" 在 words1 中出现了一次，但是在 words2 中没有出现过，不计入答案。
 * 所以，有 2 个字符串在两个数组中都恰好出现了一次。
 * 示例 2：
 * <p>
 * 输入：words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
 * 输出：0
 * 解释：没有字符串在两个数组中都恰好出现一次。
 * 示例 3：
 * <p>
 * 输入：words1 = ["a","ab"], words2 = ["a","a","a","ab"]
 * 输出：1
 * 解释：唯一在两个数组中都出现一次的字符串是 "ab" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words1.length, words2.length <= 1000
 * 1 <= words1[i].length, words2[j].length <= 30
 * words1[i] 和 words2[j] 都只包含小写英文字母。
 */

public class Question2085_统计出现过一次的公共字符串 {
}

/**
 * @author Zhang Lei
 * @date 2024/1/12 10:45
 */
class Solution2085 {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String word : words1) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 10000);
        }

        for (String word : words2) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) - 1);
        }

        int count = 0;
        for (String key : hashMap.keySet()) {
        	if (hashMap.get(key) == 9999) {
        	    count++;
        	}
        }

        return count;
    }
}