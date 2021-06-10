package 双指针法;

import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName: 待分类._151_翻转字符串里的单词
 * @Author: whc
 * @Date: 2021/04/26/10:12
 */
public class _151_翻转字符串里的单词 {
	/*public static String reverseWords(String s) {
		s = s.trim();
		String[] strings = s.split(" +");
		Collections.reverse(Arrays.asList(strings));
		return String.join(" ", strings);
	}*/

	public static void main(String[] args) {
		_151_翻转字符串里的单词 a = new _151_翻转字符串里的单词();
		System.out.println(a.reverseWords("a good  example"));
	}

	public static String reverseWords(String s) {
		if(s == null || s.length() == 0) return "";

		// 1. 对字符串数组进行整体翻转
		char[] s_arr = s.toCharArray();
		// a good  example
		// elpmax  good a
		reverse(s_arr, 0, s_arr.length-1);
		System.out.println(new String(s_arr));

		// 2. 对单词进行翻转
		reverse_word(s_arr, s_arr.length);
		System.out.println(new String(s_arr));

		// 3. 去除多余空格
		return remove_space(s_arr, s_arr.length);
	}

	private static String remove_space(char[] s_arr, int n) {
		int i = 0;
		int j = 0;
		while(j < n) {
			// 去除首部空格
			while(j < n && s_arr[j] == ' ') {
				j++;
			}
			while(j < n && s_arr[j] != ' ') {
				s_arr[i++] = s_arr[j++];
			}
			// 去除中间多余空格
			while(j < n && s_arr[j] == ' ') {
				j++;
			}
			// 中间多余空格只加一个, 并且如果是尾部有多余空格的话,则不添加
			if(j < n) {
				s_arr[i++] = ' ';
			}
		}
		return String.valueOf(s_arr, 0, i);
	}

	private static void reverse_word(char[] s_arr, int n) {
		int i = 0;
		int j = 0;
		while(j < n) {
			// 找到第一个字母
			while(i < n && s_arr[i] == ' ') {
				i++;
			}
			j = i;
			// 末位置
			while(j < n && s_arr[j] != ' ') {
				j++;
			}
			reverse(s_arr, i, j-1);
			i = j;
		}
	}

	private static void reverse(char[] s_arr, int i, int j) {
		while(i < j) {
			char temp = s_arr[i];
			s_arr[i] = s_arr[j];
			s_arr[j] = temp;
			i++;
			j--;
		}
	}


}
