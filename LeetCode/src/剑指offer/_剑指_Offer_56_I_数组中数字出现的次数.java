package 剑指offer;

/**
 * @ClassName: _剑指_Offer_56_I_数组中数字出现的次数
 * @Author: whc
 * @Date: 2021/06/06/11:27
 */
public class _剑指_Offer_56_I_数组中数字出现的次数 {

	/**
	 *  思路: 分组位运算
	 *
	 *  1. 遍历nums进行异或运算, 比如4 4 3 3 1 7 最后异或结果为1和7
	 *  2. 循环左移计算m, 因为1和7肯定有一个二进制位不相同,将m与第一步异或结果进行与运算,结果为0时(二进制位相同),就左移m,直到不为0为止(二进制位不相同)
	 *  3. 拆分nums为两个子数组, 根据第二步计算m的结果, 与num进行与运算,结果为0的划分为一个数组,不为0的划分为另一个数字,这样1和7就被划分到不同的数组中了
	 *  4. 对拆分出来的数组进行异或运算,这样4 4 1结果为1, 3 3 7结果为7
	 *
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	public int[] singleNumbers(int[] nums) {
		int x = 0, y = 0;
		int m = 1;
		int z = 0;
		for (int num : nums) {
			z ^= num;
		}

		// z = x ^ y
		while((z & m) == 0)  {
			m <<= 1;
		}

		for (int num : nums) {
			if((num & m) == 0) {
				x ^= num;
			} else {
				y ^= num;
			}
		}

		return new int[]{x, y};
	}
}
