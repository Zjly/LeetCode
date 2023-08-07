import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 433. 最小基因变化
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * <p>
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
 * <p>
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成此基因变化，返回 -1 。
 * <p>
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * start.length == 8
 * end.length == 8
 * 0 <= bank.length <= 10
 * bank[i].length == 8
 * start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
 */

public class Question433_MinimumGeneticMutation {
	public static void main(String[] args) {
		Solution433 solution433 = new Solution433();
		String start = "AACCGGTT";
		String end = "AAACGGTA";
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		System.out.println(solution433.minMutation(start, end, bank));
	}
}

class Solution433 {
	public int minMutation(String start, String end, String[] bank) {
		boolean[] got = new boolean[bank.length];
		ArrayList<String> newBank = new ArrayList<>(Arrays.asList(bank));

		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		int count = 0;
		while(!queue.isEmpty()) {
			count++;
			int queueSize = queue.size();
			for(int i = 0; i < queueSize; i++) {
				String s1 = queue.poll();
				ArrayList<String> deleteList = new ArrayList<>();
				for(int j = 0; j < newBank.size(); j++) {
					String s2 = newBank.get(j);
					if(mutation(s1, s2)) {
						if(s2.equals(end)) {
							return count;
						}
						queue.offer(s2);
						deleteList.add(s2);
					}
				}

				for(int j = deleteList.size() - 1; j >= 0; j--) {
					newBank.remove(deleteList.get(j));
				}
			}
		}

		return -1;
	}

	public boolean mutation(String s1, String s2) {
		boolean change = false;
		for(int i = 0; i < s1.length(); i++) {
			boolean notEqual = s1.charAt(i) != s2.charAt(i);
			if(notEqual && !change) {
				change = true;
			} else if(notEqual) {
				return false;
			}
		}

		return true;
	}
}