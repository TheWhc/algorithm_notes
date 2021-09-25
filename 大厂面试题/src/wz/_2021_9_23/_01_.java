package wz._2021_9_23;

import java.util.Scanner;

/**
 * @ClassName: _01_
 * @Author: whc
 * @Date: 2021/09/23/20:29
 */
public class _01_ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int[] res = new int[n];
		res[0] = arr[0];
		if(n == 1) {
			System.out.println(res[0]);
			return;
		}
		res[1] = res[0] - arr[1];
		if(n == 2) {
			System.out.println(res[0] + " " + res[1]);
			return;
		}
		int ji = res[0], ou = res[1];
		for (int i = 2; i < n; i++) {
			if((i+1) % 2 != 0) {
				// 当前是奇数
				res[i] = arr[i] - ji + ou;
				ji += res[i];
			} else {
				// 当前是偶数
				res[i] = ji - ou - arr[i];
				ou += res[i];
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(res[i] + " ");
		}
	}
}
