package cvte;

import java.util.Scanner;

/**
 * @ClassName: _06_求n的阶乘末尾0的个数
 * @Author: whc
 * @Date: 2021/10/01/10:46
 */
public class _06_求n的阶乘末尾0的个数 {

	// 思路：统计因子2和因子5的个数
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()) {
			System.out.println(getZeroInFactorial(sc.nextInt()));
		}
	}

	private static int getZeroInFactorial(int n) {
		int count2 = 0;
		int count5 = 0;
		for (int i = 2; i <= n; i++) {
			int j = i;
			while(j % 2 == 0) {
				count2++;
				j /= 2;
			}

			while(j % 5 == 0) {
				count5++;
				j /= 5;
			}
		}

		return Math.min(count2, count5);
	}
}
