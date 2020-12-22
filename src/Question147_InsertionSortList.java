/**
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * <p>
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */

public class Question147_InsertionSortList {
	public static void main(String[] args) {
		Solution147 solution147 = new Solution147();

		int[] nums = new int[]{3, 2, 4};
		ListNode head = new ListNode(nums[0]);
		ListNode p = head;
		for(int i = 1; i < nums.length; i++) {
			p.next = new ListNode(nums[i]);
			p = p.next;
		}

		solution147.display(head);

		ListNode result = solution147.insertionSortList(head);
		solution147.display(result);
	}
}

class Solution147 {
	public ListNode insertionSortList(ListNode head) {
		if(head == null) {
			return null;
		}

		ListNode index = head.next;
		ListNode p;
		ListNode pre;
		ListNode q;

		while(index != null) {
			p = head;
			pre = head;

			// 寻找插入位置
			while(p != null && p.val < index.val) {
				pre = p;
				p = p.next;
			}

			// 待插入节点
			q = index;
			index = index.next;

			// pre为最后一个数
			if(p == null) {
				pre.next = q;
				q.next = null;
				continue;
			}

			// 避免循环相指
			if(p.next == q) {
				p.next = null;
			}

			// 考虑p为首指针
			if(p == head) {
				head = q;
				q.next = p;
			}
			// 考虑p与q相等
			else if(p == q) {
				q.next = null;
			}
			// 其余正常情况
			else {
				pre.next = q;
				q.next = p;
			}

		}

		return head;
	}

	public void display(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}