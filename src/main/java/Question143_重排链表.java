/**
 * 143. 重排链表
 * 中等
 * 1.3K
 * 相关企业
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 *
 *
 * 提示：
 *
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 */

public class Question143_重排链表 {
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
class Solution143 {
    public void reorderList(ListNode head) {
        int length = 0;

        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        if (length == 1 || length == 2) {
            return;
        }

        int half = (length + 1) / 2;
        p = head;
        for (int i = 0; i < half - 1; i++) {
            p = p.next;
        }

        ListNode tail = reverse(p.next);
        p.next = null;

        while (head != null && tail != null) {
            ListNode a = head.next;
            ListNode b = tail.next;

            head.next = tail;
            tail.next = a;

            head = a;
            tail = b;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;

        while (p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }

        return pre;
    }
}