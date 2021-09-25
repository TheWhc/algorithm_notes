package wz._2021_8_27;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @ClassName: _01_
 * @Author: whc
 * @Date: 2021/09/22/22:01
 */
public class _01_ {

	/**
	 * 题目描述：
	 *
	 * 从公元a年1月到公元b年12月有多少个月份满足该月的第一天是星期一。
	 *
	 * 输入描述  两个正整数满足1900<=a<=b<=2100
	 * 输出描述  输出公元a年1月到公元b年12月有多少个月份满足该月的第一天是星期一。
	 * 样例输入  2021 2021
	 * 样例输出  3
	 * 提示  2021年1月1日是星期五。2021年的二月，三月和十一月都满足条件。
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int res = 0;
		for (int i = a; i <= b; i++) {
			res += help(i);
		}
		System.out.println(res);
	}

	private static int help(int year) {
		int res = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		for (int i = 0; i < 12; i++) {
			calendar.set(Calendar.MONTH, i);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			int day = calendar.get(Calendar.DAY_OF_WEEK);
			if(day == 2) {
				res++;
			}
		}

		return res;
	}
}
