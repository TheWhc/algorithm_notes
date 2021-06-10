package 双指针法;

/**
 * @ClassName: 剑指offer._剑指_Offer_05_替换空格
 * @Author: whc
 * @Date: 2021/04/26/9:15
 */
public class _剑指_Offer_05_替换空格 {
/*
	public String replaceSpace(String s) {
		if(s == null || s.length() == 0) {
			return "";
		}
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

	// 双指针法
	public static String replaceSpace(String s) {
		if(s == null || s.length() == 0) return "";

		int size = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				size++;
			}
		}

		char[] chars = new char[s.length() + size * 2];
		// i指向旧字符串末尾, j指向新字符串末尾
		for (int i = s.length()-1, j = chars.length-1; i >= 0; i--, j--) {
			if(s.charAt(i) == ' ') {
				chars[j] = '0';
				chars[j-1] = '2';
				chars[j-2] = '%';
				j -= 2;
			} else {
				chars[j] = s.charAt(i);
			}
		}

		return String.valueOf(chars);
	}

	public static void main(String[] args) {
		System.out.println(replaceSpace("We are happy."));
	}

}
