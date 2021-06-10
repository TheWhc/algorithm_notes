package 剑指offer;

import java.util.Stack;

/**
 * @ClassName: _剑指_Offer_09_用两个栈实现队列
 * @Author: whc
 * @Date: 2021/05/23/9:07
 */
public class _剑指_Offer_09_用两个栈实现队列 {

	Stack<Integer> pushStack;
	Stack<Integer> popStack;

	public _剑指_Offer_09_用两个栈实现队列() {
		this.pushStack = new Stack<>();
		this.popStack  = new Stack<>();
	}

	public void appendTail(int value) {
		pushStack.add(value);
	}

	public int deleteHead() {
		// 弹出元素的栈中仍有元素,则返回出栈元素
		if(popStack.size() > 0) {
			return popStack.pop();
		}

		// 弹出元素的栈为空,入栈元素的栈也为空,返回-1
		if(popStack.size() == 0) return -1;

		// 入栈元素的栈为空,则不断从出栈的栈弹出元素
		while(pushStack.size() > 0) {
			popStack.add(pushStack.pop());
		}

		return popStack.pop();
	}
}
