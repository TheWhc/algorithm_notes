package CodeTop;

/**
 * @ClassName: _459_重复的子字符串
 * @Author: whc
 * @Date: 2021/09/05/23:49
 */
public class _459_重复的子字符串 {

	public boolean repeatedSubstringPattern(String s) {
		if(s.length() == 0) {
			return false;
		}

		// 前缀数组
		int[] next = new int[s.length()];
		getNext(next, s);

		if(next[s.length() - 1] > 0 && s.length() % (s.length() - next[s.length() - 1]) == 0 ) {
			return true;
		}
		return false;
	}

	/**
	 * 步骤：
	 * 1. 初始化
	 * 2. 处理前后缀不相同的情况
	 * 3. 处理前后缀相同的情况
	 */
	private void getNext(int[] next, String s) {
		int j = 0;
		next[0] = 0;

		for (int i = 1; i < s.length(); i++) {
			// 处理前后缀不相同的情况
			while(j > 0 && s.charAt(i) != s.charAt(j)) {
				j = next[j-1];
			}

			// 处理前后缀相同的情况
			if(s.charAt(i) == s.charAt(j)) {
				j++;
			}

			next[i] = j;
		}
	}

}
