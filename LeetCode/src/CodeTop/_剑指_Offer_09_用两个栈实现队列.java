package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _剑指_Offer_09_用两个栈实现队列
 * @Author: whc
 * @Date: 2021/07/26/15:25
 */
public class _剑指_Offer_09_用两个栈实现队列 {

	Stack<Integer> pushStack;
	Stack<Integer> popStack;
	public _剑指_Offer_09_用两个栈实现队列() {
		this.pushStack = new Stack<>();
		this.popStack = new Stack<>();
	}

	public void appendTail(int value) {
		pushStack.push(value);
	}

	public int deleteHead() {
		if(!popStack.isEmpty()) {
			return popStack.pop();
		}

		if(pushStack.isEmpty()) {
			return -1;
		}

		while(!pushStack.isEmpty()) {
			popStack.push(pushStack.pop());
		}

		return popStack.pop();
	}
}
