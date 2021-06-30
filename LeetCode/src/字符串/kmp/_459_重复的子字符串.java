package 字符串.kmp;

/**
 * @ClassName: _459_重复的子字符串
 * @Author: whc
 * @Date: 2021/06/30/10:20
 */
public class _459_重复的子字符串 {

	/**
	 * 思路: KMP算法
	 * 1. 构造前缀表, 即next数组
	 * 2. 利用前缀表的最后一个位置的值,如果不等于0,则说明为最长相同前后缀,
	 * 用数组长度减去最长相同的前后缀长度相当于是第一个周期的长度,如果这个周期可以被整除,
	 * 则说明整个数组是这个周期的循环
	 *
	 * 时间: O(n)
	 * 空间: O(n)
	 */
	public boolean repeatedSubstringPattern(String s) {
		if(s.length() == 0) {
			return false;
		}

		int[] next = new int[s.length()];
		getNext(next, s);

		// 数组长度减去最长的相同前后缀的长度相当于是第一个周期的长度
		// 如果这个周期可以被整除,则说明整个数组是这个周期的循环
		if(next[s.length()-1] != 0 && s.length() % (s.length() - next[s.length()-1]) == 0) {
			return true;
		}

		return false;
	}

	/**
	 * 构造前缀表
	 * 1. 初始化
	 * 2. 处理前后缀不相同的情况
	 * 3. 处理前后缀相同的情况
	 */
	private void getNext(int[] next, String s) {
		// 1. 初始化
		int j = 0;
		next[0] = j;

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
}
