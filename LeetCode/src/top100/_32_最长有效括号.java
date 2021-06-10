package top100;

import java.util.Stack;

/**
 * @ClassName: _32_最长有效括号
 * @Author: whc
 * @Date: 2021/05/09/23:34
 */
public class _32_最长有效括号 {

	/**
	 *  思路: 利用栈
	 *  扫描到左括号, 左括号下标值入栈
	 *  扫描到右括号, 先出栈,然后分两种情况
	 *  	- 如果栈不为空,用当前位置减去栈顶的位置值,得到的值可能为最大的合法序列
	 *  	- 如果栈为空, 则存储当前右括号下标
	 *
	 *  时间复杂度: O(n)
	 *  额外空间: O(n)
	 */
	/*public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		// 初始化栈,方便第一个合法序列长度的计算
		stack.push(-1);
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if(!stack.isEmpty()) {
					max = Math.max(max, i - stack.peek());
				} else {
					stack.push(i);
				}
			}
		}
		return max;
	}*/


	/**
	 *  思路: 动态规划
	 */
	public int longestValidParentheses(String s) {
		// dp[i]表示以下标i结尾的合法序列的最长长度
		int[] dp = new int[s.length()];
		// 确定递推公式
		// 如果当前是左括号,dp[i] = 0
		// 如果当前是右括号, 分两种情况:
		// 第一种即前面是左括号, 则 dp[i] = dp[i-2] + 2
		// 第二种即前面是右括号, 则 判断 前一个合法序列的前面一个位置的字符(i-dp[i-1]-1)是否为左括号
			// 如果为右括号,则dp[i] = 0
			// 如果为左括号,则dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
		int max = 0;
		for (int i = 1; i < s.length(); i++) {
			if(s.charAt(i)  == '(') {
				continue;
			} else {
				if(s.charAt(i-1) == '(') {
					dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
				} else{
					if(i - dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '(') {
						dp[i] = dp[i-1] + ((i - dp[i-1] >= 2 ? dp[i-dp[i-1]-2] : 0)) + 2;
					} else {
						dp[i] = 0;
					}
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}
