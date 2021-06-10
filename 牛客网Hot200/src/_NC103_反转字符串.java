import java.util.Stack;

/**
 * @ClassName: _NC103_反转字符串
 * @Author: whc
 * @Date: 2021/02/25/10:37
 */
public class _NC103_反转字符串 {

	/*public String solve (String str) {
		// write code here
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}*/

	/*public String solve (String str) {
		// write code here
		char[] res = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			res[i] = str.charAt(str.length()- 1 - i);
		}
		return new String(res);
	}*/

	public String solve (String str) {
		// write code here
		char[] res = str.toCharArray();
		int length = str.length();
		// wuhuanc
		for (int i = 0; i < length/2; i++) {
			char c = res[i];
			res[i] = res[length - 1 -i];
			res[length - 1 - i] = c;
		}
		return new String(res);
	}
}
