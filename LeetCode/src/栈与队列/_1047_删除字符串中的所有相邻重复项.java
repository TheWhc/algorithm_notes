package 栈与队列;

import java.util.Stack;

/**
 * @ClassName: _1047_删除字符串中的所有相邻重复项
 * @Author: whc
 * @Date: 2021/04/23/10:23
 */
public class _1047_删除字符串中的所有相邻重复项 {

	/**
	 * 思路: 用栈依次存储每个字符
	 * 1. 若遇到和前面字符相同的,则将栈顶字符出栈,以及当前字符不入栈
	 * 2. 否则就入栈当前字符
	 */
	public String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();

		for(char c : s.toCharArray()) {
			if(!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
				continue;
			}
			stack.push(c);
		}

		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty()) {
			res.append(stack.pop());
		}

		return res.reverse().toString();
	}
}
