package top100;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName: _621_任务调度器
 * @Author: whc
 * @Date: 2021/05/21/9:51
 */
public class _621_任务调度器 {

	/**
	 *  思路: n代表冷却时间, maxTimes为出现最多次数的字符, maxCount为相同次数的字符个数
	 *
	 *  比如tasks[A,A,A,B,B,B] n=2
	 *  {maxCount}
	 *  A 	B     冷却
	 *  A   B 	  冷却
	 *  A   B
	 *
	 *  纵坐标 maxTimes = 3
	 *  横坐标 n + 1
	 *  maxCount = 2
	 *  所以面积 = (maxTimes - 1) * (n + 1) + maxCount
	 *
	 *  特殊情况,如果冷却时间为0,又或者任务次数多,则不需要冷却填充面积了,所以比较 上述公式面积 与 tasks.length 返回最大值即可
	 */
	/*public int leastInterval(char[] tasks, int n) {
		int[] buckets = new int[26];
		for (int i = 0; i < tasks.length; i++) {
			buckets[tasks[i] - 'A']++;
		}
		Arrays.sort(buckets);
		int maxTimes = buckets[25];
		int maxCount = 1;
		for (int i = 25; i >= 1; i--) {
			if(buckets[i] == buckets[i-1]) {
				maxCount++;
			} else {
				break;
			}
		}
		int res = Math.max(tasks.length, (maxTimes - 1) * (n + 1) + maxCount);
		return res;
	}*/


}
