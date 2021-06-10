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


	// 贪心
	// 策略: 局部最优: 遇到nums[i-1] > nums[i]的时候, nums[i-1]--, nums[i]变为9
	// 从后往前遍历
	public static void main(String[] args) {
		monotoneIncreasingDigits(332);
	}
	public static int monotoneIncreasingDigits(int N) {
		char[] nums = Integer.toString(N).toCharArray();

		// 用一个flag来标记从哪里开始赋值9
		int flag = nums.length;

		for (int i = nums.length-1; i > 0; i--) {
			if(nums[i-1] > nums[i]) {
				nums[i-1] -= 1;
				flag = i;
				nums[i] = '9';
			}
		}

		for (int i = flag; i < nums.length; i++) {
			nums[i] = '9';
		}

		return Integer.parseInt(new String(nums));
	}
}
