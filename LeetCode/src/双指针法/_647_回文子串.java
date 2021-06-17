package 双指针法;

/**
 * @ClassName: _647_回文子串
 * @Author: whc
 * @Date: 2021/06/16/13:36
 */
public class _647_回文子串 {

	/**
	 *  思路: 双指针法(中心扩展)
	 *  1. 在遍历中心节点的时候,往两边扩散看是不是对称即可
	 *  2. 中心节点有两种情况:
	 *  	- 一个元素作为中心节点
	 *  	- 两个元素作为中心节点
	 *  	比如ababa
	 *  	a可以作为中心节点进行扩展,但是这样就无法得到abab,所以同样也要有两个元素作为中心节点
	 *  	ab作为中心节点,就可以得到abab了
	 *
	 *  3. 两种情况可以放在一起计算,或者分别计算,这里给出的是分别计算
	 *
	 *  时间: O(n^2)
	 *  空间: O(1)
	 *
	 */
	public int countSubstrings(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			// 一个元素作为中心节点
			res += extend(s, i, i);
			// 两个元素作为中心节点
			res += extend(s, i, i+1);
		}
		return res;
	}

	private int extend(String s, int left, int right) {
		int sum = 0;
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			sum++;
			left--;
			right++;
		}
		return sum;
	}
}
