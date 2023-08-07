import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 399. 除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 * <p>
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * <p>
 * 示例 1：
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * <p>
 * 示例 2：
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * <p>
 * 示例 3：
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * 提示：
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 */

public class Question399_EvaluateDivision {
	public static void main(String[] args) {
		Solution399 solution399 = new Solution399();
		List<List<String>> equations = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");
		List<String> list2 = new ArrayList<>();
		list2.add("c");
		list2.add("b");
		List<String> list3 = new ArrayList<>();
		list3.add("d");
		list3.add("b");
		List<String> list4 = new ArrayList<>();
		list4.add("w");
		list4.add("x");
		List<String> list5 = new ArrayList<>();
		list5.add("y");
		list5.add("x");
		List<String> list6 = new ArrayList<>();
		list6.add("z");
		list6.add("x");
		List<String> list7 = new ArrayList<>();
		list7.add("w");
		list7.add("d");
		equations.add(list1);
		equations.add(list2);
		equations.add(list3);
		equations.add(list4);
		equations.add(list5);
		equations.add(list6);
		equations.add(list7);

		double[] values = new double[]{2, 3, 4, 5, 6, 7, 8};

		List<List<String>> queries = new ArrayList<>();
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("z");
		queries.add(list);

		System.out.println(Arrays.toString(solution399.calcEquation(equations, values, queries)));
	}
}

class Solution399 {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		double[] result = new double[queries.size()];

		// [变量名，变量索引]
		HashMap<String, Integer> hashMap = new HashMap<>();
		// unionSet[][0] = 根节点索引，unionSet[][1] = 此节点到根节点的倍率
		double[][] unionSet = new double[40][2];

		initUnionSet(equations, values, hashMap, unionSet);

		for(int i = 0; i < queries.size(); i++) {
			if(!hashMap.containsKey(queries.get(i).get(0)) || !hashMap.containsKey(queries.get(i).get(1))) {
				result[i] = -1.0;
				continue;
			}
			int index1 = hashMap.get(queries.get(i).get(0));
			int index2 = hashMap.get(queries.get(i).get(1));
			double root1 = findRoot(unionSet, index1);
			double root2 = findRoot(unionSet, index2);

			if(root1 != root2) {
				result[i] = -1.0;
			} else {
				result[i] = unionSet[index2][1] / unionSet[index1][1];
			}
		}

		return result;
	}

	public void initUnionSet(List<List<String>> equations, double[] values, HashMap<String, Integer> hashMap, double[][] unionSet) {
		int nameCount = 0;
		int length = equations.size();

		for(int i = 0; i < 40; i++) {
			unionSet[i][0] = i;
			unionSet[i][1] = 1;
		}

		for(int i = 0; i < length; i++) {
			List<String> equation = equations.get(i);
			String equation1 = equation.get(0);
			String equation2 = equation.get(1);
			double value = values[i];

			// 存入键值对
			if(!hashMap.containsKey(equation1)) {
				hashMap.put(equation1, nameCount);
				nameCount++;
			}
			if(!hashMap.containsKey(equation2)) {
				hashMap.put(equation2, nameCount);
				nameCount++;
			}

			int index1 = hashMap.get(equation1);
			int index2 = hashMap.get(equation2);

			union(unionSet, index1, index2, value);
		}
	}

	public double findRoot(double[][] unionSet, double index) {
		int thisIndex = (int)index;
		if(unionSet[thisIndex][0] == thisIndex) {
			return thisIndex;
		}

		double rootIndex = findRoot(unionSet, unionSet[thisIndex][0]);

		if(rootIndex != unionSet[thisIndex][0]) {
			// 更改倍率
			unionSet[thisIndex][1] *= unionSet[(int)unionSet[thisIndex][0]][1];
			unionSet[thisIndex][0] = rootIndex;
		}

		return rootIndex;
	}

	public void union(double[][] unionSet, int index1, int index2, double value) {
		double root1 = findRoot(unionSet, index1);
		double root2 = findRoot(unionSet, index2);

		if(root1 != root2) {
			unionSet[(int)root2][0] = root1;
			unionSet[(int)root2][1] = unionSet[index1][1] * value / unionSet[index2][1];
		}
	}
}
