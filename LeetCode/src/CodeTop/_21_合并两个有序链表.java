package CodeTop;

/**
 * @ClassName: _21_合并两个有序链表
 * @Author: whc
 * @Date: 2021/09/28/18:10
 */
public class _21_合并两个有序链表 {

	// 迭代合并
	// public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	//     if(l1 == null) {
	//         return l2;
	//     }
	//     if(l2 == null) {
	//         return l1;
	//     }
	//     ListNode newNode = new ListNode(-1);
	//     ListNode cur = newNode;
	//     while(l1 != null && l2 != null) {

	//         if(l1.val < l2.val) {
	//             cur.next = l1;
	//             l1 = l1.next;
	//         } else {
	//             cur.next = l2;
	//             l2 = l2.next;
	//         }
	//         cur = cur.next;
	//     }

	//     if(l1 != null) {
	//         cur.next = l1;
	//     }

	//     if(l2 != null) {
	//         cur.next = l2;
	//     }

	//     return newNode.next;
	// }

	// 递归合并
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}

		if(l2 == null) {
			return l1;
		}

		if(l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
