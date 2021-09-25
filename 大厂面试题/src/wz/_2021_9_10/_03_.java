package wz._2021_9_10;

import java.util.Scanner;

/**
 * @ClassName: _03_
 * @Author: whc
 * @Date: 2021/09/22/21:31
 */
public class _03_ {

	/**
	 * 题目描述： 前缀序列
	 *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] B = new int[n];
		for (int i = 0; i < n; i++) {
			B[i] = sc.nextInt();
		}

		int[] A = new int[n];
		A[0] = B[0];
		for (int i = 1; i < n; i++) {
			int fac = i % 2 == 0 ? 1 : -1;
			A[i] = (B[i] - B[i-1]) * fac;
		}

		for (int num : A) {
			System.out.println(num + " ");
		}
	}
}
