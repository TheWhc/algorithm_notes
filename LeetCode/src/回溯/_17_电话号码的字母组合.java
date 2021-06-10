package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: _17_电话号码的字母组合
 * @Author: whc
 * @Date: 2021/04/16/11:27
 */
public class _17_电话号码的字母组合 {

	/*public static void main(String[] args) {
		new _17_电话号码的字母组合().letterCombinations("23");
	}

	private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	List<String> res = new ArrayList<>();
	StringBuffer sb = new StringBuffer(); // 路径

	public List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() == 0) {
			return res;
		}
		backtrack(digits, 0);
		return res;
	}

	private void backtrack(String digits, int index) {
		if(sb.length() == digits.length()) {
			res.add(sb.toString());
			return;
		}

		// 例子: digits="23" index=0
		// digits.charAt(0) = 2
		// map[2] = abc
		// digits.charAt(index) - '0' = 2
		for (int i = 0; i < map[digits.charAt(index) - '0'].length(); i++) {
			sb.append(map[digits.charAt(index) - '0'].charAt(i));
			backtrack(digits, index+1);
			sb.deleteCharAt(sb.length()-1);
		}
	}*/

	public static void main(String[] args) {
		_17_电话号码的字母组合 a = new _17_电话号码的字母组合();
		a.letterCombinations("23");
	}

	List<String> res = new ArrayList<>();
	String[] map = new String[]{"","","abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() == 0) {
			return res;
		}

		StringBuffer path = new StringBuffer();
		backtrack(path, digits, 0);
		return res;
	}

	private void backtrack(StringBuffer path, String digits, int startIndex) {
		if(path.length() == digits.length()) {
			res.add(path.toString());
			return;
		}

		String letters = map[digits.charAt(startIndex) - '0'];
		for (int i = 0; i < letters.length(); i++) {
			path.append(letters.charAt(i));
			backtrack(path, digits, startIndex+1);
			path.deleteCharAt(path.length()-1);
		}
	}

}
