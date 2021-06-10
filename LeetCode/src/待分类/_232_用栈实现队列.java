package 待分类;

import java.util.Stack;

/**
 * @ClassName: 待分类._232_用栈实现队列
 * @Author: whc
 * @Date: 2021/03/08/11:54
 */
public class _232_用栈实现队列 {

	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	/** Initialize your data structure here. */
	public _232_用栈实现队列() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		stack1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if(!stack2.isEmpty())
			return stack2.pop();
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

	/** Get the front element. */
	public int peek() {
		if(!stack2.isEmpty())
			return stack2.peek();
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
