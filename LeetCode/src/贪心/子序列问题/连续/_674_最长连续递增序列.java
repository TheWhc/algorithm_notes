package 贪心.子序列问题.连续;

/**
 * @ClassName: _674_最长连续递增序列
 * @Author: whc
 * @Date: 2021/06/15/13:43
 */
public class _674_最长连续递增序列 {

	/**
	 *  思路: 贪心
	 *  1. 遍历数组,统计连续增长的子序列长度
	 *  2. 一旦遇到不连续的元素,则重新开始统计
	 *
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	public int findLengthOfLCIS(int[] nums) {
		int res = 1;
		int lenOfChild = 1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > nums[i-1]) {
				lenOfChild++;
			} else {
				// 重新开始统计
				lenOfChild = 1;
			}
			res = Math.max(res, lenOfChild);
		}
		return res;
	}
}
