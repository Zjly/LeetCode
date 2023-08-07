/**
 * 641. 设计循环双端队列
 * 设计实现双端队列。
 * <p>
 * 实现 MyCircularDeque 类:
 * <p>
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * 输出
 * [null, true, true, true, false, 2, true, true, true, 4]
 * <p>
 * 解释
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull  调用次数不大于 2000 次
 */

public class Question641_DesignCircularDeque {
	public static void main(String[] args) {

	}

	class MyCircularDeque {
		int maxSize;
		int size;
		Node front;
		Node last;

		public MyCircularDeque(int k) {
			maxSize = k;
			size = 0;
			Node node = new Node();
			front = node;
			last = node;
		}

		public boolean insertFront(int value) {
			if(size == maxSize) {
			    return false;
			}

			if(size == 0) {
			    front.val = value;
			} else {
				Node node = new Node(value);
				node.next = front;
				front.pre = node;
				front = node;
			}
			size++;
			return true;
		}

		public boolean insertLast(int value) {
			if(size == maxSize) {
				return false;
			}

			if(size == 0) {
				last.val = value;
			} else {
				Node node = new Node(value);
				last.next = node;
				node.pre = last;
				last = node;
			}
			size++;
			return true;
		}

		public boolean deleteFront() {
			if(size == 0) {
			    return false;
			}

			if(size != 1) {
				front = front.next;
				front.pre = null;
			}
			size--;

			return true;
		}

		public boolean deleteLast() {
			if(size == 0) {
				return false;
			}

			if(size != 1) {
				last = last.pre;
				last.next = null;
			}
			size--;

			return true;
		}

		public int getFront() {
			if(size == 0) {
			    return -1;
			}

			return front.val;
		}

		public int getRear() {
			if(size == 0) {
				return -1;
			}

			return last.val;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public boolean isFull() {
			return size == maxSize;
		}

		class Node {
			int val;
			Node pre;
			Node next;
			Node() {

			}

			Node(int val) {
				this.val = val;
			}
		}
	}

/*
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
