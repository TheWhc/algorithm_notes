package CodeTop;

/**
 * @ClassName: _680_验证回文字符串Ⅱ
 * @Author: whc
 * @Date: 2021/09/13/23:28
 */
public class _680_验证回文字符串Ⅱ {

	public boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length()-1;
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				return validPalindromeHelpers(s, left+1, right) ||
						validPalindromeHelpers(s, left, right-1);
			}
			left++;
			right--;
		}
		return true;
	}

	private boolean validPalindromeHelpers(String s, int left, int right) {
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
