package 贪心;

/**
 * @ClassName: _45_跳跃游戏_II
 * @Author: whc
 * @Date: 2021/04/12/9:39
 */
public class _45_跳跃游戏_II {
	// 2 3 1   1 4   2 1
	//     end   end
//  maxP=2  maxP=4  maxP=8
	/*public int jump(int[] nums) {
		int end = 0; // 我们遇到的绳子中能爬的最高的那根的位置
		int maxPosition = 0; // 上一次换绳子的最高位置
		int steps = 0; // 更换绳子的次数
		// 注意是nums.length-1,少了末尾,如果刚好到达了最后,不必换绳子了
		for (int i = 0; i < nums.length-1; i++) {
			// 减少更换次数,每次遇到一个绳子挑选一个能爬的最远的给它系上一个红丝带
			maxPosition = Math.max(maxPosition, nums[i] + i);
			// 上一次更换绳子后只能爬到这里了,必须更换绳子
			if(i == end) {
				// 选择最远的绳子
				end = maxPosition;
				// 更换次数+1
				steps++;
			}
		}
		return steps;
	}*/

	/**
	 * 思路: 贪心
	 * 局部最优: 当前可移动距离尽可能多走,如果还没到终点,步数再加1
	 * 整体最优: 一步尽可能多走,从而达到最小步数
	 *
	 * 从覆盖范围出发,以最小的步数增加覆盖范围,覆盖范围一旦覆盖了终点,得到的就是最小步数
	 *
	 */
	/*public int jump(int[] nums) {

		// 记录跳跃次数
		int count = 0;
		// 当前的覆盖最大区域
		int curDistance = 0;
		// 最大的覆盖区域
		int maxDistance = 0;

		for (int i = 0; i < nums.length; i++) {
			// 在可覆盖范围内更新最大的覆盖范围
			maxDistance = Math.max(maxDistance, nums[i] + i);

			// 说明当前一步,再跳一步就到达了末尾
			if(maxDistance >= nums.length - 1) {

			}
		}
	}*/

	/**
	 * 思路: 贪心
	 *
	 * 局部最优: 每一步跳到最远的距离
	 * 整体最优: 一步尽可能多走,从而达到最小步数
	 *
	 * 跳完一次,就更新下一次起跳点的范围,在新的起跳点范围内跳,更新能跳到的最远距离
	 *
	 * 1. 第一次跳跃时, 在区间[start,end]计算出最远的距离,作为下次起跳点范围的结束位置
	 * 2. 第二次跳跃时, 仍在区间[start,end]计算出最远的距离
	 * 	  start = 上一次跳跃的终点位置 + 1,  start = end + 1
	 * 	  end = 上一次跳跃中能够到达的最远距离, end = maxPos
	 * 	  [start,end] = [end+1, maxPos]
	 *
	 * 例子: [2,3,0,1,4]
	 * 第一次跳跃: 下标为0作为起点跳, 最远距离(下标2)
	 * 第二次跳跃: 下标为1作为起跳点开始的格子, 下标为2作为起跳点结束的格子, 最远距离(下标4)
	 * 第二次跳跃结束时, start = 3, end = 4, 结束循环, 返回结果步数
	 */
	/*public int jump(int[] nums) {
		if(nums.length == 1) {
			return 0;
		}

		// 返回结果步数
		int ans = 0;

		// 每一次跳跃的起跳点范围的开始格子
		int start = 0;

		// 每一次跳跃的起跳点范围的结束格子
		int end = 0;
		for (int k = 0; k < nums.length; k++) {
			// 记录每一次跳跃的最远距离
			int maxPos = 0;

			for (int i = start; i <= end; i++) {
				// 能跳到最远的距离
				maxPos = Math.max(maxPos, i + nums[i]);
			}

			start = end + 1; // 下一次起跳点范围开始的格子
			end = maxPos; // 下一次起跳点范围结束的格子
			ans++;

			// 到达终点,直接结束
			if(end >= nums.length - 1) {
				break;
			}
		}

		return ans;
	}*/

	// 优化
	public int jump(int[] nums) {
		if(nums.length == 1) {
			return 0;
		}

		// 返回结果步数
		int ans = 0;

		// 每一次跳跃的起跳点范围的结束格子
		int end = 0;

		// 记录每一次跳跃的最远距离
		int maxPos = 0;
		for (int k = 0; k < nums.length; k++) {
			// 能跳到最远的距离
			maxPos = Math.max(maxPos, k + nums[k]);

			if(k == end) {
				end = maxPos; // 下一次起跳点范围结束的格子
				ans++;
			}

			// 到达终点,直接结束
			if(end >= nums.length - 1) {
				break;
			}
		}

		return ans;
	}


}
