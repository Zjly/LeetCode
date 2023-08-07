import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 * <p>
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i 如果上述条件全不满足。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 * 示例 3：
 * <p>
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 */

public class Question412_FizzBuzz {
	public static void main(String[] args) {

	}
}

class Solution412 {
	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			if(i % 3 == 0 && i % 5 == 0) {
			    result.add("FizzBuzz");
			} else if(i % 3 == 0) {
			    result.add("Fizz");
			} else if(i % 5 == 0) {
			    result.add("Buzz");
			} else {
				result.add(String.valueOf(i));
			}
		}

		return result;
	}
}