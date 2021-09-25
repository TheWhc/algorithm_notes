package wz._2021_8_27;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: _02_
 * @Author: whc
 * @Date: 2021/09/23/8:37
 */
public class _02_ {


	/*
	第 i 行有 i 个数，位置居中对齐。
	显然，除了最后一行的点，每个点的下方都有两个点与它相邻，本题并不是关于三角形数的问题，而是与这个性质有关。
	给你若干个点，按照上图中的方式排列（保证排满，即点的个数是三角形数）。
	你一开始位于第一行的点，身上带有一个数 1。
	然后你要一行一行地往下走，每一步可以走到下方两个相邻点中的一个，走 n-1 步可到达终点（底部）。
	除了第一行的点以外，每个点上带有一个效果，它可能是如下几种中的一种：
	+ x：使你身上的数加 x
	- x：使你身上的数减 x
	/ x：使你身上的数除以 x，向远离0的方向取整，正数向上，负数向下
	s：如果的身上的数为正数，则开平方根，向上取整。如果为负数，则取相反数，进行如上操作，再取相反数，如 8 经过 s 操作为 3，-8 则变为 -3。
	n：使你身上的数变为它的相反数，即乘 -1  显然，从起点到一个点的路径并不一定是唯一的，到这个点时身上的值也不一定唯一。
	你的任务是计算以最后一行的每个点为终点时，可能的最大值和最小值
	输入描述  第一行一个正数 n，表示三角形的层数。(n <= 400)  后面 n*(n+1)-1 行，
	每行有 “+ x” “- x” “/ x” “s” “n” 中的一种，运算符和数之间有一个空格，作用详见问题描述，
	按从上到下，从左到右的顺序表示除第一行以外的各点上的效果。(0 < x <= 1000000000)
	输出描述
	 两行，每行 n 个整数，用空格隔开。
	第一行依次表示最后一行从左到右各点作为终点时的最大值。
	第二行依次表示最后一行从左到右各点作为终点时的最小值。
	样例输入
	 3  + 2  n  / 2  - 5  s
	样例输出  2 -2 -1  2 -6 -1
	*/
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(in.nextLine());
		if (n == 0) {
			System.out.println();
			System.out.println();
			return;
		}
		long[] resMax = new long[]{1};
		long[] resMin = new long[]{1};
		for (int i = 1; i < n; i++) {
			long[] resMax1 = new long[i + 1];
			long[] resMin1 = new long[i + 1];
			Arrays.fill(resMax1, Long.MIN_VALUE);
			Arrays.fill(resMin1, Long.MAX_VALUE);
			String[] strs = new String[i + 1];
			strs[0] = in.nextLine();
			for (int j = 1; j <= i; j++) {
				strs[j] = in.nextLine();

				long num1 = help(resMax[j - 1], strs[j - 1]);
				long num2 = help(resMin[j - 1], strs[j - 1]);
				resMax1[j - 1] = Math.max(Math.max(resMax1[j - 1], num1), num2);
				resMin1[j - 1] = Math.min(Math.min(resMin1[j - 1], num1), num2);

				num1 = help(resMax[j - 1], strs[j]);
				num2 = help(resMin[j - 1], strs[j]);
				resMax1[j] = Math.max(Math.max(resMax1[j], num1), num2);
				resMin1[j] = Math.min(Math.min(resMin1[j], num1), num2);
			}
			resMax = resMax1;
			resMin = resMin1;
		}
		for (int i = 0; i < resMax.length; i++) {
			if (i == resMax.length - 1) {
				out.println(resMax[i]);
			} else {
				out.print(resMax[i] + " ");
			}
		}
		for (int i = 0; i < resMin.length; i++) {
			if (i == resMin.length - 1) {
				out.println(resMin[i]);
			} else {
				out.print(resMin[i] + " ");
			}
		}
		out.flush();
		out.close();
	}

	public static long help(long num, String str) {
		if (str.equals("s")) {
			if (num < 0) {
				return (long) Math.ceil(Math.sqrt(num * -1)) * -1;
			} else {
				return (long) Math.ceil(Math.sqrt(num));
			}
		} else if (str.equals("n")) {
			return num * -1;
		} else {
			String[] strs = str.split("\\s");
			if (strs[0].equals("+")) {
				return num + Integer.parseInt(strs[1]);
			} else if (strs[0].equals("-")) {
				return num - Integer.parseInt(strs[1]);
			} else {
				if (num < 0) {
					return (long) Math.floor(num / (Integer.parseInt(strs[1]) * 1.0));
				} else {
					return (long) Math.ceil(num / (Integer.parseInt(strs[1]) * 1.0));
				}
			}
		}
	}
}
