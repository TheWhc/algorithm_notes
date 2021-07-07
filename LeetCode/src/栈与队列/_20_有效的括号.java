package 栈与队列;

import java.util.Stack;

/**
 * @ClassName: 待分类._20_有效的括号
 * @Author: whc
 * @Date: 2021/04/23/10:04
 */
public class _20_有效的括号 {

	/**
	 * 思路: 用栈存储左括号
	 * 1. 遍历字符串,遇到左括号则存储到栈中
	 * 2. 遇到右括号,则看栈顶符号是否与当前右括号匹配,不匹配直接返回false
	 */
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if(c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if(stack.isEmpty()) {
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

		return stack.isEmpty();
	}
}
