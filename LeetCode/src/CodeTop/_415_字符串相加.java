package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _415_字符串相加
 * @Author: whc
 * @Date: 2021/07/20/13:57
 */
public class _415_字符串相加 {

	/*public static String addStrings(String num1, String num2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		for (int i = 0; i < num1.length(); i++) {
			stack1.push(num1.charAt(i) - '0');
		}

		for (int i = 0; i < num2.length(); i++) {
			stack2.push(num2.charAt(i) - '0');
		}

		int carry = 0;
		StringBuilder res = new StringBuilder();
		while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int sum = 0;
			if(!stack1.isEmpty()) {
				sum += stack1.pop();
			}
			if(!stack2.isEmpty()) {
				sum += stack2.pop();
			}
			sum += carry;
			res.append(sum % 10);
			carry = sum/ 10;
		}

		return res.reverse().toString();
	}*/

	// 双指针法
	public static String addStrings(String num1, String num2) {
		StringBuilder res = new StringBuilder();
		int i = num1.length()-1;
		int j = num2.length()-1;

		int carry = 0;
		while(i >= 0 || j >= 0 || carry != 0) {
			int sum = 0;
			if(i >= 0) {
				sum += num1.charAt(i) - '0';
				i--;
			}
			if(j >= 0) {
				sum += num2.charAt(j) - '0';
				j--;
			}
			sum += carry;
			carry = sum / 10;
			res.append(sum % 10);
		}

		return res.reverse().toString();
	}

	public static void main(String[] args) {
		_415_字符串相加 _415_字符串相加 = new _415_字符串相加();
		System.out.println(_415_字符串相加.addStrings("1", "9"));
	}
}
