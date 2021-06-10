package 待分类;

import java.util.Stack;

/**
 * @ClassName: 待分类._155_最小栈
 * @Author: whc
 * @Date: 2021/03/19/14:15
 */
public class _155_最小栈 {

	Stack<Integer> stack;
	Stack<Integer> minStack;

	public _155_最小栈() {
		this.stack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public void push(int val) {
		stack.push(val);
		if(minStack.isEmpty() || minStack.peek() >= val) {
			minStack.push(val);
		}
	}

	public void pop() {
		if(minStack.peek().equals(stack.pop()))
			minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

}
