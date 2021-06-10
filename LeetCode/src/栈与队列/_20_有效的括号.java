package 栈与队列;

import java.util.Stack;

/**
 * @ClassName: 待分类._20_有效的括号
 * @Author: whc
 * @Date: 2021/04/23/10:04
 */
public class _20_有效的括号 {

	public boolean isValid(String s) {
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for(char c : chars) {
			if(c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if(stack.isEmpty()) {
					return false;
				}
				if(c == ')' && stack.peek() != '('){
					return false;
				} else if(c == ']' && stack.peek() != '[') {
					return false;
				} else if(c == '}' && stack.peek() != '{') {
					return false;
				}
				stack.pop();
			}
		}

		return stack.isEmpty();
	}
}
