package 字符串;

/**
 * @ClassName: _344_反转字符串
 * @Author: whc
 * @Date: 2021/05/05/10:18
 */
public class _344_反转字符串 {

	public void reverseString(char[] s) {
		int i = 0;
		int j = s.length-1;
		while(i < j) {
			char c = s[i];
			s[i] = s[j];
			s[j] = c;
			i++;
			j--;
		}
	}

}
