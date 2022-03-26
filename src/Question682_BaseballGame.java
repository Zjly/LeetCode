import java.util.Stack;

/**
 * 682. 棒球比赛
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * <p>
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * <p>
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ops = ["5","2","C","D","+"]
 * 输出：30
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "2" - 记录加 2 ，记录现在是 [5, 2]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 * 示例 2：
 * <p>
 * 输入：ops = ["5","-2","4","C","D","9","+","+"]
 * 输出：27
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "-2" - 记录加 -2 ，记录现在是 [5, -2]
 * "4" - 记录加 4 ，记录现在是 [5, -2, 4]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
 * "D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
 * "9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
 * "+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
 * "+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
 * 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
 * 示例 3：
 * <p>
 * 输入：ops = ["1"]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= ops.length <= 1000
 * ops[i] 为 "C"、"D"、"+"，或者一个表示整数的字符串。整数范围是 [-3 * 104, 3 * 104]
 * 对于 "+" 操作，题目数据保证记录此操作时前面总是存在两个有效的分数
 * 对于 "C" 和 "D" 操作，题目数据保证记录此操作时前面总是存在一个有效的分数
 */

public class Question682_BaseballGame {
	public static void main(String[] args) {
		Solution682 solution682 = new Solution682();
		String[] ops = {"1","C","-62","-45","-68"};
		System.out.println(solution682.calPoints(ops));
	}
}

class Solution682 {
	public int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		int points = 0;
		int num1 = 0;
		int num2 = 0;
		int point;
		for(String s : ops) {
			switch(s) {
				case "C":
					num2 = num1;
					stack.pop();
					if(!stack.empty()) {
						int num = stack.pop();
						if(!stack.empty()) {
							num1 = stack.peek();
						} else {
							num1 = 0;
						}
						stack.push(num);
					} else {
					    num1 = 0;
					}
					break;
				case "D":
					point = num2 * 2;
					num1 = num2;
					num2 = point;
					stack.push(num2);
					break;
				case "+":
					point = num1 + num2;
					num1 = num2;
					num2 = point;
					stack.push(num2);
					break;
				default:
					num1 = num2;
					num2 = Integer.parseInt(s);
					stack.push(num2);
					break;
			}
		}

		while(!stack.empty()) {
		    points += stack.pop();
		}

		return points;
	}
}