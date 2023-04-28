import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 1172. 餐盘栈
 * 我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 * <p>
 * 实现一个叫「餐盘」的类 DinnerPlates：
 * <p>
 * DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
 * void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
 * int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
 * int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * 输出：
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 * <p>
 * 解释：
 * DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
 * D.push(1);
 * D.push(2);
 * D.push(3);
 * D.push(4);
 * D.push(5);         // 栈的现状为：    2  4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 2。栈的现状为：      4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.push(20);        // 栈的现状为：  20  4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.push(21);        // 栈的现状为：  20  4 21
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(2);   // 返回 21。栈的现状为：       4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.pop()            // 返回 5。栈的现状为：        4
 * 1  3
 * ﹈ ﹈
 * D.pop()            // 返回 4。栈的现状为：    1  3
 * ﹈ ﹈
 * D.pop()            // 返回 3。栈的现状为：    1
 * ﹈
 * D.pop()            // 返回 1。现在没有栈。
 * D.pop()            // 返回 -1。仍然没有栈。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * 最多会对 push，pop，和 popAtStack 进行 200000 次调用。
 */

public class Question1172_餐盘栈 {
	public static void main(String[] args) {
		DinnerPlates dinnerPlates = new DinnerPlates(1);
		dinnerPlates.push(1);
		dinnerPlates.push(2);
		System.out.println(dinnerPlates.popAtStack(1));
		System.out.println(dinnerPlates.pop());
		dinnerPlates.push(1);
		dinnerPlates.push(2);
		System.out.println(dinnerPlates.pop());
		System.out.println(dinnerPlates.pop());
	}
}

class DinnerPlates {
	private final ArrayList<Stack<Integer>> stackArrayList = new ArrayList<>();
	private final PriorityQueue<Integer> notFullIndexPriorityQueue = new PriorityQueue<>();
	private final PriorityQueue<Integer> notNullIndexPriorityQueue = new PriorityQueue<>((a, b) -> b - a);
	private final int capacity;

	public DinnerPlates(int capacity) {
		this.capacity = capacity;
	}

	public void push(int val) {
		// push时，有未满Stack，则加入
		if(!notFullIndexPriorityQueue.isEmpty()) {
			int index = notFullIndexPriorityQueue.peek();
			Stack<Integer> stack = stackArrayList.get(index);
			stack.push(val);

			if(stack.size() == capacity) {
				notFullIndexPriorityQueue.poll();
			}

			if(stack.size() == 1) {
			    notNullIndexPriorityQueue.offer(index);
			}
		} else {
			int index = stackArrayList.size();
			Stack<Integer> stack = new Stack<>();
			stack.push(val);

			if(stack.size() != capacity) {
				notFullIndexPriorityQueue.offer(index);
			}
			notNullIndexPriorityQueue.offer(index);

			stackArrayList.add(stack);
		}
	}

	public int pop() {
		while(!notNullIndexPriorityQueue.isEmpty() && stackArrayList.get(notNullIndexPriorityQueue.peek()).isEmpty()) {
			notNullIndexPriorityQueue.poll();
		}

		if(!notNullIndexPriorityQueue.isEmpty()) {
		    int index = notNullIndexPriorityQueue.peek();
			Stack<Integer> stack = stackArrayList.get(index);
			int result = stack.pop();

			if(stack.size() == 0) {
			    notNullIndexPriorityQueue.poll();
			}

			if(stack.size() == capacity - 1) {
				notFullIndexPriorityQueue.offer(index);
			}

			return result;
		} else {
		    return -1;
		}
	}

	public int popAtStack(int index) {
		if(index >= stackArrayList.size()) {
		    return -1;
		}

		Stack<Integer> stack = stackArrayList.get(index);
		if(!stack.isEmpty()) {
			int result = stack.pop();

			if(stack.size() == capacity - 1) {
				notFullIndexPriorityQueue.offer(index);
			}

			return result;
		} else {
		    return -1;
		}
	}
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */