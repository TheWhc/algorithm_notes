import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _NC66_两个链表的第一个公共结点
 * @Author: whc
 * @Date: 2021/02/25/10:55
 */
public class _NC66_两个链表的第一个公共结点 {
	/*public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		// 1->2->3->4
		// 5->6->2->9
		if(pHead1 == null || pHead2 == null) {
			return null;
		}
		Map<Integer, ListNode> map = new HashMap<>();
		while(pHead1 != null) {
			map.put(pHead1.val, pHead1);
			pHead1 = pHead1.next;
		}
		while(pHead2 != null) {
			if(map.containsKey(pHead2.val)){
				return pHead2;
			}
			pHead2 = pHead2.next;
		}
		return null;
	}*/

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null) {
			return null;
		}
		ListNode p = pHead1;
		ListNode q = pHead2;
		while(p != q) {
			p = p == null ? pHead2 : p.next;
			q = q == null ? pHead1 : q.next;
		}
		return pHead1;
	}
}
