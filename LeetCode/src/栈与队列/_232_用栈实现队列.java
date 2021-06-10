package 栈与队列;

import java.util.Stack;

/**
 * @ClassName: 待分类._232_用栈实现队列
 * @Author: whc
 * @Date: 2021/04/23/9:07
 */
public class _232_用栈实现队列 {

	Stack<Integer> inputStack;
	Stack<Integer> outputStack;

	/** Initialize your data structure here. */
	public _232_用栈实现队列() {
		inputStack = new Stack<>();
		outputStack = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		inputStack.push(x);
	}

	/** Removes the e lement from in front of queue and returns that element. */
	public int pop() {
		if(!outputStack.isEmpty()) {
			return outputStack.pop();
		}
		while(!inputStack.isEmpty()) {
			outputStack.push(inputStack.pop());
		}
		return outputStack.pop();
	}

	/** Get the front element. */
	public int peek() {
		int result = pop();
		outputStack.add(result);
		return result;
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return inputStack.isEmpty() && outputStack.isEmpty();
	}
}
