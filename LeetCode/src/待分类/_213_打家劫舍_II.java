package 待分类;

/**
 * @ClassName: 待分类._213_打家劫舍_II
 * @Author: whc
 * @Date: 2021/04/10/12:06
 */
public class _213_打家劫舍_II {

	/*
	思路: 搜索两次,第一次不加尾,第二次不加头,取最大即可
	 */
	public int rob(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);

		int n = nums.length;
		int[] dp1 = new int[n];
		dp1[0] = nums[0];
		dp1[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n-1; i++) {
			dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
		}

		int[] dp2 = new int[n];
		dp2[1] = nums[1];
		dp2[2] = Math.max(nums[1], nums[2]);
		for (int i = 2; i < n; i++) {
			dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
		}

		return Math.max(dp1[n-2], dp2[n-1]);
	}
}
