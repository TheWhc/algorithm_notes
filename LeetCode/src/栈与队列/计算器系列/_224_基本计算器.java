package 栈与队列.计算器系列;

import java.util.*;

/**
 * @ClassName: _224_基本计算器
 * @Author: whc
 * @Date: 2021/07/17/23:54
 */
public class _224_基本计算器 {

	/**
	 * 思路: 中缀转后缀,计算后缀表达式的值
	 *
	 * 1. 比如 "(1+(4+5+2)-3)+(6+8)"的中缀表达式先转化为后缀表达式,过程如下:
	 * - 如果遇到数字,直接将数字输出到后缀表达式,用队列存储输出的数字
	 * 在遇到数字的时候,还要判断后面是否还是数字,我们的队列存储的是一个完整的数字
	 * - 如果遇到左括号,则入栈
	 * - 如果遇到右括号,不带输出栈顶元素,直到遇到左括号为止(左括号出栈,但不输出)
	 * - 如果遇到其它字符,不断去除所有运算优先级大于等于当前运算符的运算符,输出,最后,新的符号入栈
	 * 			比如遇到+,-,栈中含有+,-符号的时候,就要出栈
	 * - 最后,吧栈中剩下的符号依次输出,表达式转换结束
	 * （整个过程,左括号和右括号都没有进入栈）
	 *
	 * 2. 接下来是计算后缀表达式的值
	 *
	 * 同样需要一个栈存储元素,只不过存储的是数字,用来存放中间结果
	 *
	 * 过程如下:
	 * - 遍历后缀表达式,即遍历存储的队列
	 * - 一开始栈中存储0,为了避免出现-1+3情况,减号缺少左操作数
	 * - 如果弹出的是数字,则压入栈中
	 * - 如果弹出的是操作符号,则弹出栈的两个数字,进行对应的计算,然后入栈
	 * - 遍历结束后,栈中只剩下最后一个元素,就是我们的结果
	 *
	 * 注意一点:
	 * 由于将所有数字视为正数，所以负号看成操作符，但如果类似"-1+3"或"1+(-1+2)"类似的表达式，会有问题，
	 * 因为减号缺少左操作数，所以我们可以事先在操作数栈中压入一个0，既不影响大小，也解决了特例。
	 *
	 */
	public int calculate(String s) {

		Stack<Character> stack = new Stack<>(); // 存储运算符
		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < s.length();) {
			if(s.charAt(i) == ' ') {
				i++;
				continue;
			} else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				// 入队的时候,判断后面是否还有剩余的数字,如果有,则要吧整个数字入队
				int p = i;
				while(p < s.length() && isDigital(s.charAt(p))) {
					p++;
				}
				queue.offer(s.substring(i, p));
				i = p;
			} else {
				// 遇到符号的时候,将栈顶中比当前运算符优先级的符号出栈,直到栈为空或者栈顶符号为左括号时
				// 遇到左括号,入栈
				if(s.charAt(i) == '(') {
					stack.push(s.charAt(i));
				} else if(s.charAt(i) == ')') {
					// 遇到右括号,不断输出栈元素,直到遇到左括号为止
					while(!stack.isEmpty() && stack.peek() != '(') {
						queue.offer(stack.pop() + "");
					}
					stack.pop();
				} else {
					// 遇到+或者-符号,去除所有运算优先级大于等于当前运算符的运算符,输出
					while(!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')) {
						queue.offer(stack.pop() + "");
					}
					stack.push(s.charAt(i));
				}
				i++;
			}
		}

		while(!stack.isEmpty()) {
			queue.offer(stack.pop() + "");
		}

		// 计算中缀表达式的值
		Stack<Integer> numStack = new Stack<>(); // 存储数字的值
		numStack.push(0);
		while(!queue.isEmpty()) {
			String str = queue.poll();
			// 如果是数字,则入栈
			if(isDigital(str.charAt(0))) {
				numStack.push(Integer.parseInt(str));
			} else {
				// 如果是运算符
				int num1 = numStack.pop();
				int num2 = numStack.pop();
				if(str.equals("+")) {
					numStack.push(num1 + num2);
				} else {
					numStack.push(num2 - num1);
				}
			}
		}

		return numStack.pop();
	}

	private boolean isDigital(char c) {
		return c >= '0' && c <= '9';
	}

	public static void main(String[] args) {
		_224_基本计算器 _224_基本计算器 = new _224_基本计算器();
		System.out.println(_224_基本计算器.calculate("1 + 1"));
	}

}
