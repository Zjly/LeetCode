import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 * 不要使用系统的 Math.random() 方法。
 * <p>
 * 示例 1:
 * 输入: 1
 * 输出: [7]
 * <p>
 * 示例 2:
 * 输入: 2
 * 输出: [8,4]
 * <p>
 * 示例 3:
 * 输入: 3
 * 输出: [8,1,10]
 * <p>
 * <p>
 * 提示:
 * rand7 已定义。
 * 传入参数: n 表示 rand10 的调用次数。
 * <p>
 * 进阶:
 * rand7()调用次数的 期望值 是多少 ?
 * 你能否尽量少调用 rand7() ?
 */

public class Question470_ImplementRand10UsingRand7 {
	public static void main(String[] args) {

	}
}

/*
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */

class Solution470 extends SolBase {
	public int rand10() {
		int get = 41;
		while(get > 40) {
			get = 7 * (rand7() - 1) + rand7();
		}

		return (get - 1) / 4 + 1;
	}
}

class SolBase {
	public int rand7() {
		Random random = new Random();
		return random.nextInt(7) + 1;
	}
}