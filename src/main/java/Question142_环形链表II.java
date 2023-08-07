import org.junit.jupiter.api.Test;

/**
 * 142. 环形链表 II
 * 中等
 * 2.2K
 * 相关企业
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 * <p>
 * <p>
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 */

public class Question142_环形链表II {
    Solution142 solution142 = new Solution142();

    @Test
    public void test() {
    	ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(2);
    	ListNode node3 = new ListNode(3);
    	ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(solution142.detectCycle(node1));
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        boolean circle = false;
        boolean odd = true;
        while (fast != null) {
            fast = fast.next;

            if (odd) {
                slow = slow.next;
            } else {
                if (fast == slow) {
                    circle = true;
                    break;
                }
            }

            odd = !odd;
        }

        if(!circle) {
            return null;
        }

        int length = 0;
        odd = true;
        do {
            fast = fast.next;

            if (odd) {
                slow = slow.next;
                length++;
            }

            odd = !odd;
        } while (fast != slow || !odd);

        fast = head;
        slow = head;
        for (int i = 0; i < length; i++) {
            fast = fast.next;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}