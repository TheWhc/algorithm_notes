package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _155_最小栈
 * @Author: whc
 * @Date: 2021/07/24/15:07
 */
public class _155_最小栈 {

	Stack<Integer> pushStack;
	Stack<Integer> minNumStack;
	/** initialize your data structure here. */
	public _155_最小栈() {
		this.pushStack = new Stack<>();
		this.minNumStack = new Stack<>();
	}

	public void push(int val) {
		pushStack.push(val);
		if(minNumStack.isEmpty() || minNumStack.peek() >= val) {
			minNumStack.push(val);
		}
	}

	public void pop() {
		if(pushStack.pop().equals(minNumStack.peek())) {
			minNumStack.pop();
		}
	}

	public int top() {
		return pushStack.peek();
	}

	public int getMin() {
		return minNumStack.peek();
	}
}
