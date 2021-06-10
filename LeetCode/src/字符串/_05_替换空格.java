package 字符串;

/**
 * @ClassName: _05_替换空格
 * @Author: whc
 * @Date: 2021/05/05/11:41
 */
public class _05_替换空格 {

	/*public String replaceSpace(String s) {
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				res.append("%20");
			} else {
				res.append(s.charAt(i));
			}
		}
		return res.toString();
	}*/

	public String replaceSpace(String s) {
		if(s == null || s.length() == 0) return "";

		int blankNum = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				blankNum++;
			}
		}

		char[] chars = new char[s.length() + blankNum * 2];
		// i指向旧字符串末尾,j指向新字符串末尾
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
		char[] chars = {'w', 'h', 'c'};
		System.out.println(String.valueOf(chars));
		System.out.println(new String(chars));

	}
}
