import java.util.HashMap;
import java.util.Stack;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 * <p>
 * <p>
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,-3,3,1]
 * 输出：[3,1]
 * 提示：答案 [1,2,1] 也是正确的。
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,-3,4]
 * 输出：[1,2,4]
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,-3,-2]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给你的链表中可能有 1 到 1000 个节点。
 * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
 */

public class Question1171_从链表中删去总和值为零的连续节点 {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 1 2 -1 -1 3 -> 1 3 2 1 4

class Solution1171 {
	public ListNode removeZeroSumSublists(ListNode head) {
		HashMap<Integer, ListNode> hashMap = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode p = pre;

		int preSum = 0;
		while(p != null) {
		    preSum += p.val;
			if(hashMap.containsKey(preSum)) {
			    ListNode left = hashMap.get(preSum);
				left.next = p.next;
				while(stack.peek() != preSum) {
				    Integer i = stack.pop();
					hashMap.remove(i);
				}
			} else {
			    hashMap.put(preSum, p);
				stack.push(preSum);
			}

			p = p.next;
		}

		return pre.next;
	}
}