package 剑指offer;

/**
 * @ClassName: _删除链表中重复的节点_
 * @Author: whc
 * @Date: 2021/05/26/0:53
 */
public class _删除链表中重复的节点_ {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		_删除链表中重复的节点_ a = new _删除链表中重复的节点_();
		a.deleteDuplication(head);
	}

	/**
	 * 思路: 递归删除节点
	 * 比如: 1->1->1->1->2
	 * 1. 当前头结点值为1,跳过值与头节点相同的节点,直到2为止, 然后开始递归与头节点不同值的节点
	 * 2. 若当前头结点和下一个节点不相同,则直接返回pHead.next = 递归函数(pHead.next)
	 *
	 * 时间: O(n)
	 * 空间: O(n)
	 *
	 * 最差情况下链表没有重复节点时,每个节点都需要递归判断
	 *
	 */
	/*public ListNode deleteDuplication(ListNode pHead) {
		if(pHead == null || pHead.next == null) {
			return pHead;
		}

		if(pHead.val == pHead.next.val) { // 当前节点是重复节点
			ListNode node = pHead.next;
			// 跳过值与当前节点相同的全部节点
			while(node != null && node.val == pHead.val) {
				node = node.next;
			}
			// 从第一个与当前节点不同的节点继续递归
			return deleteDuplication(node);
		} else {
			pHead.next = deleteDuplication(pHead.next);
			return pHead;
		}
	}*/

	// 遍历的同时删除
	// 时间:O(n)
	// 空间:O(1)
	public ListNode deleteDuplication(ListNode pHead) {
		// 虚拟节点
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = pHead;
		ListNode pre = dummy;
		ListNode cur = dummy.next;

		while(cur != null) {
			if(cur.next != null && cur.val == cur.next.val) {
				// 相同节点一直前进
				while(cur.next != null && cur.val == cur.next.val) {
					cur = cur.next;
				}
				cur = cur.next;
				pre.next = cur;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}

		return dummy.next;
	}
}
