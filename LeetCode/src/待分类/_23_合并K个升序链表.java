package 待分类;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: 待分类._23_合并K个升序链表
 * @Author: whc
 * @Date: 2021/03/07/11:47
 */
public class _23_合并K个升序链表 {

	/*public ListNode mergeKLists(ListNode[] lists) {
		// 按值将ListNode添加到堆中
		PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> (o1.val - o2.val));
		for (int i = 0; i < lists.length; i++) {
			while(lists[i] != null) {
				heap.add(lists[i]);
				lists[i] = lists[i].next;
			}
		}

		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		while(!heap.isEmpty()) {
			p.next = heap.poll();
			p = p.next;
		}
		p.next = null;
		return dummy.next;
	}*/

	// 优化
	/*public ListNode mergeKLists(ListNode[] lists) {
		// 按值将ListNode添加到堆中
		PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> (o1.val - o2.val));
		for (int i = 0; i < lists.length; i++) {
			// 把k个链表的第一个节点加入堆中
			if(lists[i] != null) {
				heap.add(lists[i]);
			}
		}

		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		// 不断从堆中取出节点,如果这个节点还有下一个节点,则将下一个节点加入堆中
		while(!heap.isEmpty()) {
			ListNode node = heap.poll();
			p.next = node;
			p = p.next;
			if(node.next != null) {
				heap.add(node.next);
			}
		}
		p.next = null;
		return dummy.next;
	}*/

	// 两两合并
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0)
			return null;

		ListNode res = lists[0];
		for (int i = 1; i < lists.length; i++) {
			res = merge(res, lists[i]);
		}
		return res;
	}

	private ListNode merge(ListNode res, ListNode list) {
		if(res == null)
			return list;
		if(list == null)
			return res;
		if(res.val < list.val) {
			res.next = merge(res.next, list);
			return res;
		} else {
			list.next = merge(res, list.next);
			return list;
		}
	}
}
