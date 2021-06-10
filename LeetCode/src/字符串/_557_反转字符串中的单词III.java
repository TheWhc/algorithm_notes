package 字符串;

/**
 * @ClassName: _557_反转字符串中的单词III
 * @Author: whc
 * @Date: 2021/05/05/10:57
 */
public class _557_反转字符串中的单词III {

	/*public String reverseWords(String s) {
		String[] newString = s.split(" ");
		StringBuffer sb = new StringBuffer();
		for (String word : newString) {
			sb.append(reverse(word, 0, word.length()-1) + " ");
		}
		return sb.toString().substring(0, sb.length()-1);
	}

	private String reverse(String word, int i, int j) {
		char[] chars = word.toCharArray();
		while(i < j) {
			char c = chars[i];
			chars[i] = chars[j];
			chars[j] = c;
			i++;
			j--;
		}
		return new String(chars);
	}*/

	public String reverseWords(String s) {
		StringBuffer res = new StringBuffer();
		int i = 0;
		int len = s.length();
		while(i < len) {
			int start = i;
			while(i < len && s.charAt(i) != ' ') {
				i++;
			}
			int end = i;
			String substring = s.substring(start, end);
			res.append(new StringBuffer(substring).reverse().toString());
			res.append(' ');
			i++;
		}
		return res.toString().substring(0, res.length()-1);
	}
}
