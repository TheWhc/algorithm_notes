package 待分类;

import java.util.*;

/**
 * @ClassName: 待分类._字符_
 * @Author: whc
 * @Date: 2021/04/01/19:01
 */
public class _字符_ {

	//给定一个字符串单词数组String[] words = ["abcd","dbac","abc","cba","bca"],
	// 找出字符相同但顺序不同的单词并换行输出。
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String words = sc.nextLine();
		String[] s = words.split(",");
		Arrays.sort(s, (o1, o2) -> {
			int length1 = o1.length();
			int length2 = o2.length();
			return length2 - length1;
		});

		List<List<String>> res = new ArrayList<>();
		int len = s[0].length();
		List<String> tmp = new ArrayList<>();
		for (String s1 : s) {
			if(s1.length() != len) {
				len = s1.length();
				res.add(tmp);
				tmp = new ArrayList<>();
			} else {
				tmp.add(s1);
			}
		}
		res.add(tmp);
		System.out.println(res);
	}
}
