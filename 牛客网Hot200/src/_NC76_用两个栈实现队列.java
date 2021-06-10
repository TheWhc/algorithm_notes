import java.util.Stack;

/**
 * @ClassName: _NC76_用两个栈实现队列
 * @Author: whc
 * @Date: 2021/02/19/11:04
 */
public class _NC76_用两个栈实现队列 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	// 1 2 3 4
	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		if(stack2.size() != 0) {
			return stack2.pop();
		}
		while(stack1.size() != 0) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

	public static void main(String[] args) {
		_NC76_用两个栈实现队列 a = new _NC76_用两个栈实现队列();
//		["PSH1","PSH2","POP","POP"]
		a.push(1);
		a.push(2);
		System.out.println(a.pop());
		System.out.println(a.pop());
	}
}
