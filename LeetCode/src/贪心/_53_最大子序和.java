package 贪心;

/**
 * @ClassName: 待分类._53_最大子序和
 * @Author: whc
 * @Date: 2021/04/11/23:35
 */
public class _53_最大子序和 {

	// 贪心
	public int maxSubArray(int[] nums) {
		int res = nums[0];
		int sum = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if(sum < 0) {
				sum = 0;
			}
			sum += nums[i];
			res = Math.max(res, sum);
		}
		return res;
	}

}
