import java.util.ArrayList;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * <p>
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */

public class Question61_RotateList {
	public static void main(String[] args) {

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

class Solution61 {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) {
		    return null;
		}

		int length = 0;
		ListNode preHead = new ListNode();
		preHead.next = head;
		ListNode p = head;
		ListNode tail;
		while(true) {
			length++;
			if(p.next == null) {
			    tail = p;
			    break;
			}
			p = p.next;
		}

		// 去除k的多次移动
		k = k % length;

		if(k == 0) {
		    return preHead.next;
		}

		// 保存要移动位置
		int move = length - k;
		p = preHead;
		for(int i = 0; i < move; i++) {
			p = p.next;
		}

		ListNode newHead = p.next;
		p.next = null;
		tail.next = preHead.next;

		return newHead;
	}
}
