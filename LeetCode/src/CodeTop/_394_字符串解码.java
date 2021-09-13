package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _394_字符串解码
 * @Author: whc
 * @Date: 2021/09/13/12:57
 */
public class _394_字符串解码 {

	public String decodeString(String s) {
		if(s == null || s.length() == 0) {
			return "";
		}

		Stack<Integer> numStack = new Stack<>();
		Stack<String> strStack = new Stack<>();

		int ans = 0;
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				ans = ans * 10 + (s.charAt(i) - '0');
			} else if(s.charAt(i) == '[') {
				numStack.push(ans);
				ans = 0;
				strStack.push(res);
				res = "";
			} else if(s.charAt(i) == ']') {
				String temp = "";
				int cnt = numStack.pop();
				for (int j = 0; j < cnt; j++) {
					temp += res;
				}
				res = strStack.isEmpty() ? temp : strStack.pop() + temp;
			} else {
				res += s.charAt(i);
			}
		}

		return res;
	}
}
