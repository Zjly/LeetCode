import java.util.List;

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */

public class Question92_ReverseLinkedListII {
	public static void main(String[] args) {
		Solution92 solution92 = new Solution92();

		ListNode listNode = new ListNode(5);
		ListNode head = new ListNode(3, listNode);

		ListNode result = solution92.reverseBetween(head, 1, 2);
	}
}

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution92 {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(left == right) {
			return head;
		}

		ListNode preHead = new ListNode();
		preHead.next = head;

		ListNode begin = head;
		ListNode preBegin = preHead;
		for(int i = 0; i < left - 1; i++) {
			preBegin = preBegin.next;
			begin = begin.next;
		}

		ListNode preP = begin;
		ListNode p = begin.next;
		ListNode pNext = p.next;
		for(int i = 0; i < right - left; i++) {
			p.next = preP;
			preP = p;
			p = pNext;
			if(p != null) {
				pNext = p.next;
			}
		}

		begin.next = p;
		preBegin.next = preP;

		return preHead.next;
	}
}