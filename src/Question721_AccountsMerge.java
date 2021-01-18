import java.util.*;

/**
 * 721. 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 * <p>
 * 示例 1：
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 * <p>
 * 提示：
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 */

public class Question721_AccountsMerge {
	public static void main(String[] args) {
		Solution721 solution721 = new Solution721();
		List<List<String>> a = new ArrayList<>();
		ArrayList<String> a1 = new ArrayList<>();
		a1.add("John");
		a1.add("johnsmith@mail.com");
		a1.add("john00@mail.com");
		ArrayList<String> a2 = new ArrayList<>();
		a2.add("John");
		a2.add("johnnybravo@mail.com");
		ArrayList<String> a3 = new ArrayList<>();
		a3.add("John");
		a3.add("johnsmith@mail.com");
		a3.add("john_newyork@mail.com");
		ArrayList<String> a4 = new ArrayList<>();
		a4.add("Mary");
		a4.add("mary@mail.com");
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
		System.out.println(solution721.accountsMerge(a));
	}
}

class Solution721 {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		HashMap<String, Integer> mailStringToMailIndex = new HashMap<>();
		HashMap<Integer, String> mailIndexToMailString = new HashMap<>();
		HashMap<Integer, String> mailIndexToName = new HashMap<>();
		int[] unionSet = new int[9 * accounts.size()];
		// 邮箱索引
		int mailIndex = 0;

		for(int i = 0; i < accounts.size(); i++) {
			for(int j = 1; j < accounts.get(i).size(); j++) {
				// 当前邮箱和父亲邮箱（该用户的第一个邮箱）
				String mail = accounts.get(i).get(j);
				String fatherMail = accounts.get(i).get(1);

				// 当前邮箱为新邮箱
				if(!mailStringToMailIndex.containsKey(mail)) {
					mailStringToMailIndex.put(mail, mailIndex);
					mailIndexToMailString.put(mailIndex, mail);
					mailIndexToName.put(mailIndex, accounts.get(i).get(0));
					// 父亲邮箱
					if(j == 1) {
						unionSet[mailIndex] = mailIndex;
					} else {
						unionSet[mailIndex] = mailStringToMailIndex.get(fatherMail);
					}
					mailIndex++;
				}
				// 当前邮箱为旧邮箱
				else {
					int indexThis = mailStringToMailIndex.get(mail);
					int indexFather = mailStringToMailIndex.get(fatherMail);
					union(unionSet, indexThis, indexFather);
				}
			}
		}

		// 合并并查集并进行排序
		List<Queue<String>> pResult = new ArrayList<>();
		HashMap<Integer, Integer> mailIndexToResultIndex = new HashMap<>();
		HashMap<Integer, String> resultIndexToName = new HashMap<>();
		// 结果优先队列索引
		int resultIndex = 0;
		for(int i = 0; i < mailIndex; i++) {
			int index = findRoot(unionSet, i);
			if(!mailIndexToResultIndex.containsKey(index)) {
			    mailIndexToResultIndex.put(index, resultIndex);
			    resultIndexToName.put(resultIndex, mailIndexToName.get(index));
			    resultIndex++;
			    Queue<String> thisResult = new PriorityQueue<>();
			    pResult.add(thisResult);
			    thisResult.offer(mailIndexToMailString.get(i));
			} else {
				Queue<String> thisResult = pResult.get(mailIndexToResultIndex.get(index));
				thisResult.offer(mailIndexToMailString.get(i));
			}
		}

		List<List<String>> result = new ArrayList<>();
		for(int i = 0; i < mailIndexToResultIndex.size(); i++) {
			List<String> thisResult = new LinkedList<>();
			Queue<String> queue = pResult.get(i);
			thisResult.add(resultIndexToName.get(i));
			while(queue.size() != 0) {
				thisResult.add(queue.poll());
			}
			result.add(thisResult);
		}

		return result;
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
