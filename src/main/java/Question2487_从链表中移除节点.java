import java.util.Stack;

/**
 * 2487. 从链表中移除节点
 * 提示
 * 中等
 * 61
 * 相关企业
 * 给你一个链表的头节点 head 。
 *
 * 移除每个右侧有一个更大数值的节点。
 *
 * 返回修改后链表的头节点 head 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [5,2,13,3,8]
 * 输出：[13,8]
 * 解释：需要移除的节点是 5 ，2 和 3 。
 * - 节点 13 在节点 5 右侧。
 * - 节点 13 在节点 2 右侧。
 * - 节点 8 在节点 3 右侧。
 * 示例 2：
 *
 * 输入：head = [1,1,1,1]
 * 输出：[1,1,1,1]
 * 解释：每个节点的值都是 1 ，所以没有需要移除的节点。
 *
 *
 * 提示：
 *
 * 给定列表中的节点数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 */

public class Question2487_从链表中移除节点 {
}

/**
 * @author Zhang Lei
 * @date 2024/1/3 10:12
 */
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
class Solution2487 {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode h = new ListNode(100001);
        h.next = head;
        stack.push(h);
        
        ListNode p = head;
        while (p != null) {
            while (!stack.empty() && p.val > stack.peek().val) {
                stack.pop();
            }

            stack.peek().next = p;
            stack.push(p);
            p = p.next;
        }

        return h.next;
    }
}
