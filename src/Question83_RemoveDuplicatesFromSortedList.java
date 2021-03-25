/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 */

public class Question83_RemoveDuplicatesFromSortedList {
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
class Solution83 {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return null;
		}

		ListNode nHead = new ListNode();
		nHead.next = head;

		ListNode pre = nHead;
		ListNode p = pre.next;
		while(p != null) {
			boolean isRepeat = false;
			int value = p.val;
			while(p.next != null && p.next.val == value) {
				p = p.next;
				isRepeat = true;
			}

			if(isRepeat) {
				pre.next = p;
			} else {
				pre = pre.next;
			}
			p = pre.next;
		}

		return nHead.next;
	}
}
