package cvte;

/**
 * @ClassName: _10_跳跃游戏
 * @Author: whc
 * @Date: 2021/10/01/12:37
 */
public class _10_跳跃游戏 {

	// 思路: 在最大跳跃范围内跳跃, 每次取最大跳跃范围
	public boolean canJump(int[] nums) {
		int coverRange = 0;

		for (int i = 0; i <= coverRange; i++) {
			coverRange = Math.max(coverRange, nums[i] + i);
			if(coverRange >= nums.length-1) {
				return true;
			}
		}

		return false;
	}
}
