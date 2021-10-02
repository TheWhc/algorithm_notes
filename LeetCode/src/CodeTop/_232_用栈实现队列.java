package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _232_用栈实现队列
 * @Author: whc
 * @Date: 2021/09/28/22:29
 */
public class _232_用栈实现队列 {

	Stack<Integer> inStack;
	Stack<Integer> outStack;
	/** Initialize your data structure here. */
	public _232_用栈实现队列() {
		inStack = new Stack<>();
		outStack = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		inStack.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if(outStack.size() > 0) {
			return outStack.pop();
		}
		while(!inStack.isEmpty()) {
			outStack.push(inStack.pop());
		}

		return outStack.pop();
	}

	/** Get the front element. */
	public int peek() {
		int res = this.pop();
		outStack.push(res);
		return res;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return outStack.isEmpty() && inStack.isEmpty();
	}

}
