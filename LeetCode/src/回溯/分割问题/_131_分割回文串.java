package 回溯.分割问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _131_分割回文串
 * @Author: whc
 * @Date: 2021/06/18/14:42
 */
public class _131_分割回文串 {

	/**
	 *  思路: 回溯
	 *
	 * 1. 递归函数的返回值以及参数
	 * 	  定义两个全局变量, 一个是存放符合条件的单一结果, 一个用来存放符合条件结果的集合
	 *
	 * 	  backtrack(String s, int startIndex)
	 * 	  s: 选择列表
	 * 	  startIndex: 用于记录本层递归中,集合从哪里开始遍历
	 *
	 * 2. 回溯函数终止条件
	 * 	  targetSum == s.length() 时,保存起来,结束本层递归
	 *
	 * 3. 单层搜索的过程
	 * 	  for循环每次从startIndex开始,如果满足回文子串的条件,则进入下一层递归
	 *
	 */
	List<List<String>> res = new ArrayList<>();
	List<String> path = new ArrayList<>();

	public List<List<String>> partition(String s) {
		backtrack(s, 0);
		return res;
	}

	private void backtrack(String s, int startIndex) {
		if(startIndex == s.length()) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < s.length(); i++) {
			String substring = s.substring(startIndex, i + 1);
			// 是回文子串
			if(isPalindrome(substring)) {
				path.add(substring);
				backtrack(s, i+1);
				path.remove(path.size()-1);
			}
		}
	}

	// 判断是否是回文串
	private boolean isPalindrome(String substring) {
		int left = 0;
		int right = substring.length()-1;
		while(left < right) {
			if(substring.charAt(left) == substring.charAt(right)) {
				left++;
				right--;
			} else {
				break;
			}
		}
		return left >= right;
	}

}
