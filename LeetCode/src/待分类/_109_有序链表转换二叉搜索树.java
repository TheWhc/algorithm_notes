package 待分类;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._109_有序链表转换二叉搜索树
 * @Author: whc
 * @Date: 2021/03/12/21:13
 */
public class _109_有序链表转换二叉搜索树 {

	// 数组 + 递归  有序链表转化为有序数组
	/*public TreeNode sortedListToBST(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		Integer[] array = list.toArray(new Integer[list.size()]);
		return dfs(array, 0, array.length-1);
	}

	private TreeNode dfs(Integer[] array, int left, int right) {
		if(left > right)
			return null;
		int mid = left + (right - left) / 2;
		TreeNode node = new TreeNode(array[mid]);
		node.left = dfs(array, left, mid-1);
		node.right = dfs(array, mid+1, right);
		return node;
	}*/

	// 快慢指针 慢指针刚好到链表中间
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) {
			return null;
		} else if(head.next == null) {
			return new TreeNode(head.val);
		}

		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = null;
		// 利用快慢指针找出链表的中间结点
		while(fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast =  fast.next.next;
		}

		// 创建树的结点,并断开相应连接
		TreeNode node = new TreeNode(slow.val);
		pre.next = null;

		// 递归链表中间结点左右两边的子链表
		node.left = sortedListToBST(head);
		node.right = sortedListToBST(slow.next);

		return node;
	}
}
