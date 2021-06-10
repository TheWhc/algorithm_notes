package wy;

import java.util.Scanner;

/**
 * @ClassName: _WY4_炮台攻击
 * @Author: whc
 * @Date: 2021/03/11/0:42
 */
public class _WY4_炮台攻击 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int R = sc.nextInt();
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			int x0 = sc.nextInt();
			int y0 = sc.nextInt();
			int result = 0;
			if (R >= length(x1, y1, x0, y0)) {
				result++;
			}
			if (R >= length(x2, y2, x0, y0)) {
				result++;
			}
			if (R >= length(x3, y3, x0, y0)) {
				result++;
			}
			System.out.println(result + "x");
		}
	}

	private static double length(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x2-x1) * (x2-x1)+ (y2-y1) * (y2-y1));
	}
}
