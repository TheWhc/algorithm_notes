package 回溯.其它;

import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName: _473_火柴拼正方形
 * @Author: whc
 * @Date: 2021/06/26/14:23
 */
public class _473_火柴拼正方形 {

	/**
	 * 思路: 回溯法
	 *
	 * 可以看成是固定个数的固定容量的水桶的接水问题。对于例子[1, 1, 2, 2, 2]，按从大到小排列变成[2, 2, 2, 1, 1]。
	 * 正方形的四条边抽象成四个水桶，每个水桶的容量为2，超过容量就会溢出。
	 * nums[0] = 2，用第一个桶装，刚刚好装满；
	 * nums[1] = 2，用第一个桶装，发现2 + 2 = 4 > 2，那么就用第二个桶装，第二个桶也装满；
	 * nums[2] = 2，用第一个和第二个 桶都装不下，用第三个桶装，那么第三个桶也装满；
	 * nums[3] = 1，只能用第四个桶装，但没装满；
	 * nums[4] = 1，也只能用第四个桶装， 第四个桶也装满了。
	 * 四个桶都恰好装满表示能构成正方形。
	 *
	 * 1. 确定递归函数返回值下标的含义
	 *  boolean backtrack(int[] matchsticks, int target, int startIndex, boolean[] used, int[] size)
	 *  返回值为boolean,一旦满足条件就立即结果true
	 *  matchsticks
	 *  target 正方形的边长
	 *  startIndex 当前火柴的位置
	 *  used 去重用的数组
	 *  size 保存正方形4个边的数组
	 *
	 *  2. 回溯终止条件
	 *  即4个桶刚好装满时,此时火柴的位置刚好到达数组长度的大小,火柴用完肯定是正好4边相等的
	 *  if(startIndex == matchsticks.length) {
	 * 	// 火柴都访问完了,size的4个边的长度相等,直接返回true
	 * 		return true;
	 *  }
	 *
	 *  3. 单层回溯逻辑
	 *	从0开始遍历到4,即遍历每个桶
	 *
	 */
	/*public boolean makesquare(int[] matchsticks) {
		int sum = 0;
		for (int matchstick : matchsticks) {
			sum += matchstick;
		}

		if(sum == 0 || sum % 4 != 0) {
			return false;
		}

		// 升序排序
		Arrays.sort(matchsticks);
		// 降序排序
		for (int i = 0, j = matchsticks.length-1; i < j; i++, j--) {
			int temp = matchsticks[i];
			matchsticks[i] = matchsticks[j];
			matchsticks[j] = temp;
		}

		boolean[] used = new boolean[matchsticks.length];
		return backtrack(matchsticks, sum / 4, 0, used, new int[4]);
	}

	*//**
	 *
	 * @param matchsticks
	 * @param target 正方形的边长
	 * @param startIndex 当前火柴的位置
	 * @param used 去重用的数组
	 * @param size 长度为4的数组
	 * @return
	 *//*
	private boolean backtrack(int[] matchsticks, int target, int startIndex, boolean[] used, int[] size) {
		if(startIndex == matchsticks.length) {
			// 火柴都访问完了,size的4个边的长度相等,直接返回true
			return true;
		}

		// 桶还没装满时
		for (int i = 0; i < 4; i++) {

			// 去重,比如[1,1,2,2,2] 当遍历到下标3的时候,前一个元素和它相等,则当前元素不必再遍历了
			// - used[startIndex-1] == false: 同一树层matchsticks[i-1]使用过
			if(startIndex > 0 && matchsticks[startIndex] == matchsticks[startIndex-1] && !used[startIndex-1]) {
				continue;
			}

			// 当前桶还没装满时,进入回溯,否则就开始装下一个桶,注意等于时也进入
			if(size[i] + matchsticks[startIndex] <= target) {
				// 将当前火柴放到size[i]边上,长度不大于target,就放上面,比如[1,1,2,2,2]时先放入1,后面遍历到第二个1时,继续放到0号桶
				size[i] += matchsticks[startIndex];
				used[startIndex] = true;
				// 进入回溯, 火柴的下标+1, 如果为true,立即返回,否则,进行撤销回溯
				if(backtrack(matchsticks, target, startIndex+1, used, size)) {
					return true;
				}
				// 撤销选择
				size[i] -= matchsticks[startIndex];
				used[startIndex] =false;
			}//else {
			// 填充下一个桶
			//}
		}

		// 不能构成正方形
		return false;

	}*/


	public boolean makesquare(int[] matchsticks) {
		int sum = 0;
		for (int matchstick : matchsticks) {
			sum += matchstick;
		}

		if(sum == 0 || sum % 4 != 0) {
			return false;
		}

		// 升序排序
		Arrays.sort(matchsticks);
		// 降序排序
		for (int i = 0, j = matchsticks.length-1; i < j; i++, j--) {
			int temp = matchsticks[i];
			matchsticks[i] = matchsticks[j];
			matchsticks[j] = temp;
		}

		return backtrack(matchsticks, sum / 4, 0, new int[4]);
	}

	/**
	 *
	 * @param matchsticks
	 * @param target 正方形的边长
	 * @param startIndex 当前火柴的位置
	 * @param size 长度为4的数组
	 * @return
	 */
	private boolean backtrack(int[] matchsticks, int target, int startIndex, int[] size) {
		if(startIndex == matchsticks.length) {
			// 火柴都访问完了,size的4个边的长度相等,直接返回true
			return true;
		}

		// 桶还没装满时
		for (int i = 0; i < 4; i++) {
			// 当前桶还没装满时,进入回溯,否则就开始装下一个桶,注意等于时也进入
			if(size[i] + matchsticks[startIndex] <= target) {
				// 将当前火柴放到size[i]边上,长度不大于target,就放上面,比如[1,1,2,2,2]时先放入1,后面遍历到第二个1时,继续放到0号桶
				size[i] += matchsticks[startIndex];
				// 进入回溯, 火柴的下标+1, 如果为true,立即返回,否则,进行撤销回溯
				if(backtrack(matchsticks, target, startIndex+1, size)) {
					return true;
				} else {
					// 撤销选择
					// 剪枝
					// 当size[i] = 0 时, 某根火柴放入第i个桶时,size[i] += 火柴长度, 然后backtrack失败, size[i] -= 火柴长度 == 0, 则后面的桶无需循环遍历了,直接返回false
					size[i] -= matchsticks[startIndex];
					if(size[i] == 0) {
						return false;
					}
				}
			} // else {
			//   继续装下一个桶
			// }
		}

		// 不能构成正方形
		return false;
	}
}
