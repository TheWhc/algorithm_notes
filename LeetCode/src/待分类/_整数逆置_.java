package 待分类;

import java.util.Scanner;

/**
 * @ClassName: 待分类._整数逆置_
 * @Author: whc
 * @Date: 2021/04/01/18:34
 */
// Reverse digits of an integer.Example1: x = 123, return 321 Example2: x = -123, return -321
public class _整数逆置_ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int flag = x < 0 ? 1 : 0; // 标记是否为负数
		if(flag == 1) {
			x = -x;
		}
		int sum = 0;
		while(x > 0) {
			sum = sum * 10 + x % 10;
			x /= 10;
		}

		if(flag == 1) {
			sum = -sum;
		}
		System.out.println(sum);
	}
}
