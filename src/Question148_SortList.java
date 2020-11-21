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
		ListNode148 head = new ListNode148(nums[0]);
		ListNode148 p = head;
		for(int i = 1; i < nums.length; i++) {
			p.next = new ListNode148(nums[i]);
			p = p.next;
		}

		solution148.display(head);

		ListNode148 result = solution148.sortList(head);

		solution148.display(result);
	}
}

//  Definition for singly-linked list.
class ListNode148 {
	int val;
	ListNode148 next;

	ListNode148() {}

	ListNode148(int val) {
		this.val = val;
	}

	ListNode148(int val, ListNode148 next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}
}

class Solution148 {
	public ListNode148 sortList(ListNode148 head) {
		return sortList(head, null);
	}

	public ListNode148 sortList(ListNode148 head, ListNode148 tail) {
		if(head == null) {
			return head;
		}
		if(head.next == tail) {
			head.next = null;
			return head;
		}
		ListNode148 slow = head, fast = head;
		while(fast != tail) {
			slow = slow.next;
			fast = fast.next;
			if(fast != tail) {
				fast = fast.next;
			}
		}
		ListNode148 mid = slow;
		ListNode148 list1 = sortList(head, mid);
		ListNode148 list2 = sortList(mid, tail);
		return merge(list1, list2);
	}

	public ListNode148 merge(ListNode148 head1, ListNode148 head2) {
		ListNode148 dummyHead = new ListNode148(0);
		ListNode148 temp = dummyHead, temp1 = head1, temp2 = head2;
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

	public void display(ListNode148 head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}


/*
class Solution148 {
	public ListNode148 sortList(ListNode148 head) {
		// 空链表或仅含有一个节点的链表直接返回
		if(head == null || head.next == null) {
			return head;
		}

		// 找到末尾节点
		ListNode148 end = head;
		while(end.next != null) {
			end = end.next;
		}

		// 末尾节点后加虚拟空节点
		ListNode148 lastNull = new ListNode148();
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


public ListNode148 quickSort(ListNode148 begin, ListNode148 end) {
	// 为空或为单个节点时返回
	if(begin == null || begin.next == null || begin == end) {
		return begin;
	}

	// 进行一次划分
	ListNode148[] beginAndIndex = partition(begin, end);

	// 得到新的开始、划分点以及结束位置
	begin = beginAndIndex[0];
	ListNode148 index = beginAndIndex[1];

	// 划分前部分
	begin = quickSort(begin, index);

	// 划分后部分并连接
	index.next = quickSort(index.next, end);

	return begin;
}

	public ListNode148[] partition(ListNode148 begin, ListNode148 end) {
		// 创建数组
		ListNode148[] beginAndIndex = new ListNode148[2];
		beginAndIndex[1] = begin;

		// 为空或仅有一个节点
		if(begin == end || begin == null || begin.next == end) {
			beginAndIndex[0] = begin;
			return beginAndIndex;
		}

		// 划分基准点
		int tmp = begin.val;
		ListNode148 first = begin;
		ListNode148 pre = begin;
		ListNode148 index = begin.next;

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

	public void display(ListNode148 head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
 */