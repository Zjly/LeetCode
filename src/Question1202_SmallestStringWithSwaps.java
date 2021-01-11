import java.util.*;

/**
 * 1202. 交换字符串中的元素
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * <p>
 * 示例 1:
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * <p>
 * 示例 2：
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * <p>
 * 示例 3：
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 */

public class Question1202_SmallestStringWithSwaps {
	public static void main(String[] args) {
		Solution1202 solution1202 = new Solution1202();
		String s = "dcab";
		List<List<Integer>> pairs = new ArrayList<>();
		ArrayList<Integer> arrayList1 = new ArrayList<>();
		arrayList1.add(0);
		arrayList1.add(3);
		ArrayList<Integer> arrayList2 = new ArrayList<>();
		arrayList2.add(1);
		arrayList2.add(2);
		pairs.add(arrayList1);
		pairs.add(arrayList2);

		System.out.println(solution1202.smallestStringWithSwaps(s, pairs));
	}
}

class Solution1202 {
	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		int sLength = s.length();
		int[] unionSet = new int[sLength];
		boolean[] isInPairs = new boolean[sLength];
		createUnionSet(unionSet, pairs, isInPairs);

		Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		ArrayList<PriorityQueue<Character>> arrayList = new ArrayList<>();

		for(int i = 0; i < sLength; i++) {
			int root = findRoot(unionSet, i);
			if(!isInPairs[root]) {
			    continue;
			}

			// 加入哈希表
			if(!hashtable.containsKey(root)) {
				// 加入键值对
				hashtable.put(root, arrayList.size());

			    PriorityQueue<Character> priorityQueue = new PriorityQueue<>();
			    arrayList.add(priorityQueue);
			    priorityQueue.add(s.charAt(i));
			} else {
				PriorityQueue<Character> priorityQueue = arrayList.get(hashtable.get(root));
				priorityQueue.add(s.charAt(i));
			}
		}

		char[] result = new char[sLength];
		for(int i = 0; i < sLength; i++) {
			int root = findRoot(unionSet, i);
			if(!isInPairs[root]) {
				result[i] = s.charAt(i);
			} else {
				int key = hashtable.get(root);
				result[i] = arrayList.get(key).poll();
			}
		}

		return String.valueOf(result);
	}

	public void createUnionSet(int[] unionSet, List<List<Integer>> pairs, boolean[] isInPairs) {
		for(int i = 0; i < unionSet.length; i++) {
			unionSet[i] = i;
		}

		for(List<Integer> list : pairs) {
			int a = list.get(0);
			int b = list.get(1);
			isInPairs[a] = true;
			isInPairs[b] = true;

			union(unionSet, a, b);
		}
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
