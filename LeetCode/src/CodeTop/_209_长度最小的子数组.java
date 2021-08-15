package CodeTop;

/**
 * @ClassName: _209_长度最小的子数组
 * @Author: whc
 * @Date: 2021/08/01/13:26
 */
public class _209_长度最小的子数组 {

	public int minSubArrayLen(int target, int[] nums) {
		int left = 0;
		int right = 0;

		int sum = 0;
		int minLen = Integer.MAX_VALUE;

		while(right < nums.length) {
			sum += nums[right];
			while(sum >= target) {
				minLen = Math.min(minLen, right - left + 1);
				sum -= nums[left];
				left++;
			}
			right++;
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}
