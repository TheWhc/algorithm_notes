package 剑指offer;

/**
 * @ClassName: _剑指_Offer_58_II_左旋转字符串
 * @Author: whc
 * @Date: 2021/06/07/12:42
 */
public class _剑指_Offer_58_II_左旋转字符串 {

	/**
	 * 思路: 直接拼接法
	 * 时间: O(1)
	 * 空间: O(n)
	 */
	/*public String reverseLeftWords(String s, int n) {
		return s.substring(n) + s.substring(0, n);
	}*/

	/**
	 *  思路: 利用StringBuilder拼接每个字符
	 *  时间: O(1)
	 *  空间: O(n)
	 */
	public String reverseLeftWords(String s, int n) {
		StringBuilder res = new StringBuilder();
		for (int i = n; i < n + s.length(); i++) {
			res.append(s.charAt(i % s.length()));
		}
		return res.toString();
	}
}
