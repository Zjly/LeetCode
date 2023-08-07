//  Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}
}

class ListNodeTool {
	/**
	 * 根据int[]的num数组创建ListNode链表
	 *
	 * @param nums nums数组
	 * @return 根据nums创建的链表
	 */
	public static ListNode createListNode(int[] nums) {
		if(nums == null) {
			return null;
		}

		ListNode head = new ListNode(nums[0]);
		ListNode pre = head;
		for(int i = 1; i < nums.length; i++) {
			ListNode p = new ListNode(nums[i]);
			pre.next = p;
			pre = p;
		}

		return head;
	}

	/**
	 * 输出链表
	 *
	 * @param head 待输出的链表
	 */
	public static void displayListNode(ListNode head) {
		ListNode p = head;
		while(p != null) {
			System.out.print(p.val);
			if(p.next != null) {
				System.out.print(" ");
				p = p.next;
			} else {
				System.out.println();
				break;
			}
		}
	}
}