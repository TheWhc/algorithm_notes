package 贪心;

/**
 * @ClassName: _55_跳跃游戏
 * @Author: whc
 * @Date: 2021/04/12/9:26
 */
public class _55_跳跃游戏 {

	/**
	 * 思路: 贪心
	 * 局部最优: 每次取最大跳跃步数(取最大覆盖范围)
	 * 整体最优: 最后得到整体最大覆盖范围,看是否能到达终点
	 *
	 * 例子: [2,3,1,1,4]
	 * i = 0时, coverRange = 2
	 * i = 1时, coverRange = 4, return true
	 *
	 *  [3,2,1,0,4]
	 * i = 0时, coverRange = 3
	 * i = 1时, coverRange = 3
	 * i = 2时, coverRange = 3
	 * i = 3时, coverRange = 3
	 *
	 * return false
	 *
	 */
	public boolean canJump(int[] nums) {
		// 覆盖范围
		int coverRange = 0;

		// 在覆盖范围内更新最大的覆盖范围
		for (int i = 0; i <= coverRange; i++) {
			coverRange = Math.max(nums[i] + i, coverRange);

			if(coverRange >= nums.length - 1) {
				return true;
			}
		}

		return false;
	}
}
