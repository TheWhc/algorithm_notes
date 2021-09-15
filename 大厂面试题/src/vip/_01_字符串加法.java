package vip;

import java.util.Scanner;

/**
 * @ClassName: _01_字符串加法
 * @Author: whc
 * @Date: 2021/09/15/20:26
 */
public class _01_字符串加法 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		int len1 = s1.length()-1;
		int len2 = s2.length()-1;
		int a1 = 0;
		int a2 = 0;
		int cnt = 0;
		for(int i = len1; i >= 0; i--) {
			if(s1.charAt(i) == '1') {
				a1 += Math.pow(2, cnt);
			}
			cnt++;
		}
		cnt = 0;
		for(int i = len2; i>= 0; i--) {
			if(s2.charAt(i) == '1') {
				a2 += Math.pow(2, cnt);
			}
			cnt++;
		}

		System.out.println(Integer.toBinaryString(a1 + a2));
	}
}
