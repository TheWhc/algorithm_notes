package 字符串;

/**
 * @ClassName: _剑指_Offer_58_II左旋转字符串
 * @Author: whc
 * @Date: 2021/06/30/11:01
 */
public class _剑指_Offer_58_II左旋转字符串 {

	/**
	 * 思路: 利用StringBuilder拼接字符串
	 */
	/*public String reverseLeftWords(String s, int n) {
		StringBuilder res = new StringBuilder();
		res.append(s, n, s.length());
		res.append(s, 0, n);
		return res.toString();
	}*/

	/**
	 * 思路: 利用StringBuilder拼接字符串
	 */
	public String reverseLeftWords(String s, int n) {
		StringBuilder res = new StringBuilder();
		for (int i = n; i < n + s.length(); i++) {
			res.append(s.charAt(i));
		}
		return res.toString();
	}
}
