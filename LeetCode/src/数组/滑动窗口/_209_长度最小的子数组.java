package 数组.滑动窗口;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @ClassName: _209_长度最小的子数组
 * @Author: whc
 * @Date: 2021/07/03/19:27
 */
public class _209_长度最小的子数组 {

	/**
	 * 思路: 滑动指针法
	 * 1. 设置left指向初始下标,right指向初始下标, 最小连续子数组长度minRes
	 * 2. 不断滑动right指针,直到sum >= target时停止
	 * 	  满足sum >= target情况下,不断滑动左指针,直到sum < target,滑动的时候更新最小连续子数组长度
	 * 3. 最后判断minRes是否等于MAX_VALUE,若等于,则没有找到合适的,返回0
	 *
	 * 时间: O(n)
	 * 空间: O(1)
	 *
	 * 滑动窗口解题思路:
	 * - 窗口内是什么?
	 * 窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
	 * - 如何移动窗口的起始位置？
	 * 窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
	 * - 如何移动窗口的结束位置?
	 * 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，窗口的起始位置设置为数组的起始位置就可以了。
	 */
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0; // 滑动窗口左指针(起始位置)
		int right = 0; // 滑动窗口右指针
		int sum = 0; // 滑动窗口之和
		int minRes = Integer.MAX_VALUE; // 滑动窗口的长度

		while(right < nums.length) {
			sum += nums[right];
			while(sum >= target) {
				minRes = Math.min(right - left + 1, minRes);
				sum -= nums[left];
				left++;
			}
			right++;
		}

		return (minRes == Integer.MAX_VALUE) ? 0 : minRes;
	}

}
