package 双指针法.首尾双指针;

/**
 * @ClassName: _977_有序数组的平方
 * @Author: whc
 * @Date: 2021/07/03/19:26
 */
public class _977_有序数组的平方 {

	/**
	 * 思路: 双指针法
	 * 1. 数组平方的最大值是在数组的两端,不是最左就是最右, 不可能是中间
	 * 2. 定义指针i指向最左边, j指针指向最右边, k指向新数组的下标
	 *
	 * 时间: O(n)
	 * 空间：O(n)
	 */
	public int[] sortedSquares(int[] nums) {
		int i = 0;
		int j = nums.length-1;

		int[] res = new int[nums.length];
		// 指向新数组的下标
		int k = nums.length-1;

		while(i <= j) {
			if(nums[i] * nums[i] < nums[j] * nums[j]) {
				res[k--] = nums[j] * nums[j];
				j--;
			} else {
				res[k--] = nums[i] * nums[i];
				i++;
			}
		}

		return res;
	}
}
