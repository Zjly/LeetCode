/**
 * 24. 两两交换链表中的节点
 * 中等
 * 1.9K
 * 相关企业
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 */

public class Question24_两两交换链表中的节点 {
}

/**
 * @author Zhang Lei
 * @date 2023/8/6 22:24
 */
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode n = new ListNode();
        n.next = head;

        ListNode pre = n;
        ListNode first = head;
        ListNode second = first != null ? first.next : null;
        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            pre.next = second;

            pre = first;
            first = pre.next;
            second = first != null ? first.next : null;
        }

        return n.next;
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