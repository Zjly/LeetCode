import java.util.*;

/**
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * 注意：
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * <p>
 * 扩展练习：
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 */

public class Question692_TopKFrequentWords {
	public static void main(String[] args) {
		Solution692 solution692 = new Solution692();
		String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		int k = 4;
		System.out.println(solution692.topKFrequent(words, k));
	}
}

class Solution692 {
	public List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		Comparator<Word> comparator = (o1, o2) -> {
			if(o1.count == o2.count) {
			    for(int i = 0; i < Math.min(o1.word.length(), o2.word.length()); i++) {
				    if(o1.word.charAt(i) < o2.word.charAt(i)) {
				        return -1;
				    } else if(o1.word.charAt(i) > o2.word.charAt(i)) {
				        return 1;
				    }
			    }
			    if(o1.word.length() > o2.word.length()) {
			        return 1;
			    } else {
			        return -1;
			    }
			}
			return o2.count - o1.count;
		};
		PriorityQueue<Word> priorityQueue = new PriorityQueue<>(comparator);

		for(String word : words) {
			hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
		}

		for(HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {
			priorityQueue.offer(new Word(entry.getKey(), entry.getValue()));
		}

		ArrayList<String> arrayList = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			arrayList.add(priorityQueue.poll().word);
		}

		return arrayList;
	}

	class Word {
		String word;
		int count;

		public Word(String word, int count) {
			this.word = word;
			this.count = count;
		}
	}
}

