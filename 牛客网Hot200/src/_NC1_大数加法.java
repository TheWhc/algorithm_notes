import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName: _NC1_大数加法
 * @Author: whc
 * @Date: 2021/02/23/11:23
 */
public class _NC1_大数加法 {
	/*public static String solve (String s, String t) {
		// write code here
		char[] chars1 = s.toCharArray();
		char[] chars2 = t.toCharArray();
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		for (char c : chars1) {
			stack1.push(Integer.valueOf(c - '0'));
		}
		for (char c : chars2) {
			stack2.push(Integer.valueOf(c - '0'));
		}

		StringBuilder sb = new StringBuilder();
		Stack<Character> stack3 = new Stack<>();
		int carry = 0;
		while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int a = 0, b = 0;
			if(!stack1.isEmpty()) {
				a = stack1.pop();
			}
			if(!stack2.isEmpty()) {
				b = stack2.pop();
			}
			int sum = a + b + carry;
			carry = sum / 10;
			stack3.push((char) ((sum % 10) + '0'));
		}

		while(!stack3.isEmpty()) {
			sb.append(stack3.pop());
		}

		return sb.toString();
	}*/

	public static String solve (String s, String t) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder stringBuilder = new StringBuilder();
		int i = s.length() - 1;
		int j = t.length() - 1;
		int carry = 0;
		while(i >= 0 || j >= 0 || carry != 0) {
			int sum = 0;
			sum += carry;
			sum += i>= 0 ? s.charAt(i--) - '0' : 0;
			sum += j>= 0 ? t.charAt(j--) - '0' : 0;
			carry = sum / 10;
			stack.push(sum % 10);
		}
		while(!stack.isEmpty()) {
			stringBuilder.append(stack.pop());
		}

		return stringBuilder.toString();
	}
}
