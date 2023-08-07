import java.util.ArrayList;
import java.util.List;

/**
 * 1023. 驼峰式匹配
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * <p>
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * 示例 2：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * 示例 3：
 * <p>
 * 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输入：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 100
 * 1 <= queries[i].length <= 100
 * 1 <= pattern.length <= 100
 * 所有字符串都仅由大写和小写英文字母组成。
 */

public class Question1023_CamelcaseMatching {
	public static void main(String[] args) {

	}
}

class Solution1023 {
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> result = new ArrayList<>();
		for(String query : queries) {
			result.add(match(query, pattern));
		}
		return result;
	}

	public boolean match(String query, String pattern) {
		int indexQuery = 0;
		int indexPattern = 0;

		while(indexQuery < query.length() && indexPattern < pattern.length()) {
			char q = query.charAt(indexQuery);
			char p = pattern.charAt(indexPattern);

			if(q == p) {
				indexQuery++;
				indexPattern++;
			} else if(q >= 'a' && q <= 'z') {
				indexQuery++;
			} else {
				break;
			}
		}

		if(indexPattern != pattern.length()) {
		    return false;
		}

		while(indexQuery < query.length()) {
			char q = query.charAt(indexQuery);
			if(q < 'a' || q > 'z') {
				return false;
			}
			indexQuery++;
		}

		return true;
	}
}

class Solution1023_2 {
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> result = new ArrayList<>();
		for(String query : queries) {
			result.add(match(query, pattern));
		}
		return result;
	}

	public boolean match(String query, String pattern) {
		int index = 0;
		for(int i = 0; i < query.length(); i++) {
			char c = query.charAt(i);
			if(pattern.length() == index) {
				if(c >= 'A' && c <= 'Z') {
					return false;
				} else {
				    continue;
				}
			}

			if(c == pattern.charAt(index)) {
				index++;
			} else if(c >= 'A' && c <= 'Z') {
				return false;
			}
		}

		return index == pattern.length();
	}
}