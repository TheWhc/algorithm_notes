package 栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _225_用队列实现栈
 * @Author: whc
 * @Date: 2021/04/23/9:23
 */
public class _225_用队列实现栈 {

	public static void main(String[] args) {
		_225_用队列实现栈 a = new _225_用队列实现栈();
		a.push(1);
		a.push(2);
		a.push(3);
		System.out.println(a.pop());
	}

	// 用来模拟stack的push操作
	Queue<Integer> pushQueue;
	// 用来模拟stack的pop、empty、peek操作
	Queue<Integer> popQueue;

	/** Initialize your data structure here. */
	public _225_用队列实现栈() {
		pushQueue = new LinkedList<>();
		popQueue = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		pushQueue.offer(x);

		while(!popQueue.isEmpty()) {
			pushQueue.offer(popQueue.poll());
		}

		// 交换两个队列,使pushQueue维持一个空队列状态
		Queue<Integer> tmp = pushQueue;
		pushQueue = popQueue;
		popQueue = tmp;
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return popQueue.poll();
	}

	/** Get the top element. */
	public int top() {
		return popQueue.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return popQueue.isEmpty();
	}

}
