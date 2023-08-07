import java.util.ArrayList;

/**
 * 809. 情感丰富的文字
 * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 * <p>
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 * <p>
 * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = s。
 * <p>
 * 输入一组查询单词，输出其中可扩张的单词数量。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * s = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * 输出：1
 * 解释：
 * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, words.length <= 100
 * 1 <= words[i].length <= 100
 * s 和所有在 words 中的单词都只由小写字母组成。
 */

public class Question809_ExpressiveWords {
	public static void main(String[] args) {
		Solution809 solution809 = new Solution809();
		String s = "heeellooo";
		String[] words = {"hello", "hi", "helo"};
		System.out.println(solution809.expressiveWords(s, words));
	}
}

class Solution809 {
	public int expressiveWords(String s, String[] words) {
		ArrayList<W> arrayList = analyze(s);
		int count = 0;

		for(String word : words) {
			ArrayList<W> p = analyze(word);
			if(arrayList.size() == p.size()) {
				boolean ok = true;

				for(int i = 0; i < arrayList.size(); i++) {
					W w1 = arrayList.get(i);
					W w2 = p.get(i);
					if(w1.c != w2.c || w1.length < w2.length || (w1.length != w2.length && w1.length <= 2)) {
						ok = false;
						break;
					}
				}

				if(ok) {
				    count++;
				}
			}
		}

		return count;
	}

	class W {
		char c;
		int length;

		public W(char c, int length) {
			this.c = c;
			this.length = length;
		}
	}

	public ArrayList<W> analyze(String s) {
		ArrayList<W> arrayList = new ArrayList<>();
		char c = s.charAt(0);
		int length = 1;
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == c) {
				length++;
			} else {
				arrayList.add(new W(c, length));
				c = s.charAt(i);
				length = 1;
			}
		}
		arrayList.add(new W(c, length));
		return arrayList;
	}
}