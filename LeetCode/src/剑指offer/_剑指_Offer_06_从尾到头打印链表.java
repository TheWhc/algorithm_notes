package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 剑指offer._剑指_Offer_06_从尾到头打印链表
 * @Author: whc
 * @Date: 2021/04/01/23:48
 */
public class _剑指_Offer_06_从尾到头打印链表 {

	// 2021/4/1 二刷
	/*public  int[] reversePrint(ListNode head){
		if(head == null) {
			return new int[0];
		}
		List<Integer> list = new ArrayList<>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}

		Collections.reverse(list);
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}*/

	// 递归法
	/*List<Integer> list = new ArrayList<>();
	public  int[] reversePrint(ListNode head){
		recur(head);
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private void recur(ListNode head) {
		if(head == null)
			return;
		recur(head.next);
		list.add(head.val);
	}*/


	// 2021/5/22 三刷
	/*
	 * 思路: 用栈存储遍历得到的数据,然后再依次出栈添加到结果数组中
	 * 时间: O(n)
	 * 空间：O(n)
	 */
	/*public int[] reversePrint(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		while(head != null) {
			stack.push(head.val);
			head = head.next;
		}
		int[] res = new int[stack.size()];
		int idx = 0;
		while(!stack.isEmpty()) {
			res[idx++] = stack.pop();
		}

		return res;
	}*/

	/**
	 * 思路: 两次遍历链表
	 * 时间: O(n)
	 * 空间: O(1)
	 */
	public int[] reversePrint(ListNode head) {
		int count = 0;
		ListNode node = head;

		while(node != null) {
			count++;
			node = node.next;
		}

		int[] res = new int[count];
		node = head;

		for (int i = count-1; i >= 0; i--) {
			res[i] = node.val;
			node = node.next;
		}

		return res;
	}

}
