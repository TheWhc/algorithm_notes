package 栈与队列;

import java.util.Stack;

/**
 * @ClassName: _1047_删除字符串中的所有相邻重复项
 * @Author: whc
 * @Date: 2021/04/23/10:23
 */
public class _1047_删除字符串中的所有相邻重复项 {

	public String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < S.length(); i++) {
			if(stack.isEmpty() || stack.peek() != S.charAt(i)) {
				stack.push(S.charAt(i));
			} else {
				stack.pop();
			}
		}

		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}
}
