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
	/*public int wiggleMaxLength(int[] nums) {
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
	}*/


	/**
	 * 思路：贪心
	 * 局部最优：删除单调坡度上的节点（不包括单调坡度两端的节点），那么这个坡度就可以有两个局部峰值。
	 *			(其实并不需要真正删除)
	 * 整体最优：整个序列有最多的局部峰值，从而达到最长摆动序列。
	 */
	public int wiggleMaxLength(int[] nums) {
		int count = 1;

		// 上一个差值
		int preDiff = 0;
		// 当前差值
		int curDiff = 0;

		for (int i = 1; i < nums.length; i++) {
			// 得到当前差值
			curDiff = nums[i] - nums[i-1];
			// 如果当前差值和上一个差值为一正一负
			// 等于0的情况表示初始化时的preDiff
			if(curDiff > 0 && preDiff <= 0 || curDiff < 0 && preDiff >= 0) {
				count++;
				preDiff = curDiff;
			}
		}

		return count;
	}


	/**
	 * 思路: 动态规划
	 *
	 * 1. 递推公式
	 *  nums[i] > nums[i-1] => up = down + 1 , 表示此时是上升
	 *  nums[i] < nums[i-1] => down = up + 1 , 表示此时是下降
	 *  nums[i] == nums[i-1] 新的元素不用于任何序列,保持不变
	 *
	 *  最后返回Math.max(up,down)
	 *
	 *  2. 举例推导
	 *     [1,17,5,10,13,15,10,5,16,8]
	 *  下标 0 1  2  3 4  5  6  7 8  9
	 *  up  1 2  2  4 4  4  4  4 6  6
	 *  down1 1  3  3 3  3  5  5 5  7
	 *
	 */
	/*public int wiggleMaxLength(int[] nums) {

		int up = 1;
		int down = 1;

		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > nums[i-1]) {
				up = down + 1;
			} else if(nums[i] < nums[i-1]) {
				down = up + 1;
			}
		}

		return Math.max(up, down);
	}*/

	public static void main(String[] args) {
		_376_摆动序列 _376_摆动序列 = new _376_摆动序列();
		System.out.println(_376_摆动序列.wiggleMaxLength(new int[]{1, 17, 5, 10, 12, 15, 10, 5, 16, 8}));
	}

}
