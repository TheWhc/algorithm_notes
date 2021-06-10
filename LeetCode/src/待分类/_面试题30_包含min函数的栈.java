package 待分类;

import java.util.Stack;

/**
 * @ClassName: 待分类._面试题30_包含min函数的栈
 * @Author: whc
 * @Date: 2021/04/02/13:33
 */
public class _面试题30_包含min函数的栈 {

	Stack<Integer> stack;
	Stack<Integer> temp;

	public _面试题30_包含min函数的栈() {
		this.stack = new Stack<>();
		this.temp = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		if(temp.isEmpty() || temp.peek() >= x) {
			temp.push(x);
		}
	}

	public void pop() {
		Integer pop = stack.pop();
		if(pop.equals(temp.peek())) {
			temp.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int min() {
		return temp.peek();
	}

	public static void main(String[] args) {
		_面试题30_包含min函数的栈 a = new _面试题30_包含min函数的栈();
		a.push(512);
		a.push(-1024);
		a.push(-1024);
		a.push(512);
		a.pop();
		a.min();
		a.pop();
		a.min();
		a.pop();
		a.min();
	}
}
