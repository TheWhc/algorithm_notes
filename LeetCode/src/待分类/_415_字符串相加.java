package 待分类;

import java.util.Stack;

/**
 * @ClassName: 待分类._415_字符串相加
 * @Author: whc
 * @Date: 2021/03/04/11:35
 */
public class _415_字符串相加 {

	/*public static String addStrings(String num1, String num2) {
		// 使用栈
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		char[] chars1 = num1.toCharArray();
		char[] chars2 = num2.toCharArray();
		for (char c : chars1) {
			stack1.push(Integer.valueOf(c - '0'));
		}
		for (char c : chars2) {
			stack2.push(Integer.valueOf(c - '0'));
		}

		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while(!stack1.isEmpty()|| !stack2.isEmpty() || carry != 0) {
			int sum = 0;
			if(!stack1.isEmpty()) {
				sum += stack1.pop();
			}
			if(!stack2.isEmpty()) {
				sum += stack2.pop();
			}
			sum += carry;
			carry = sum / 10;
			sb.append(sum % 10);
		}

		return sb.reverse().toString();
	}*/

	// 双指针
	public static String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int i = num1.length()-1;
		int j = num2.length()-1;
		int carry = 0;
		while(i >= 0 || j >= 0 || carry != 0) {
			int a = i >= 0 ? num1.charAt(i) - '0' : 0;
			int b = j >= 0 ? num2.charAt(j) - '0' : 0;
			int sum = a + b + carry;
			carry = sum / 10;
			sb.append(sum % 10);
			i--;
			j--;
		}
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(addStrings("1234", "36"));
	}
}
