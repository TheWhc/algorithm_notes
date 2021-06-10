package 剑指offer;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: 待分类._23_合并K个升序链表
 * @Author: whc
 * @Date: 2021/05/27/11:49
 */
public class _23_合并K个升序链表 {

	/**
	 * 思路:逐一合并两条链表
	 *
	 * 时间: O(NK)   K条链表的总节点数是N
	 * 空间: O(1)
	 */
	/*public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) {
			return new ListNode();
		}
		ListNode res = lists[0];

		for (int i = 1; i < lists.length; i++) {
			res = mergeTwoList(res, lists[i]);
		}

		return res;
	}*/
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[2];
		ListNode list = new ListNode(1);
		list.next = new ListNode(4);
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(3);
		lists[0] = list;
		lists[1] = list1;
		new _23_合并K个升序链表().mergeKLists(lists);
	}

	/**
	 *  思路: 归并排序
	 *  1. 将lists列表不断进行二分划分,最后划分到只剩下一个链表
	 *  2. 然后将划分出来的链表们进行两两合并,一直合并到生成最终的升序链表为止
	 *
	 *  时间: O(NlogK) 每一层归并的时间是O(N),归并层数最大为O(logK+1)
	 *  空间: O(logN)  递归栈的大小
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
		return merge(lists, 0, lists.length-1);
	}

	private ListNode merge(ListNode[] lists, int left, int right) {
		if(left == right) {
			return lists[left];
		}
		int mid = left + (right - left) / 2;
		ListNode l1 = merge(lists, left, mid);
		ListNode l2 = merge(lists, mid + 1, right);
		return mergeTwoList(l1, l2);
	}

	private ListNode mergeTwoList(ListNode res, ListNode list) {
		// 迭代法合并
		ListNode dummy = new ListNode();
		ListNode cur = dummy;

		while(res != null && list != null) {
			if(res.val <= list.val) {
				cur.next = res;
				res = res.next;
			} else {
				cur.next = list;
				list = list.next;
			}
			cur = cur.next;
		}

		cur.next = res == null ? list : res;

		return dummy.next;
	}


	/**
	 *  思路: 小根堆
	 */
	/*public ListNode mergeKLists(ListNode[] lists) {
	}*/

}
