package wz._2021_9_10;

import java.util.Scanner;

/**
 * @ClassName: _01_
 * @Author: whc
 * @Date: 2021/09/22/20:27
 */
public class _01_ {

	/**
	 * 题目描述:
	 * x^3 + y^4 + z^5 = k,是否有解
	 */
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0) {
			long k = sc.nextLong();
			boolean flag = false;
			for (long i = 1; i < k; i++) {
				if(i * i * i > k) {
					break;
				}
				for (long j = 1; j < k; j++) {
					if(i * i * i + j * j * j * j > k) {
						break;
					}

					for (long l = 1; l < k; l++) {
						if(i * i * i + j * j * j * j + l * l * l * l * l == k) {
							flag = true;
							break;
						} else if(i * i * i + j * j * j * j + l * l * l * l * l> k) {
							break;
						}
					}

					if(flag) {
						break;
					}
				}
				if(flag) {
					break;
				}
			}
			if(flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			t--;
		}
	}
}
