package CodeTop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _225_用队列实现栈
 * @Author: whc
 * @Date: 2021/08/04/17:01
 */
public class _225_用队列实现栈 {

	Queue<Integer> queue1; // 模拟栈
	Queue<Integer> queue2; // 辅助队列

	/** Initialize your data structure here. */
	public _225_用队列实现栈() {
		this.queue1 = new LinkedList<>();
		this.queue2 = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue2.offer(x);

		while(!queue1.isEmpty()) {
			queue2.offer(queue1.poll());
		}

		// 交换队列,保证辅助队列queue2始终为空
		Queue<Integer> tmp = queue1;
		queue1 = queue2;
		queue2 = tmp;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return queue1.poll();
	}

	/** Get the top element. */
	public int top() {
		return queue1.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue1.isEmpty();
	}
}
