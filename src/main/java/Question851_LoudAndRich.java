import java.util.ArrayList;
import java.util.Arrays;

/**
 * 851. 喧闹和富有
 * 有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为 x 的人简称为 "person x "。
 * <p>
 * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组 quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
 * <p>
 * 现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * 输出：[5,5,2,5,4,5,6,7]
 * 解释：
 * answer[0] = 5，
 * person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
 * 唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
 * 但是目前还不清楚他是否比 person 0 更有钱。
 * answer[7] = 7，
 * 在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
 * 最安静（有较低安静值 quiet[x]）的人是 person 7。
 * 其他的答案也可以用类似的推理来解释。
 * 示例 2：
 * <p>
 * 输入：richer = [], quiet = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * n == quiet.length
 * 1 <= n <= 500
 * 0 <= quiet[i] < n
 * quiet 的所有值 互不相同
 * 0 <= richer.length <= n * (n - 1) / 2
 * 0 <= ai, bi < n
 * ai != bi
 * richer 中的所有数对 互不相同
 * 对 richer 的观察在逻辑上是一致的
 */

public class Question851_LoudAndRich {
	public static void main(String[] args) {
		Solution851 solution851 = new Solution851();
		int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
		int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
		System.out.println(Arrays.toString(solution851.loudAndRich(richer, quiet)));
	}
}

class Solution851 {
	Person root = new Person(-1);

	public int[] loudAndRich(int[][] richer, int[] quiet) {
		// 初始化
		for(int i = 0; i < quiet.length; i++) {
			root.children.add(new Person(i, quiet[i]));
		}

		// 构造关系
		for(int[] rich : richer) {
			root.children.get(rich[1]).children.add(root.children.get(rich[0]));
		}

		for(int i = 0; i < quiet.length; i++) {
			calculateQuiet(root.children.get(i));
		}

		int[] result = new int[quiet.length];
		for(int i = 0; i < quiet.length; i++) {
			result[i] = root.children.get(i).minQuietIndex;
		}

		return result;
	}

	public void calculateQuiet(Person person) {
		if(person.minQuietIndex != -1) {
			return;
		}

		int minQuietIndex = person.index;
		for(int i = 0; i < person.children.size(); i++) {
			Person child = person.children.get(i);
			calculateQuiet(child);
			if(root.children.get(child.minQuietIndex).quiet < root.children.get(minQuietIndex).quiet) {
			    minQuietIndex = child.minQuietIndex;
			}
		}
		person.minQuietIndex = minQuietIndex;
	}

	static class Person {
		int index;
		int quiet;
		int minQuietIndex; // 子节点中最quiet的节点
		ArrayList<Person> children;

		public Person(int index) {
			this.index = index;
			this.minQuietIndex = -1;
			this.children = new ArrayList<>();
		}

		public Person(int index, int quiet) {
			this.index = index;
			this.quiet = quiet;
			this.minQuietIndex = -1;
			this.children = new ArrayList<>();
		}
	}
}