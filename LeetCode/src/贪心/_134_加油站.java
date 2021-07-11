package 贪心;

/**
 * @ClassName: _134_加油站
 * @Author: whc
 * @Date: 2021/04/12/13:02
 */
public class _134_加油站 {

	/**
	 * 思路: 贪心
	 * 局部最优：累加每个剩余量,如果遇到当前位置的i对应的累加量curSum < 0,那么起始位置要从i+1开始
	 * 全局最优: 找到可以跑一圈的起始位置
	 *
	 * 1. totalSum记录总油量-总消耗量,如果最后的剩余量 < 0, 那么返回-1, 表示没有符合条件
	 * 2. 在curSum累加的过程中,如果遇到curSum < 0, 那么起始位置要从当前位置后面一个开始重新计算, start = i + 1, curSum = 0
	 *
	 * 时间: O(n)
	 * 空间: O(1)
	 */
	/*public int canCompleteCircuit(int[] gas, int[] cost) {

		int curSum = 0;
		int totalSum = 0;
		int start = 0;

		for (int i = 0; i < gas.length; i++) {

			curSum += gas[i] - cost[i];
			totalSum += gas[i] - cost[i];

			// 当前累加量 < 0时, 则说明
			if(curSum < 0) {
				start = i + 1;
				curSum = 0;
			}
		}

		if(totalSum < 0) {
			return -1;
		}

		return start;
	}*/

	/**
	 * 思路: 暴力枚举法
	 *
	 * 1. 枚举所有的起点
	 * 2. 按照【油量 & 成本】模拟一遍,看是否能走完一圈
	 *
	 * 共有n个起点,检查某个起点合法性的复杂度是O(n),整体时间复杂度为O(n^2)
	 *
	 * 时间： O(n^2)
	 * 空间: O(1)
	 *
	 */
	/*public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;

		// 枚举每个起点
		for (int start = 0; start < n; start++) {

			// 直接跳过不满足的起点
			if(gas[start] < cost[start]) {
				continue;
			}

			// 当前start作为起点的剩余油量
			int cur = gas[start] - cost[start];

			// 以当前start作为起点出发,下一个点下标为idx
			int idx = (start + 1) % n;

			// 走完一圈,回到start
			while(idx != start) {
				cur += gas[idx] - cost[idx];
				// 剩余油量为负数,说明无法离开当前位置,结束循环,开始走到下一个位置
				if(cur < 0) {
					break;
				}
				// 走一步
				idx = (idx + 1) % n;
			}

			// 当前start位置出发满足条件
			if(idx == start) {
				return start;
			}
		}

		return -1;
	}*/

	/**
	 *		* * * * * *
	 * 		^     ^
	 * 		i     j
	 * 	i+1到j之间的节点都不可能绕一圈了,所以这次不符合的话,下一次就从j+1开始出发
	 *
	 * 	证明: 假设i+1能绕一圈,那么i+1能够到达j+1, 而i能到达i+1,所以从i也能到达j+1
	 * 	但事实上,i最远到达j,产生了矛盾,所以i+1的节点一定不能绕一圈,同理其它也是
	 *
	 *
	 * //j最远距离绕到了之前，所以 i 后边的都不可能绕一圈了,直接返回-1
	 *		* * * * * *
	 * 		^     ^
	 * 		j     i
	 *
	 *
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;

		for (int i = 0; i < n; i++) {
			int j = i;
			int remain = gas[i];

			while(remain- cost[j] >= 0) {
				// 减去花费的加上新的点的补给
				remain = remain - cost[j] + gas[(j + 1) % n];
				j = (j + 1) % n;
				// j 回到了 i
				if(j == i) {
					return i;
				}
			}

			// 最远距离绕到了之前,所以i后边的都不可能绕一圈了
			if(j < i) {
				return -1;
			}

			// i直接跳到了j,外层for循环执行i++,相当于从j+1开始考虑
			i = j;
		}
		return -1;
	}

}
