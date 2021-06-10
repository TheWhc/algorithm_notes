package 双指针法;

/**
 * @ClassName: _344_反转字符串
 * @Author: whc
 * @Date: 2021/04/26/9:11
 */
public class _344_反转字符串 {

	public void reverseString(char[] s) {
		int i = 0;
		int j = s.length-1;
		while(i < j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}

}
