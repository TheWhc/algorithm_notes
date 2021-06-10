package 待分类;

/**
 * @ClassName: 待分类._83_删除排序链表中的重复元素
 * @Author: whc
 * @Date: 2021/03/21/16:06
 */
public class _83_删除排序链表中的重复元素 {
	/*public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode nextList = deleteDuplicates(head.next);
		if(head.val == nextList.val) {
			return nextList;
		} else {
			head.next = nextList;
			return head;
		}
	}*/

	public ListNode deleteDuplicates(ListNode head) {
		 ListNode cur = head;
		 while(cur.next != null) {
		 	if(cur.val == cur.next.val) {
		 		cur.next = cur.next.next;
			} else {
		 		cur = cur.next;
			}
		 }
		 return head;
	}
}
