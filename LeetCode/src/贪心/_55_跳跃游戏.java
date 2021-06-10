package 贪心;

/**
 * @ClassName: _55_跳跃游戏
 * @Author: whc
 * @Date: 2021/04/12/9:26
 */
public class _55_跳跃游戏 {
	// 贪心
	// 每次取最大跳跃步数(最大覆盖范围) -> 局部最优推出整体最优
	public boolean canJump(int[] nums) {
		if(nums.length <= 1) {
			return true;
		}
		int cover = 0;
		for (int i = 0; i <= cover; i++) {
			cover = Math.max(cover, nums[i] + i);
			if(cover >= nums.length-1) {
				return true;
			}
		}

		return false;
	}
}
