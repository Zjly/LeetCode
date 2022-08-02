/**
 * 622. 设计循环队列
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * circularQueue.enQueue(1);  // 返回 true
 * circularQueue.enQueue(2);  // 返回 true
 * circularQueue.enQueue(3);  // 返回 true
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * circularQueue.Rear();  // 返回 3
 * circularQueue.isFull();  // 返回 true
 * circularQueue.deQueue();  // 返回 true
 * circularQueue.enQueue(4);  // 返回 true
 * circularQueue.Rear();  // 返回 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有的值都在 0 至 1000 的范围内；
 * 操作数将在 1 至 1000 的范围内；
 * 请不要使用内置的队列库。
 */

public class Question622_DesignCircularQueue {
	public static void main(String[] args) {

	}
}

class MyCircularQueue {
	class Node {
		int val;
		Node next;

		Node() {

		}

		Node(int val) {
			this.val = val;
		}
	}

	int size = 0;
	Node head;
	Node tail;
	int maxSize;

	public MyCircularQueue(int k) {
		head = new Node();
		tail = head;
		maxSize = k;
	}

	public boolean enQueue(int value) {
		if(size == 0) {
		    head.val = value;
			size++;
			return true;
		} else if(size == maxSize) {
			return false;
		} else {
		    Node p = new Node(value);
			tail.next = p;
			tail = p;
			size++;
			return true;
		}
	}

	public boolean deQueue() {
		if(size == 0) {
		    return false;
		} else if(size == 1) {
		    size = 0;
			return true;
		} else {
			head = head.next;
			size--;
			return true;
		}
	}

	public int Front() {
		if(size == 0) {
		    return -1;
		} else {
		    return head.val;
		}
	}

	public int Rear() {
		if(size == 0) {
			return -1;
		} else {
			return tail.val;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == maxSize;
	}
}

/*
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */