package 链表;

/**
 * @ClassName: _707_设计链表
 * @Author: whc
 * @Date: 2021/07/04/10:28
 */
public class _707_设计链表 {

	// 单链表
	class ListNode {
		int val;
		ListNode next;
		ListNode() {}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	// size存储链表元素的个数
	int size;
	// 虚拟头节点
	ListNode head;
	/** Initialize your data structure here. */
	public _707_设计链表() {
		this.head = new ListNode(0);
		this.size = 0;
	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		// index非法,返回-1
		if(index < 0 || index >= size) {
			return -1;
		}

		ListNode cur = head;
		for (int i = 0; i <= index; i++) {
			cur = cur.next;
		}

		return cur.val;
	}

	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
		addAtIndex(0, val);
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		addAtIndex(size, val);
	}

	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	public void addAtIndex(int index, int val) {
		if(index > size) {
			return;
		}

		if(index < 0) {
			index = 0;
		}
		size++;

		// 找到要插入的前驱
		ListNode pre = head;
		for (int i = 0; i < index; i++) {
			pre = pre.next;
		}
		ListNode toAdd = new ListNode(val);
		toAdd.next = pre.next;
		pre.next = toAdd;
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if(index < 0 || index >= size) {
			return;
		}
		size--;
		// 找到要删除的前驱
		ListNode pre = head;
		for (int i = 0; i < index; i++) {
			pre = pre.next;
		}
		pre.next = pre.next.next;
	}
}
