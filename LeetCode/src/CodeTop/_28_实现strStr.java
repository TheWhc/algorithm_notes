package CodeTop;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.Writer;

/**
 * @ClassName: _28_实现strStr
 * @Author: whc
 * @Date: 2021/09/06/23:28
 */
public class _28_实现strStr {

	public int strStr(String haystack, String needle) {
		if(needle == null || needle.length() == 0) {
			return 0;
		}
		int[] next = new int[needle.length()];
		getNext(next, needle);

		int j = 0;
		for (int i = 0; i < haystack.length(); i++) {
			while(j > 0 && needle.charAt(j) != haystack.charAt(i)) {
				j = next[j-1];
			}

			if(haystack.charAt(i) == needle.charAt(j)) {
				j++;
			}

			if(j == needle.length()) {
				return i - j + 1;
			}
		}

		return -1;
	}

	private void getNext(int[] next, String s) {

		// 1. 初始化
		int j = 0;
		next[0] = 0;

		for (int i = 1; i < s.length(); i++) {
			// 2. 处理前后缀不相同的情况
			while(j > 0 && s.charAt(i) != s.charAt(j)) {
				j = next[j-1];
			}

			// 3. 处理前后缀相同的情况
			if(s.charAt(i) == s.charAt(j)) {
				j++;
			}

			next[i] = j;
		}
	}


	public static int getInt() {
		int a = 10;
		try {
			System.out.println(a / 0);
			a = 20;
		} catch (ArithmeticException e) {
			a = 30;
			return a;
		} finally {
			a = 40;
			System.out.println(a);
		}

		return a;
	}

}
