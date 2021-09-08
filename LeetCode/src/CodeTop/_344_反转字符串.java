package CodeTop;

/**
 * @ClassName: _344_反转字符串
 * @Author: whc
 * @Date: 2021/09/08/21:31
 */
public class _344_反转字符串 {

	public void reverseString(char[] s) {
		if(s == null || s.length == 0) {
			return;
		}

		int left = 0;
		int right = s.length - 1;
		while(left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}
}
