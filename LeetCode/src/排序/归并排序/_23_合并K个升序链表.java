package 排序.归并排序;

import java.util.PriorityQueue;

/**
 * @ClassName: _23_合并K个升序链表
 * @Author: whc
 * @Date: 2021/07/17/17:47
 */
public class _23_合并K个升序链表 {

	/**
	 * 思路1: 逐一合并两条链表
	 *
	 * 思路2：分而治之,两两合并
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) {
			return null;
		}

		/*if(lists.length == 1) {
			return lists[0];
		}

		for (int i = 1; i < lists.length; i++) {
			lists[0] = mergeTwoLists(lists[0], lists[i]);

		}

		return lists[0];*/

		return merge(lists, 0, lists.length-1);
	}

	private ListNode merge(ListNode[] lists, int left, int right) {
		// 递归终止条件
		if(left == right) {
			return lists[left];
		}

		int mid = left + (right - left) / 2;
		ListNode l1 = merge(lists, left, mid);
		ListNode l2 = merge(lists, mid+1, right);
		return mergeTwoLists(l1, l2);
	}

	/**
	 * 递归合并两条链表
	 */
	private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}

		if(list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}


	/**
	 * 思路3: 优先队列
	 *
	 * 时间: O(nlogk)
	 * k为链表个数
	 * n为所有链表中元素的总和
	 */
	/*public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) {
			return null;
		}

		// 最小堆,将所有链表放入堆中
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (o1, o2) -> {
			return Integer.compare(o1.val, o2.val);
		});

		for (ListNode list : lists) {
			if(list != null)
				queue.offer(list);
		}

		ListNode res = new ListNode(-1);
		ListNode cur = res;
		while(!queue.isEmpty()) {
			ListNode list = queue.poll();
			cur.next = list;
			cur = cur.next;
			if(list.next != null) {
				queue.offer(list.next);
			}
		}

		return res.next;
	}*/
}
