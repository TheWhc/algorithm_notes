package 字符串;

/**
 * @ClassName: _541_反转字符串II
 * @Author: whc
 * @Date: 2021/05/05/10:24
 */
public class _541_反转字符串II {

	public String reverseStr(String s, int k) {
		char[] chars = s.toCharArray();
		int i = 0;
		int j = 0;
		for (int start = 0; start < s.length(); start += 2 * k) {
			i = start;
			j = Math.min(i+k-1, s.length()-1);
			while(i < j) {
				char c = chars[i];
				chars[i] = chars[j];
				chars[j] = c;
				i++;
				j--;
			}
		}
		return new String(chars);
	}
}
