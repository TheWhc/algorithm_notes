package CodeTop;

/**
 * @ClassName: _9_回文数
 * @Author: whc
 * @Date: 2021/08/31/21:31
 */
public class _9_回文数 {

	/*public boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}

		String num = String.valueOf(x);
		int left = 0;
		int right = num.length() - 1;

		while(left < right) {
			if(num.charAt(left) !=  num.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}*/

	/*public boolean isPalindrome(int x) {
		if(x < 0) {
			return false;
		}

		int num = x;
		int cur = 0;
		while(num > 0) {
			cur = cur * 10 + num % 10;
			num /= 10;
		}

		return cur == x;
	}*/

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		int cur = 0;
		int num = x;
		while(num > 0) {
			cur = cur * 10 + num % 10;
			num /= 10;
		}

		return cur == x;
	}
}
