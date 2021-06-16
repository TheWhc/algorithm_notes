package 双指针法;

/**
 * @ClassName: _392_判断子序列
 * @Author: whc
 * @Date: 2021/06/16/9:38
 */
public class _392_判断子序列 {

	/**
	 *	思路: 双指针法
	 *  1. 指针i指向s, 指向j指向t
	 *  2. 不断移动指针j,一直遍历到结束,除非i指针已到达s末尾
	 *  3. 若指针i和指针j指向的字符匹配时,则i++
	 *
	 *  时间: O(n+m)
	 *  空间: O(1)
	 */
	public boolean isSubsequence(String s, String t) {
		int n = s.length();
		int m = t.length();

		int i = 0;
		int j = 0;

		while(i < n && j < m) {
			if(s.charAt(i) == t.charAt(j)) {
				i++;
			}
			if(i == s.length()) {
				break;
			}
			j++;
		}

		return i == n;
	}

}
