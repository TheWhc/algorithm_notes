package 贪心;

/**
 * @ClassName: _738_单调递增的数字
 * @Author: whc
 * @Date: 2021/04/15/0:47
 */
public class _738_单调递增的数字 {
	/*public int monotoneIncreasingDigits(int N) {
		// 暴力法
		// 时间复杂度O(n * m)  m为n的数字长度
		for (int i = N; i >= 0; i--) {
			if(checkNum(i)) {
				return i;
			}
		}
		return 0;
	}

	private boolean checkNum(int n) {
		int max = 10;
		while(n > 0) {
			int t = n % 10;
			if(max >= t) {
				max = t;
			} else {
				return false;
			}
			n /= 10;
		}
		return true;
	}*/



	/**
	 * 思路: 贪心
	 * 局部最优: 遇到nums[i-1] > nums[i]的时候, nums[i-1]--, nums[i]变为9
	 *
	 * 比如10
	 *
	 * 1. 从后往前遍历, 如果遇到nums[i-1] > nums[i], 那么nums[i-1]--
	 * 2. 用start标记记录从哪个位置开始赋值9操作
	 */
	public int monotoneIncreasingDigits(int n) {

		char[] chars = Integer.toString(n).toCharArray();

		int start = chars.length; // 记录从哪个位置开始赋值9

		for (int i = chars.length - 1; i >= 1; i--) {
			if(chars[i-1] > chars[i]) {
				chars[i-1]--;
				start = i;
			}
		}

		for (int i = start; i < chars.length; i++) {
			chars[i] = '9';
		}

		return Integer.parseInt(new String(chars));
	}

	public static void main(String[] args) {
		_738_单调递增的数字 _738_单调递增的数字 = new _738_单调递增的数字();
		_738_单调递增的数字.monotoneIncreasingDigits(10);
	}

}
