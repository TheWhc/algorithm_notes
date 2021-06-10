package wy;

import java.util.Scanner;

/**
 * @ClassName: _数对_
 * @Author: whc
 * @Date: 2021/03/26/15:32
 */
public class _数对_ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int	n = sc.nextInt();
		int k = sc.nextInt();
		int nums = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i <= n && j <= n && i % j >= k) {
					nums++;
				}
			}
		}

		System.out.println(nums);
	}
}
