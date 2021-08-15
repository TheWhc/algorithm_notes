package CodeTop;

/**
 * @ClassName: _7_整数反转
 * @Author: whc
 * @Date: 2021/07/28/10:21
 */
public class _7_整数反转 {

	/*public int reverse(int x) {
		String xStr = String.valueOf(x);
		char[] xChars = xStr.toCharArray();
		int begin = 0;
		int end = xChars.length;
		int left = 0;
		int flag = 1;
		if(xChars[0] == '-') {
			left++;
			flag = -1;
		} else if(xChars[0] == '+') {
			left++;
		}
		begin = left;
		int right = xChars.length-1;
		while(left < right) {
			char temp = xChars[left];
			xChars[left] = xChars[right];
			xChars[right] = temp;
			left++;
			right--;
		}

		int sum = 0;
		for (int i = begin; i < end; i++) {
			if(sum == Integer.MIN_VALUE / 10 && (xChars[i] - '0') < Integer.MIN_VALUE % 10 ||
			sum < Integer.MIN_VALUE / 10) {
				return 0;
			}

			if(sum == Integer.MAX_VALUE / 10 && (xChars[i] - '0') > Integer.MAX_VALUE % 10 ||
			sum > Integer.MAX_VALUE / 10) {
				return 0;
			}
			sum = sum * 10 + flag * (xChars[i] - '0');
		}

		return flag * Integer.valueOf(String.valueOf(xChars, begin, end - begin));
	}*/

	public int reverse(int x) {
		long n = 0; // 64位
		while(x != 0) {
			n = n * 10 + x % 10;
			x = x / 10;
		}

		return (int)n == n ? (int)n : 0;
	}

	public static void main(String[] args) {
		_7_整数反转 _7_整数反转 = new _7_整数反转();
		System.out.println(_7_整数反转.reverse(1534236469));
	}
}
