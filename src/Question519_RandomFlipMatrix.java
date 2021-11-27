import java.util.Arrays;
import java.util.Random;

/**
 * 519. 随机翻转矩阵
 * 给你一个 m x n 的二元矩阵 matrix ，且所有值被初始化为 0 。请你设计一个算法，随机选取一个满足 matrix[i][j] == 0 的下标 (i, j) ，并将它的值变为 1 。所有满足 matrix[i][j] == 0 的下标 (i, j) 被选取的概率应当均等。
 * <p>
 * 尽量最少调用内置的随机函数，并且优化时间和空间复杂度。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution(int m, int n) 使用二元矩阵的大小 m 和 n 初始化该对象
 * int[] flip() 返回一个满足 matrix[i][j] == 0 的随机下标 [i, j] ，并将其对应格子中的值变为 1
 * void reset() 将矩阵中所有的值重置为 0
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Solution", "flip", "flip", "flip", "reset", "flip"]
 * [[3, 1], [], [], [], [], []]
 * 输出
 * [null, [1, 0], [2, 0], [0, 0], null, [2, 0]]
 * <p>
 * 解释
 * Solution solution = new Solution(3, 1);
 * solution.flip();  // 返回 [1, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
 * solution.flip();  // 返回 [2, 0]，因为 [1,0] 已经返回过了，此时返回 [2,0] 和 [0,0] 的概率应当相同
 * solution.flip();  // 返回 [0, 0]，根据前面已经返回过的下标，此时只能返回 [0,0]
 * solution.reset(); // 所有值都重置为 0 ，并可以再次选择下标返回
 * solution.flip();  // 返回 [2, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 104
 * 每次调用flip 时，矩阵中至少存在一个值为 0 的格子。
 * 最多调用 1000 次 flip 和 reset 方法。
 */

public class Question519_RandomFlipMatrix {
	public static void main(String[] args) {
		Solution519 solution519 = new Solution519(2, 3);
		System.out.println(Arrays.toString(solution519.flip()));
		System.out.println(Arrays.toString(solution519.flip()));
		System.out.println(Arrays.toString(solution519.flip()));
		System.out.println(Arrays.toString(solution519.flip()));
		System.out.println(Arrays.toString(solution519.flip()));
		System.out.println(Arrays.toString(solution519.flip()));
	}
}

class Solution519 {
	int m;
	int n;
	ListNode head;
	Random random;
	int remain;

	public Solution519(int m, int n) {
		this.m = m;
		this.n = n;
		head = new ListNode();
		random = new Random();
		remain = m * n;
	}

	public int[] flip() {
		int randomNumber = random.nextInt(remain);
		remain--;

		ListNode p = head;
		while(p.next != null && p.next.val <= randomNumber) {
			randomNumber++;
			p = p.next;
		}
		ListNode newNode = new ListNode(randomNumber);
		newNode.next = p.next;
		p.next = newNode;

		return new int[]{randomNumber / n, randomNumber % n};
	}

	public void reset() {
		head = new ListNode();
		remain = m * n;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {}

		ListNode(int val) {
			this.val = val;
		}
	}
}

/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
