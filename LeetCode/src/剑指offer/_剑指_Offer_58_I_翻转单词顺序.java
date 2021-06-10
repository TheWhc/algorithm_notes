package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_58_I_翻转单词顺序
 * @Author: whc
 * @Date: 2021/04/02/18:02
 */
public class _剑指_Offer_58_I_翻转单词顺序 {

	/**
	 *  思路: 用StringBuilder拼接拆分后的字符串
	 *  1. 从后往前添加字符串
	 *  2. 遇到空字符串时,跳过
	 *  3. 最后利用trim()函数去除拼接出来多余的" "
	 */
	public String reverseWords(String s) {
		String[] strs = s.split(" ");
		StringBuilder res = new StringBuilder();
		for(int i = strs.length-1; i >= 0; i--) {
			if(strs[i].equals("")) {
				continue;
			}
			res.append(strs[i] + " ");
		}
		return res.toString().trim();
	}

}
