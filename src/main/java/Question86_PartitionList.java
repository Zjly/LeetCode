/**
 * 86. 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例：
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 */

public class Question86_PartitionList {
	public static void main(String[] args) {
		Solution86 solution86 = new Solution86();
		ListNode listNode = new ListNode(1);
		System.out.println(solution86.partition(listNode, 2));
	}
}

class Solution86 {
	public ListNode partition(ListNode head, int x) {
		ListNode newHead;
		ListNode smallHead = new ListNode();
		ListNode largeHead = new ListNode();
		ListNode smallHeadIndex = smallHead;
		ListNode largeHeadIndex = largeHead;
		ListNode p = head;

		while(p != null) {
			if(p.val >= x) {
				largeHeadIndex.next = p;
				largeHeadIndex = largeHeadIndex.next;
			} else {
				smallHeadIndex.next = p;
				smallHeadIndex = smallHeadIndex.next;
			}
			p = p.next;
		}

		largeHeadIndex.next = null;
		smallHeadIndex.next = largeHead.next;
		newHead = smallHead.next;

		return newHead;
	}
}
