package CodeTop;

/**
 * @ClassName: _55_跳跃游戏
 * @Author: whc
 * @Date: 2021/09/11/19:41
 */
public class _55_跳跃游戏 {

	/**
	 * 思路： 贪心
	 * 每次取最大跳跃步数(最大覆盖范围)
	 */
	public boolean canJump(int[] nums) {
		int coverRange = 0;

		// 在覆盖范围内更新最大的覆盖范围
		for (int i = 0; i <= coverRange; i++) {
			coverRange = Math.max(nums[i] + i, coverRange);
			if(coverRange >= nums.length-1) {
				return true;
			}
		}

		return false;
	}
}
