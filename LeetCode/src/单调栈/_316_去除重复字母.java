package 单调栈;

import java.util.Stack;

/**
 * @ClassName: _316_去除重复字母
 * @Author: whc
 * @Date: 2021/07/15/11:48
 */
public class _316_去除重复字母 {

	/**
	 * 思路：单调栈
	 * 1. 设置一个栈,栈中存储的是字符,保持单调递增
	 * 2. 另外需要一个统计字符次数的数组 以及 字符访问的数组
	 * 3. 遍历字符串s
	 * 		- 如果当前字符已经在栈中,则continue
	 * 		- 如果当前字符小于栈顶元素,则依次出栈顶元素
	 * 				- 出栈顶元素的时候需要注意栈顶元素的字符数是否已经为0,如果已经为0,则结束循环,不出栈
	 * 			出栈的同时设置字符标识为false
	 * 		- 将当前字符入栈,并且设置访问数组的元素为true
	 *
	 *
	 * 	举例:
	 * 	s="cbacdcbc"
	 *
	 * 	入栈的元素最终为: |acdb|
	 */
	public String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		// 字符出现的次数
		int[] count = new int[26];
		// 字符是否在栈中
		boolean[] inStackArray = new boolean[26];
		// 统计s中每个字符的出现次数
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			// 每次循环,对应字符的次数减1
			count[s.charAt(i) - 'a']--;
			// 字符已经在栈中,不再进栈
			if(inStackArray[s.charAt(i) - 'a']) {
				continue;
			}
			// 维护单调递增的栈
			while(!stack.isEmpty() && stack.peek() > s.charAt(i)) {
				// 如果字符统计数已经为0,则结束循环
				if(count[stack.peek() - 'a'] == 0) {
					break;
				}
				inStackArray[stack.pop() - 'a'] = false;
			}
			stack.push(s.charAt(i));
			inStackArray[s.charAt(i) - 'a'] = true;
		}

		StringBuilder res = new StringBuilder();
		while(!stack.isEmpty()) {
			res.append(stack.pop());
		}

		return res.reverse().toString();
	}

	public static void main(String[] args) {
		_316_去除重复字母 _316_去除重复字母 = new _316_去除重复字母();
		System.out.println(_316_去除重复字母.removeDuplicateLetters("cbacdcbc"));
	}
}
