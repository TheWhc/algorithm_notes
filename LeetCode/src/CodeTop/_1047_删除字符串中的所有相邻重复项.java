package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _1047_删除字符串中的所有相邻重复项
 * @Author: whc
 * @Date: 2021/09/05/13:19
 */
public class _1047_删除字符串中的所有相邻重复项 {

	// 栈
	public String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));

		for (int i = 1; i < s.length(); i++) {
			if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
				stack.pop();
				continue;
			}

			stack.push(s.charAt(i));
		}

		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty()) {
			res.append(stack.pop());
		}

		return res.reverse().toString();
	}
}
