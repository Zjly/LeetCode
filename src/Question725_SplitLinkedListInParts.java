/**
 * 725. 分隔链表
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * 返回一个由上述 k 部分组成的数组。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * 解释：
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 1000]
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 */

public class Question725_SplitLinkedListInParts {
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
class Solution725 {
	public ListNode[] splitListToParts(ListNode head, int k) {
		int length = 0;
		ListNode p = head;
		while(p != null) {
			length++;
			p = p.next;
		}

		int mean = length / k;
		int remain = length % k;

		ListNode[] result = new ListNode[k];
		p = head;
		result[0] = p;
		for(int i = 1; i < k; i++) {
			if(p != null) {
				for(int j = 0; j < mean - 1; j++) {
					p = p.next;
				}

				if(remain > 0) {
					if(mean != 0) {
						p = p.next;
					}
					ListNode q = p;
					p = p.next;
					q.next = null;
					remain--;
				} else {
					ListNode q = p;
					p = p.next;
					q.next = null;
				}
			}

			result[i] = p;
		}

		return result;
	}
}