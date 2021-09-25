package wz._2021_8_27;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: _03_
 * @Author: whc
 * @Date: 2021/09/22/23:36
 */
public class _03_ {

	/**
	 * 题目:有一个大胃王，他的食量每天都会增加，第一天他只吃1单位的食物，但是第二天就会吃2单位，
	 * 第三天就会吃3单位，以此类推，第i天吃i单位食物。
	 *
	 * 输入描述
	 * 输入第一行是一个正整数n，表示鸡的数量。(1<=n<=50000)
	 * 接下来一行有n个正整数，分别表示这n只鸡的重量。
	 * 输出描述
	 * 输出仅包含一个正整数，即大胃王暴怒的时间点。
	 * 样例输入  6  1 3 3 3 4 4
	 * 样例输出  5
	 *
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int idx = 0;
		int need = 1;
		while(idx < n) {
			if (arr[idx] >= need) {
				idx++;
				need++;
			}
			else {
				idx++;
			}
		}
		System.out.println(need);
	}
}
