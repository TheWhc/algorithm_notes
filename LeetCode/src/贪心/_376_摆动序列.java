package 贪心;

/**
 * @ClassName: _376_摆动序列
 * @Author: whc
 * @Date: 2021/04/11/21:54
 */
public class _376_摆动序列 {

	// 贪心
	// 策略: 只选择波峰 和 波谷
	// 当前数 == 前数: 什么都不做
	// 当前数 != 前数:
		// 1. 上轮趋势未知, 即摆动序列只有1个数时,第2个数无论大小都放
		// 2. 当前数 > 前数, 上轮趋势上升, 找到波谷
		// 3. 当前数 < 前数, 上轮趋势下降, 找到波峰
	public int wiggleMaxLength(int[] nums) {
		if(nums.length < 2) {
			return nums.length;
		}
		int res = 1;
		// 1表示向上趋势, 2表示向下趋势, 3表示相等趋势
		int up = 3;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > nums[i-1] && up != 1) {
				res++;
				up = 1;
			} else if(nums[i] < nums[i-1] && up != 2) {
				res++;
				up = 2;
			}
		}

		return res;
	}
}
