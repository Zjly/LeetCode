import java.util.*;

/**
 * 726. 原子的数量
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 * <p>
 * 示例 1:
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 * <p>
 * 示例 2:
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * <p>
 * 示例 3:
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 * <p>
 * 注意:
 * 所有原子的第一个字母为大写，剩余字母都是小写。
 * formula的长度在[1, 1000]之间。
 * formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
 */

public class Question726_NumberOfAtoms {
	public static void main(String[] args) {
		Solution726 solution726 = new Solution726();
		String formula = "K4(ON(SO3)2)2";
		System.out.println(solution726.countOfAtoms(formula));
	}
}

class Solution726 {
	public String countOfAtoms(String formula) {
		Stack<Atom> stack = new Stack<>();
		int index = 0;
		while(index < formula.length()) {
			char c = formula.charAt(index);

			if(c >= 'A' && c <= 'Z') {
				// 得到原子的name和count
				String name;
				int count;

				// 处理name部分
				StringBuilder nameStringBuilder = new StringBuilder();
				nameStringBuilder.append(c);
				while(index + 1 < formula.length() && formula.charAt(index + 1) >= 'a' && formula.charAt(index + 1) <= 'z') {
					index++;
					nameStringBuilder.append(formula.charAt(index));
				}
				name = nameStringBuilder.toString();

				// 处理count部分
				StringBuilder countStringBuilder = new StringBuilder();
				while(index + 1 < formula.length() && formula.charAt(index + 1) >= '0' && formula.charAt(index + 1) <= '9') {
					index++;
					countStringBuilder.append(formula.charAt(index));
				}
				count = countStringBuilder.length() == 0 ? 1 : Integer.parseInt(countStringBuilder.toString());

				stack.push(new Atom(name, count));
			} else if(c == '(') {
				stack.push(new Atom("(", -1));
			} else if(c == ')') {
				// 得到括号后的count
				int count;
				StringBuilder countStringBuilder = new StringBuilder();
				while(index + 1 < formula.length() && formula.charAt(index + 1) >= '0' && formula.charAt(index + 1) <= '9') {
					index++;
					countStringBuilder.append(formula.charAt(index));
				}
				count = countStringBuilder.length() == 0 ? 1 : Integer.parseInt(countStringBuilder.toString());

				// 基于count计算括号内的原子的个数
				Stack<Atom> pStack = new Stack<>();
				while(!stack.empty()) {
					Atom atom = stack.pop();
					if(atom.name.equals("(")) {
						break;
					}
					atom.count *= count;
					pStack.push(atom);
				}

				while(!pStack.empty()) {
					stack.push(pStack.pop());
				}
			}

			index++;
		}

		// 计算每个原子的count
		HashMap<String, Integer> atomCountHashMap = new HashMap<>();
		while(!stack.empty()) {
			Atom atom = stack.pop();
			atomCountHashMap.put(atom.name, atomCountHashMap.getOrDefault(atom.name, 0) + atom.count);
		}

		// 排序
		ArrayList<Atom> atomArrayList = new ArrayList<>();
		for(HashMap.Entry<String, Integer> entry : atomCountHashMap.entrySet()) {
			atomArrayList.add(new Atom(entry.getKey(), entry.getValue()));
		}
		atomArrayList.sort(Comparator.comparing(o -> o.name));

		// 得到结果
		StringBuilder result = new StringBuilder();
		for(Atom atom : atomArrayList) {
			if(atom.count != 1) {
			    result.append(atom.name).append(atom.count);
			} else {
			    result.append(atom.name);
			}
		}
		return result.toString();
	}

	static class Atom {
		String name;
		int count;

		public Atom(String name, int count) {
			this.name = name;
			this.count = count;
		}
	}
}