import java.util.HashMap;
import java.util.Stack;

/**
 * 895. 最大频率栈
 * 设计一个类似堆栈的数据结构，将元素推入堆栈，并从堆栈中弹出出现频率最高的元素。
 * <p>
 * 实现 FreqStack 类:
 * <p>
 * FreqStack() 构造一个空的堆栈。
 * void push(int val) 将一个整数 val 压入栈顶。
 * int pop() 删除并返回堆栈中出现频率最高的元素。
 * 如果出现频率最高的元素不只一个，则移除并返回最接近栈顶的元素。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * 输出：[null,null,null,null,null,null,null,5,7,5,4]
 * 解释：
 * FreqStack = new FreqStack();
 * freqStack.push (5);//堆栈为 [5]
 * freqStack.push (7);//堆栈是 [5,7]
 * freqStack.push (5);//堆栈是 [5,7,5]
 * freqStack.push (7);//堆栈是 [5,7,5,7]
 * freqStack.push (4);//堆栈是 [5,7,5,7,4]
 * freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
 * freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
 * freqStack.pop ();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
 * freqStack.pop ();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
 * freqStack.pop ();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= val <= 109
 * push 和 pop 的操作数不大于 2 * 104。
 * 输入保证在调用 pop 之前堆栈中至少有一个元素。
 */

public class Question895_MaximumFrequencyStack {
	public static void main(String[] args) {
		FreqStack freqStack = new FreqStack();
		freqStack.push(4);
		freqStack.push(0);
		freqStack.push(9);
		freqStack.push(3);
		freqStack.push(4);
		freqStack.push(2);
		freqStack.pop();
		freqStack.push(6);
		freqStack.pop();
		freqStack.push(1);
		freqStack.pop();
		freqStack.push(1);
		freqStack.pop();
		freqStack.push(4);
		freqStack.pop();
		freqStack.pop();
		freqStack.pop();
		freqStack.pop();
		freqStack.pop();
		freqStack.pop();
	}
}

class FreqStack {
	HashMap<Integer, Stack<Integer>> stackHashMap;
	HashMap<Integer, Integer> numCountHashMap;
	int maxCount;

	public FreqStack() {
		stackHashMap = new HashMap<>();
		numCountHashMap = new HashMap<>();
		maxCount = 0;
	}

	public void push(int val) {
		int numCount = numCountHashMap.getOrDefault(val, 0) + 1;
		maxCount = Math.max(maxCount, numCount);
		Stack<Integer> stack = stackHashMap.getOrDefault(numCount, new Stack<>());
		stack.push(val);
		stackHashMap.put(numCount, stack);
		numCountHashMap.put(val, numCount);
	}

	public int pop() {
		Stack<Integer> stack = stackHashMap.get(maxCount);
		int num = stack.pop();
		int numCount = maxCount - 1;
		numCountHashMap.put(num, numCount);
		if(stackHashMap.get(maxCount).isEmpty()) {
		    maxCount--;
		}
		return num;
	}
}

/*
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
