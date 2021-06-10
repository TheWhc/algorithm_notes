package bilibili;

import java.util.Scanner;

/**
 * @ClassName: _01_英文句子单词翻转
 * @Author: whc
 * @Date: 2021/03/07/0:37
 */
public class _01_英文句子单词翻转 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sequence = sc.nextLine();
		String[] words = sequence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length-1; i>=1; i--) {
			sb.append(words[i] + " ");
		}
		sb.append(words[0]);
		System.out.println(sb.toString());
	}
}
