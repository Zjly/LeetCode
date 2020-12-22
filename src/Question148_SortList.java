import java.util.List;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 */

public class Question148_SortList {
	public static void main(String[] args) {
		Solution148 solution148 = new Solution148();

		int[] nums = new int[]{1, 9, 2, 3, 5, 8, 6, 7, 4};
		ListNode head = new ListNode(nums[0]);
		ListNode p = head;
		for(int i = 1; i < nums.length; i++) {
			p.next = new ListNode(nums[i]);
			p = p.next;
		}

		solution148.display(head);

		ListNode result = solution148.sortList(head);

		solution148.display(result);
	}
}

class Solution148 {
	public ListNode sortList(ListNode head) {
		return sortList(head, null);
	}

	public ListNode sortList(ListNode head, ListNode tail) {
		if(head == null) {
			return head;
		}
		if(head.next == tail) {
			head.next = null;
			return head;
		}
		ListNode slow = head, fast = head;
		while(fast != tail) {
			slow = slow.next;
			fast = fast.next;
			if(fast != tail) {
				fast = fast.next;
			}
		}
		ListNode mid = slow;
		ListNode list1 = sortList(head, mid);
		ListNode list2 = sortList(mid, tail);
		return merge(list1, list2);
	}

	public ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummyHead = new ListNode(0);
		ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
		while(temp1 != null && temp2 != null) {
			if(temp1.val <= temp2.val) {
				temp.next = temp1;
				temp1 = temp1.next;
			} else {
				temp.next = temp2;
				temp2 = temp2.next;
			}
			temp = temp.next;
		}
		if(temp1 != null) {
			temp.next = temp1;
		} else if(temp2 != null) {
			temp.next = temp2;
		}
		return dummyHead.next;
	}

	public void display(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}


/*
class Solution148 {
	public ListNode sortList(ListNode head) {
		// 空链表或仅含有一个节点的链表直接返回
		if(head == null || head.next == null) {
			return head;
		}

		// 找到末尾节点
		ListNode end = head;
		while(end.next != null) {
			end = end.next;
		}

		// 末尾节点后加虚拟空节点
		ListNode lastNull = new ListNode();
		end.next = lastNull;

		// 进行快速排序
		head = quickSort(head, lastNull);

		// 去除添加的空节点
		while(end.next != lastNull) {
			end = end.next;
		}
		end.next = null;

		return head;
	}


public ListNode quickSort(ListNode begin, ListNode end) {
	// 为空或为单个节点时返回
	if(begin == null || begin.next == null || begin == end) {
		return begin;
	}

	// 进行一次划分
	ListNode[] beginAndIndex = partition(begin, end);

	// 得到新的开始、划分点以及结束位置
	begin = beginAndIndex[0];
	ListNode index = beginAndIndex[1];

	// 划分前部分
	begin = quickSort(begin, index);

	// 划分后部分并连接
	index.next = quickSort(index.next, end);

	return begin;
}

	public ListNode[] partition(ListNode begin, ListNode end) {
		// 创建数组
		ListNode[] beginAndIndex = new ListNode[2];
		beginAndIndex[1] = begin;

		// 为空或仅有一个节点
		if(begin == end || begin == null || begin.next == end) {
			beginAndIndex[0] = begin;
			return beginAndIndex;
		}

		// 划分基准点
		int tmp = begin.val;
		ListNode first = begin;
		ListNode pre = begin;
		ListNode index = begin.next;

		// 对后续结点进行划分
		while(index != end) {
			if(index.val < tmp) {
				pre.next = index.next;
				index.next = first;
				first = index;
				index = pre.next;
			} else {
				pre = pre.next;
				index = index.next;
			}
		}

		beginAndIndex[0] = first;

		return beginAndIndex;
	}

	public void display(ListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
 */