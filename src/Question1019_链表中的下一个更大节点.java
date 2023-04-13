import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1019. 链表中的下一个更大节点
 * 给定一个长度为 n 的链表 head
 * <p>
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * <p>
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数为 n
 * 1 <= n <= 104
 * 1 <= Node.val <= 109
 */

public class Question1019_链表中的下一个更大节点 {
	public static void main(String[] args) {

	}
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
class Solution1019 {
	public int[] nextLargerNodes(ListNode head) {
		class Node {
			int index;
			ListNode listNode;

			public Node(int index, ListNode listNode) {
				this.index = index;
				this.listNode = listNode;
			}
		}

		Deque<Node> deque = new ArrayDeque<>();
		ArrayList<Integer> arrayList = new ArrayList<>();

		ListNode current = head;
		int index = 0;
		while(current != null) {
			while(!deque.isEmpty() && deque.peek().listNode.val < current.val) {
			    Node n = deque.pop();
				arrayList.set(n.index, current.val);
			}

			deque.push(new Node(index, current));
			index++;
			current = current.next;
			arrayList.add(0);
		}

		int[] result = new int[arrayList.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = arrayList.get(i);
		}
		return result;
	}
}