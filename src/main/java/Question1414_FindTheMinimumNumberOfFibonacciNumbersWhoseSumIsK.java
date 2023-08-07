/*
1414. 和为 K 的最少斐波那契数字数目
给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。

斐波那契数字定义为：

F1 = 1
F2 = 1
Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
数据保证对于给定的 k ，一定能找到可行解。



示例 1：

输入：k = 7
输出：2
解释：斐波那契数字为：1，1，2，3，5，8，13，……
对于 k = 7 ，我们可以得到 2 + 5 = 7 。
示例 2：

输入：k = 10
输出：2
解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
示例 3：

输入：k = 19
输出：3
解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。


提示：

1 <= k <= 10^9
 */

import java.util.ArrayList;

public class Question1414_FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
	public static void main(String[] args) {
		Solution1414 solution1414 = new Solution1414();
		System.out.println(solution1414.findMinFibonacciNumbers(100));
	}
}

class Solution1414 {
	public int findMinFibonacciNumbers(int k) {
		ArrayList<Integer> arrayList = new ArrayList<>();

		arrayList.add(1);
		arrayList.add(1);

		while(true) {
			int num1 = arrayList.get(arrayList.size() - 2);
			int num2 = arrayList.get(arrayList.size() - 1);
			int num = num1 + num2;

			if(num > k) {
			    break;
			}

			arrayList.add(num);
		}

		int count = 0;
		int index = arrayList.size() - 1;

		while(k != 0) {
		    while(arrayList.get(index) > k) {
		        index--;
		    }

			k -= arrayList.get(index);
			count++;
		}

		return count;
	}
}