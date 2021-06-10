package top100;

import java.util.Stack;

/**
 * @ClassName: _394_字符串解码
 * @Author: whc
 * @Date: 2021/05/09/12:46
 */
public class _394_字符串解码 {

	/**
	 * 思路: 利用两个辅助栈 一个是存储数字  一个是存储字符(串)
	 * 		 当遇到数字时, 记录数字
	 * 		 当遇到字母时, 记录字母
	 *       当遇到'['时,便入栈,然后清空此时数字和字符串值
	 *       当遇到']'时,便出栈,以存储数字 * 当前字符串  + 存储字符(串)
	 *
	 * 时间复杂度: O(n)
	 * 额外空间: O(n)
	 */
	public static String decodeString(String s) {
		// 辅助栈
		Stack<Integer> multiStack = new Stack<>();
		Stack<String> resStack = new Stack<>();

		StringBuilder res = new StringBuilder();
		int multi = 0;

		// 遍历字符数组
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// 遇到数字
			if(c >= '0' && c <= '9') {
				// 比如出现100[leetcode]
				// 注意转化为数字 - '0'
				multi = multi * 10 + (c - '0');
			} else if (c >= 'a' && c <= 'z') {
				// 字母
				res.append(c);
			} else if(c == '[') {
				// 左括号
				// 将multi入栈,multi清0
				// 将res入栈,res清空
				multiStack.push(multi);
				multi = 0;
				resStack.push(res.toString());
				res = new StringBuilder();
			} else if(c == ']') {
				// 右括号
				// 出栈 multiStack出栈-> cur_multi
				//     resStack出栈-> pre_res
				Integer cur_multi = multiStack.pop();
				String pre_res = resStack.pop();
				StringBuilder temp = new StringBuilder();
				for (int j = 0; j < cur_multi; j++) {
					temp.append(res);
				}
				res = new StringBuilder(pre_res).append(temp);
			}
		}

		return res.toString();
	}

}
