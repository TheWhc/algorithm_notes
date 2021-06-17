package 双指针法;

/**
 * @ClassName: _5_最长回文子串
 * @Author: whc
 * @Date: 2021/06/17/12:07
 */
public class _5_最长回文子串 {

	/**
	 *  思路: 双指针法(中心扩展)
	 *
	 *  1. 在遍历中心节点的时候,往两边扩散看看是不是对称
	 *  2. 中心节点有两种情况:
	 *  	- 一个元素作为中心节点
	 *  	- 两个元素作为中心节点
	 *
	 *  3. 两种情况分别计算
	 *
	 *  时间: O(n^2)
	 *  空间: O(1)
	 */
	public String longestPalindrome(String s) {
		if(s.length() < 2) {
			return s;
		}

		int start = 0;
		int maxLen = 1;

		for (int i = 0; i < s.length(); i++) {
			int len1 = extend(s, i, i);
			int len2 = extend(s, i, i+1);
			int len = Math.max(len1, len2);
			if(len > maxLen) {
				maxLen = len;
				// 如果是cccc, 两个元素作为中心节点开始扩展的话,需要 start - (len -1)/2 , 即1 - (4-1)/2 = 0
				// 如果是ccc, 一个元素作为中心节点开始扩展的话, 也需要 start - (len -1)/2, 即1 - (3-1)/2 = 0;
				start = i - (len -1) / 2;
			}
		}

		return s.substring(start, start + maxLen);
	}

	private int extend(String s, int left, int right) {
		// 比如 a b a
		// left = 1, right = 1
		// 从b开始扩展, 最后返回长度: left = -1, right = 3, right - left - 1 = 3
		// 再比如 a b b a
		// 从b b两个元素开始扩展, 最后返回长度: left = -1, right = 3, right - left - 1 = 3
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

}
