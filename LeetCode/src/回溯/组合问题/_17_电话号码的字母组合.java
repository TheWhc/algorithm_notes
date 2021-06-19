package 回溯.组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _17_电话号码的字母组合
 * @Author: whc
 * @Date: 2021/06/18/11:39
 */
public class _17_电话号码的字母组合 {

	/**
	 * 思路: 回溯法
	 * 1. 构建一个数组对应字母与数字之间的映射关系
	 *
	 * 2. 递归函数的返回值以及参数
	 * 	  定义两个全局变量, 一个是存放符合条件的单一结果, 一个用来存放符合条件结果的集合
	 *
	 * 	  函数参数(String digits, int startIndex)
	 * 	  digits: 每层选择列表
	 * 	  startIndex: 记录本层递归中, 当前遍历到了哪一个数字
	 *
	 * 3. 回溯函数终止条件
	 * 	  path大小等于digits大小, 保存到结果集, 结束本层递归
	 *
	 * 4. 递归函数每层for循环,从0开始遍历到每个数字映射的字符串的大小
	 *
	 *
	 * 时间: O(n * 2^n) 组合问题其实也是一种子集问题,所以时间复杂度不会超过子集的时间复杂度
	 * 空间: O(n)
	 */

	List<String> res = new ArrayList<>();
	StringBuilder path = new StringBuilder();
	String[] letterMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() == 0) {
			return res;
		}

		backtrack(digits, 0);

		return res;
	}

	private void backtrack(String digits, int startIndex) {
		if(path.length() == digits.length()) {
			res.add(new String(path.toString()));
			return;
		}

		// 比如digits = "23", startIndex = 0对应字符'2', 则第一层遍历从0开始遍历到第一个字符的'2'的字符串"abc"大小为3
		String letters = letterMap[digits.charAt(startIndex) - '0'];
		for (int i = 0; i < letters.length(); i++) {
			// 选择元素
			// "abc".charAt(0) = 'a'
			char c = letters.charAt(i);
			path.append(c);
			// 递归进入下一层 startIndex + 1 对应字符'3'
			backtrack(digits, startIndex + 1);
			path.deleteCharAt(path.length()-1);
		}
	}

}
