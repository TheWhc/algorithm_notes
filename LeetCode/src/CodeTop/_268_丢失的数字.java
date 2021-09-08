package CodeTop;

/**
 * @ClassName: _268_丢失的数字
 * @Author: whc
 * @Date: 2021/09/03/23:42
 */
public class _268_丢失的数字 {

	// 异或运算

	/**
	 * 例子:
	 * 元素: 3 0 1
	 * 下标: 0 1 2
	 *
	 * 3 ^ 0 ^ 1 ^ 0 ^ 1 ^ 2 ^ 3 = 2
	 */
	/*public int missingNumber(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res ^= nums[i];
			res ^= i;
		}

		return res;
	}*/

	// 求和运算
	public int missingNumber(int[] nums) {
		int sum = 0;
		sum = (1 + nums.length) * nums.length / 2;

		for (int num : nums) {
			sum -= num;
		}

		return sum;
	}
}
