import java.util.ArrayList;
import java.util.List;

/**
 * 842. 将数组拆分成斐波那契序列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * <p>
 * 示例 1：
 * 输入："123456579"
 * 输出：[123,456,579]
 * <p>
 * 示例 2：
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * <p>
 * 示例 3：
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * <p>
 * 示例 4：
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * <p>
 * 示例 5：
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 * <p>
 * 提示：
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 */

public class Question842_SplitArrayIntoFibonacciSequence {
	public static void main(String[] args) {
		Solution842 solution842 = new Solution842();
		String S = "417420815174208193484163452262453871040871393665402264706273658371675923077949581449611550452755";
		System.out.println(solution842.splitIntoFibonacci(S));
	}
}

class Solution842 {
	public List<Integer> splitIntoFibonacci(String S) {
		ArrayList<Integer> result = new ArrayList<>();

		// 第一个数
		for(int firstLength = 1; firstLength <= S.length() / 2 && firstLength <= 10; firstLength++) {
			long fN = Long.parseLong(S.substring(0, firstLength));
			if(fN > Integer.MAX_VALUE) {
				continue;
			}
			int firstNumber = Integer.parseInt(S.substring(0, firstLength));
			if((firstNumber + "").length() != firstLength) {
				continue;
			}
			result.add(firstNumber);

			// 第二个数
			for(int secondLength = 1; secondLength <= (S.length() - firstLength) / 2 && secondLength <= 10; secondLength++) {
				String substring = S.substring(firstLength, firstLength + secondLength);
				long sN = Long.parseLong(substring);
				if(sN > Integer.MAX_VALUE) {
					continue;
				}

				int secondNumber = Integer.parseInt(substring);
				if((secondNumber + "").length() != secondLength) {
					continue;
				}
				result.add(secondNumber);

				// 第三个数
				for(int thirdLength = Math.max(firstLength, secondLength); thirdLength <= Math.max(firstLength, secondLength) + 1 && firstLength + secondLength + thirdLength <= S.length() && thirdLength <= 10; thirdLength++) {
					String substringT = S.substring(firstLength + secondLength, firstLength + secondLength + thirdLength);
					long tN = Long.parseLong(substringT);
					if(tN > Integer.MAX_VALUE) {
						continue;
					}

					int thirdNumber = Integer.parseInt(substringT);
					if((thirdNumber + "").length() != thirdLength) {
						continue;
					}
					int location = firstLength + secondLength + thirdLength;
					result.add(thirdNumber);

					int numberA = firstNumber;
					int numberB = secondNumber;
					int numberC = thirdNumber;

					boolean isComplete = false;

					// 前三个数构成斐波那契数列则判断后续
					while(isFibonacci(numberA, numberB, numberC)) {
						isComplete = true;

						if(location == S.length()) {
							break;
						}

						numberA = numberB;
						numberB = numberC;

						// 后续数长度为前两个数最长或者前两个数最长+1
						int numberCLength = Math.max((numberA + "").length(), (numberB + "").length());
						if(location + numberCLength > S.length()) {
							break;
						}
						if(numberCLength > 10) {
							break;
						}
						long cN = Long.parseLong(S.substring(location, location + numberCLength));
						if(cN > Integer.MAX_VALUE) {
							break;
						}
						int numberC1 = Integer.parseInt(S.substring(location, location + numberCLength));
						if((numberC1 + "").length() != numberCLength) {
							break;
						}
						int numberC2;
						if(location + numberCLength + 1 <= S.length() || numberCLength + 1 > 10) {
							cN = Long.parseLong(S.substring(location, location + numberCLength + 1));
							if(cN > Integer.MAX_VALUE) {
								numberC2 = -1;
							} else {
								numberC2 = Integer.parseInt(S.substring(location, location + numberCLength + 1));
							}
						} else {
							numberC2 = -1;
						}

						if(isFibonacci(numberA, numberB, numberC1)) {
							location += numberCLength;
							numberC = numberC1;
							result.add(numberC);
						} else if(isFibonacci(numberA, numberB, numberC2)) {
							location += numberCLength + 1;
							numberC = numberC2;
							result.add(numberC);
						} else {
							isComplete = false;
							break;
						}
					}

					// 寻找完毕
					if(location == S.length() && isComplete) {
						return result;
					}

					result.clear();
					result.add(firstNumber);
					result.add(secondNumber);
				}
				result.clear();
				result.add(firstNumber);
			}
			result.clear();
		}

		return result;
	}

	public boolean isFibonacci(int a, int b, int c) {
		return a + b == c;
	}
}
