package wy;

import java.util.Scanner;

/**
 * @ClassName: _WY3_小易的升级之路
 * @Author: whc
 * @Date: 2021/03/10/23:29
 */
public class _WY3_小易的升级之路 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt(); // 怪物数
			int a = sc.nextInt(); // 能力值
			int[] b = new int[n]; // 怪物数防御力
			for (int i = 0; i < n; i++) {
				b[i] = sc.nextInt();
				if(a >= b[i]) {
					a += b[i];
				} else {
					a += fun(a, b[i]);
				}
			}
			System.out.println(a);
		}

	}

	// 辗转相除法求最大公约数
	private static int fun(int m, int n) {
		int rem; // 余数

		//先用较小的数对较大的数取余，再用余数对较小的数求余，直到余数为零
		while(n != 0) {
			rem = m % n;
			m = n;
			n = rem;
		}
		return m; // 将结果返回
	}
}
