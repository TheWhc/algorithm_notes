package CodeTop;

/**
 * @ClassName: _125_验证回文串
 * @Author: whc
 * @Date: 2021/08/20/14:08
 */
public class _125_验证回文串 {

	public boolean isPalindrome(String s) {
		StringBuilder palindrome = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9' ||
					s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ||
			   		s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
					palindrome.append((char)((s.charAt(i) - 'A') + 'a'));
				} else {
					palindrome.append(s.charAt(i));
				}
			}
		}

		int l = 0;
		int r = palindrome.length()-1;
		while(l < r) {
			if(palindrome.charAt(l) != palindrome.charAt(r)) {
				return false;
			} else {
				l++;
				r--;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		_125_验证回文串 _125_验证回文串 = new _125_验证回文串();
		System.out.println(_125_验证回文串.isPalindrome("A man, a plan, a canal: Panama"));
	}

}
