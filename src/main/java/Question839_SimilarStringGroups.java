/**
 * 839. 相似字符串组
 * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。
 * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
 * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
 * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
 * <p>
 * 示例 1：
 * 输入：strs = ["tars","rats","arts","star"]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：strs = ["omv","ovm"]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= strs.length <= 100
 * 1 <= strs[i].length <= 1000
 * sum(strs[i].length) <= 2 * 104
 * strs[i] 只包含小写字母。
 * strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
 */

public class Question839_SimilarStringGroups {
	public static void main(String[] args) {
		String[] strs = new String[]{"jvhpg", "jhvpg", "hpvgj", "hvpgj", "vhgjp"};
		Solution839 solution839 = new Solution839();
		System.out.println(solution839.numSimilarGroups(strs));
	}
}

class Solution839 {
	public int numSimilarGroups(String[] strs) {
		int result = 0;
		int[] unionSet = new int[strs.length];

		for(int i = 0; i < strs.length; i++) {
			unionSet[i] = i;
		}

		for(int i = 0; i < strs.length - 1; i++) {
			for(int j = i + 1; j < strs.length; j++) {
				String s1 = strs[i];
				String s2 = strs[j];

				if(isSimilar(s1, s2)) {
					union(unionSet, i, j);
				}
			}
		}

		for(int i = 0; i < unionSet.length; i++) {
			int root = findRoot(unionSet, i);
			if(root == i) {
				result++;
			}
		}

		return result;
	}

	public boolean isSimilar(String s1, String s2) {
		int different = -1;
		boolean isOccur = false;
		for(int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);

			if(c1 != c2) {
				if(isOccur) {
				    return false;
				}

				if(different == -1) {
					different = i;
				} else {
					if(s1.charAt(different) == s2.charAt(i) && s1.charAt(i) == s2.charAt(different)) {
					    isOccur = true;
					} else {
					    return false;
					}
				}
			}
		}

		return true;
	}

	public int findRoot(int[] unionSet, int index) {
		if(unionSet[index] == index) {
			return index;
		}

		return unionSet[index] = findRoot(unionSet, unionSet[index]);
	}

	public void union(int[] unionSet, int index1, int index2) {
		int root1 = findRoot(unionSet, index1);
		int root2 = findRoot(unionSet, index2);

		if(root1 != root2) {
			unionSet[root2] = root1;
		}
	}
}
