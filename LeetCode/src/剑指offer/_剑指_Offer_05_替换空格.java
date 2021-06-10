package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_05_替换空格
 * @Author: whc
 * @Date: 2021/04/01/23:44
 */
public class _剑指_Offer_05_替换空格 {

	// 2021/4/1 二刷
	/*public String replaceSpace(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(s.charAt(i));
			}
		}

		return sb.toString();
	}*/


	/**
	 * 思路: 遍历字符串,遇到空格,则添加%20
	 * 时间: O(n)
	 * 额外空间: O(n)
	 */
	public String replaceSpace(String s) {
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				res.append("%20");
			} else {
				res.append(s.charAt(i));
			}
		}
		return res.toString();
	}
}
