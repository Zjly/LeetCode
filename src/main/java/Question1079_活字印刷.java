import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * 1079. 活字印刷
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 * <p>
 * 输入："AAABBC"
 * 输出：188
 * 示例 3：
 * <p>
 * 输入："V"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 */

public class Question1079_活字印刷 {
	Solution1079 solution1079 = new Solution1079();

	@Test
	public void test1() {
		String tiles = "ABCDEFG";
		Assertions.assertEquals(13699, solution1079.numTilePossibilities(tiles));
	}

	@Test
	public void test2() {
		String tiles = "HT";
		Assertions.assertEquals(4, solution1079.numTilePossibilities(tiles));
	}
}

class Solution1079 {
	int count = 0;

	public int numTilePossibilities(String tiles) {
		int[] counts = new int[26];
		for(int i = 0; i < tiles.length(); i++) {
			counts[tiles.charAt(i) - 'A']++;
		}
		dfs(counts, new StringBuilder(), new HashSet<>());
		return count;
	}

	public void dfs(int[] counts, StringBuilder stringBuilder, HashSet<String> hashSet) {
		if(!stringBuilder.toString().equals("")) {
			if(hashSet.contains(stringBuilder.toString())) {
				return;
			} else {
				hashSet.add(stringBuilder.toString());
				count++;
			}
		}

		for(int i = 0; i < 26; i++) {
			if(counts[i] != 0) {
				stringBuilder.append((char)(i + 'A'));
				counts[i]--;
				dfs(counts, stringBuilder, hashSet);
				stringBuilder.deleteCharAt(stringBuilder.length() - 1);
				counts[i]++;
			}
		}
	}
}