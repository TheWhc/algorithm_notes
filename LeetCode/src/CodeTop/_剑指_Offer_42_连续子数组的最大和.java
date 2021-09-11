package CodeTop;

/**
 * @ClassName: _剑指_Offer_42_连续子数组的最大和
 * @Author: whc
 * @Date: 2021/09/11/19:01
 */
public class _剑指_Offer_42_连续子数组的最大和 {

	public int maxSubArray(int[] nums) {
		int sum = nums[0];
		int maxRes = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(sum < 0) {
				sum = 0;
			}
			sum += nums[i];
			maxRes = Math.max(maxRes, sum);
		}
		return maxRes;
	}
}
