import java.util.Stack;

/**
 * @ClassName: _NC52_括号序列
 * @Author: whc
 * @Date: 2021/02/22/10:31
 */
public class _NC52_括号序列 {
	public boolean isValid (String s) {
		// write code here
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack();
		for (char c : chars) {
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if(stack.size() <= 0) {
					return false;
				}
				if(stack.peek() == '(' && c != ')') {
					return false;
				}
				if(stack.peek() == '[' && c != ']') {
					return false;
				}
				if(stack.peek() == '{' && c != '}') {
					return false;
				}
				stack.pop();
			}
		}

		return stack.size() == 0;
	}
}
