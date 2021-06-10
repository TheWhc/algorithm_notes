package 贪心;

/**
 * @ClassName: _134_加油站
 * @Author: whc
 * @Date: 2021/04/12/13:02
 */
public class _134_加油站 {

	public static void main(String[] args) {
		canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2});
	}

	// 暴力解法: 时间O(n^2)
	/*public static int canCompleteCircuit(int[] gas, int[] cost) {
		int n = gas.length;
		// 考虑从每个点出发
		for (int i = 0; i < n; i++) {
			int j = i;
			int remain = gas[i];
			while(remain - cost[j] >= 0) {
				// 减去花费的油 + 新增的油
				remain = remain - cost[j] + gas[(j+1)%n];
				j = (j + 1) % n;
				// j回到了i
				if(j == i) {
					return i;
				}
			}
		}
		return -1;
	}*/

	// 优化 贪心算法
	// 局部最优: 当前累加rest[j]和curSum < 0, 起始位置至少要是j+1, 因为从j开始一定不行。
	// 全局最优: 找到可以跑一圈的起始位置
	// 时间O(n),空间O(1)
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int curSum = 0;
		int totalSum = 0;
		int start = 0;
		for (int i = 0; i < gas.length; i++) {
			curSum += gas[i] - cost[i];
			totalSum += gas[i] - cost[i];
			if(curSum < 0) {
				start = i+1;
				curSum = 0;
			}
		}
		// 如果总油量减去总消耗大于等于零那么一定可以跑完一圈
		// 说明各个站点的加油站 剩油量rest[i]相加一定是大于等于零的。
		if(totalSum < 0) return -1;

		return start;
	}
}
