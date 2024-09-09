/**
 * 2181. 合并零之间的节点
 * 算术评级: 3
 * 第 281 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1333
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。
 * <p>
 * 对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 0 移除，修改后的链表不应该含有任何 0 。
 * <p>
 * 返回修改后链表的头节点 head 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [0,3,1,0,4,5,2,0]
 * 输出：[4,11]
 * 解释：
 * 上图表示输入的链表。修改后的链表包含：
 * - 标记为绿色的节点之和：3 + 1 = 4
 * - 标记为红色的节点之和：4 + 5 + 2 = 11
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [0,1,0,3,0,2,2,0]
 * 输出：[1,3,4]
 * 解释：
 * 上图表示输入的链表。修改后的链表包含：
 * - 标记为绿色的节点之和：1 = 1
 * - 标记为红色的节点之和：3 = 3
 * - 标记为黄色的节点之和：2 + 2 = 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [3, 2 * 105] 内
 * 0 <= Node.val <= 1000
 * 不 存在连续两个 Node.val == 0 的节点
 * 链表的 开端 和 末尾 节点都满足 Node.val == 0
 */

/**
 * @author ZhangLei
 * @version 2024/09/09 23:37
 */
public class Question2181_合并零之间的节点 {
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
class Solution2181 {
    public ListNode mergeNodes(ListNode head) {
        ListNode result = head;
        ListNode p = head;
        ListNode q = p;
        while (q.next != null) {
            while (q.next.val != 0) {
                p.val += q.next.val;
                q = q.next;
            }

            if(q.next.next == null) {
                p.next = null;
                break;
            } else {
                p.next = q.next;
                p = q.next;
                q = p;
            }
        }

        return result;
    }
}