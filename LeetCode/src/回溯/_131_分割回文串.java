package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _131_分割回文串
 * @Author: whc
 * @Date: 2021/04/28/13:32
 */
public class _131_分割回文串 {

	public static void main(String[] args) {
		_131_分割回文串 a = new _131_分割回文串();
		a.partition("aab");
	}

	List<List<String>> res = new ArrayList<>();
	public List<List<String>> partition(String s) {
		List<String> path = new ArrayList<>();
		backtrack(path, s, 0);
		return res;
	}

	private void backtrack(List<String> path, String s, int startIndex) {
		if(startIndex >= s.length()) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < s.length(); i++) {
			if(isPalindrome(s, startIndex, i)) {
				// 获取[startIndex, i]字符串
				path.add(s.substring(startIndex, i+1));
			} else {
				continue;
			}
			backtrack(path, s, i+1);
			path.remove(path.size()-1);
		}
	}

	// 判断是否是回文
	private boolean isPalindrome(String s, int start, int end) {
		while(start < end) {
			if(s.charAt(start) == s.charAt(end)) {
				start++;
				 end--;
			} else {
				return false;
			}
		}
		return true;
	}
}
