import org.junit.jupiter.api.Test;

/**
 * 23. 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */

public class Question23_合并K个升序链表 {
    Solution23 solution23 = new Solution23();

    @Test
    public void test() {
        ListNode list1 = ListNodeTool.createListNode(new int[]{1, 4, 5});
        ListNode list2 = ListNodeTool.createListNode(new int[]{1, 3, 4});
        ListNode list3 = ListNodeTool.createListNode(new int[]{2, 6});
        ListNode[] lists = {list1, list2, list3};
        ListNodeTool.displayListNode(solution23.mergeKLists(lists));
    }
}

/*
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * @author Zhang Lei
 * @date 2023/8/12 21:42
 */
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        while (lists.length != 1) {
            ListNode[] nLists = new ListNode[(lists.length + 1) / 2];
            for (int i = 0; i < nLists.length; i++) {
                if (i * 2 + 1 < lists.length) {
                    nLists[i] = merge2Lists(lists[2 * i], lists[2 * i + 1]);
                } else {
                    nLists[i] = lists[2 * i];
                }
            }

            lists = nLists;
        }

        return lists[0];
    }

    private ListNode merge2Lists(ListNode head1, ListNode head2) {
        ListNode head = new ListNode();
        ListNode p = head;

        while (head1 != null || head2 != null) {
            if (head1 == null) {
                p.next = head2;
                head2 = null;
            } else if (head2 == null) {
                p.next = head1;
                head1 = null;
            } else if (head1.val <= head2.val) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }

            p = p.next;
        }

        return head.next;
    }
}