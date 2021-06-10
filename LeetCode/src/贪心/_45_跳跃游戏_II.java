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
	public int jump(int[] nums) {
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
	}
}
