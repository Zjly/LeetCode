import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 68. 文本左右对齐
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * <p>
 * 示例:
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * <p>
 * 示例 2:
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 * 因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * <p>
 * 示例 3:
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */

public class Question68_TextJustification {
	public static void main(String[] args) {
		Solution68 solution68 = new Solution68();
		String[] words = {"What","must","be","acknowledgment","shall","be"};
		int maxWidth = 16;
		System.out.println(solution68.fullJustify(words, maxWidth));
	}
}

class Solution68 {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> resultList = new ArrayList<>();

		int index = 0;
		while(index < words.length) {
			int beginIndex = index;
			int wordsSpaceLength = 0;
			int wordsLength = 0;
			while(index < words.length && wordsSpaceLength + words[index].length() <= maxWidth) {
				wordsSpaceLength += words[index].length() + 1;
				wordsLength += words[index].length();
				index++;
			}

			int wordsCount = index - beginIndex;
			int spaceCount = maxWidth - wordsLength;

			if(wordsCount == 1) {
				StringBuilder stringBuilder = new StringBuilder(words[beginIndex]);
				for(int i = 0; i < spaceCount; i++) {
					stringBuilder.append(' ');
				}
				resultList.add(stringBuilder.toString());
			} else if(index == words.length) {
				StringBuilder stringBuilder = new StringBuilder();
				for(int i = beginIndex; i < index; i++) {
					stringBuilder.append(words[i]);
					if(i != index - 1) {
						stringBuilder.append(' ');
					}
				}

				int needSpaceCount = maxWidth - stringBuilder.length();
				for(int i = 0; i < needSpaceCount; i++) {
					stringBuilder.append(' ');
				}
				resultList.add(stringBuilder.toString());
			} else {
				int interval = wordsCount - 1;
				int meanSpace = spaceCount / interval;
				int specialWordCount = spaceCount % interval;

				StringBuilder stringBuilder = new StringBuilder();
				for(int i = beginIndex; i < index; i++) {
					stringBuilder.append(words[i]);
					if(i != index - 1) {
						for(int j = 0; j < meanSpace; j++) {
							stringBuilder.append(' ');
						}
						if(specialWordCount > 0) {
							specialWordCount--;
							stringBuilder.append(' ');
						}
					}
				}
				resultList.add(stringBuilder.toString());
			}
		}

		return resultList;
	}
}