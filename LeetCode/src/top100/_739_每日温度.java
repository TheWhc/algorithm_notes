package top100;

import java.util.Stack;

/**
 * @ClassName: _739_每日温度
 * @Author: whc
 * @Date: 2021/05/21/10:41
 */
public class _739_每日温度 {

	public static void main(String[] args) {
	}

	// 暴力双重循环
	// 时间: O(n^2)
	/*public int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			for (int j = i+1; j < T.length; j++) {
				if(T[j] > T[i]) {
					res[i] = j - i;
					break;
				}
			}
		}
		return res;
	}*/

	/**
	 * 优化,从后往前推
	 * 思路: 从最后一天推到第一天,最后一天不会再有升高的可能,结果为0
	 * 再看倒数第二天,如果比倒数第一天低,那么答案为1,如果比到倒数第一天高,又因为倒数第一天为0,所以倒数第二天为0
	 *
	 * 得出规律,求第i天对应的结果,只需要知道第i+1天对应的结果
	 * 若T[i] < T[i+1] ,那么res[i] = 1
	 * 若T[i] > T[i+1]
	 * 	- res[i+1] = 0,那么res[i] = 0
	 * 	- res[i+1] != 0, 比较T[i]和T[i+1+res[i]]
	 *
	 * 	例子:   73 74 75 71 69 72 76 73
	 * 	对应res  1  1  4  2  1  1  0  0
	 *
	 */
	/*public int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];
		// 最后一天一定为0
		// res[T.length-1] = 0
		for (int i = T.length-2; i >= 0; i--) {
			for (int j = i+1; j < T.length; j += res[j]) {
				if(T[i] < T[j]) {
					res[i] = j - i;
					break;
				} else if(res[j] == 0) {
					// T[i] >= T[i+1]
					// res[i+1] = 0
					res[i] = 0;
					break;
				}
			}
		}
		return res;
	}*/

	/**
	 * 思路: 单调栈: 用栈维护一个单调递增的栈
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
				res[stack.peek()] = i - stack.pop();
			}
			stack.push(i);
		}
		return res;
	}


}
