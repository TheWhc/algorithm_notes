package 贪心.子序列问题.连续;

/**
 * @ClassName: _53_最大子序和
 * @Author: whc
 * @Date: 2021/06/15/14:42
 */
public class _53_最大子序和 {

	/**
	 *  思路: 贪心
	 *  遍历数组,如果出现sumOfChild < 0, 则开始重新计算连续子序和
	 *  注意sumOfChild要写在第一步进行判断,这样当出现[-2,-1,-4]时, 每次重新计算连续子序和, 都能把当前元素纳入计算范围
	 *
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	public int maxSubArray(int[] nums) {
		int sumOfChild = nums[0];

		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if(sumOfChild < 0) {
				sumOfChild = 0;
			}
			sumOfChild += nums[i];
			res = Math.max(res, sumOfChild);
		}

		return res;
	}

}
