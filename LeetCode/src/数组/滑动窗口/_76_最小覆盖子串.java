package 数组.滑动窗口;

/**
 * @ClassName: _76_最小覆盖子串
 * @Author: whc
 * @Date: 2021/07/03/21:38
 */
public class _76_最小覆盖子串 {

	/**
	 * 思路: 滑动窗口
	 * 定义一个need数组,用来记录滑动窗口包含的数组元素
	 * 1. 不断增加right使滑动窗口增大,直到窗口包含了T的所有元素
	 * 2. 不断增加left使滑动窗口缩小,因为是要求最小字串,所以将不必要的元素排除在外,使长度减小,直到碰到一个必须
	 * 包含的元素(need[i] < 0时一直移动left),这个时候不能再移动left了,记录此时滑动窗口的长度,并保存最小值
	 */
	public String minWindow(String s, String t) {
		int[] need = new int[128];

		// 记录t需要的字符个数, 比如s="ADOBECODEBANC", t="ABC"
		// need[A:1, B:1, C:1]
		for (int i = 0; i < t.length(); i++) {
			need[t.charAt(i)]++;
		}

		// 滑动窗口左边界
		int left = 0;
		// 滑动窗口右边界
		int right = 0;
		int minSize = Integer.MAX_VALUE; // 最小窗口大小
		int count = t.length(); // 需求的字符个数
		int start = 0; // 最小窗口字符串的开始位置

		// 右指针一直滑动到整个数组完
		while(right < s.length()) {
			// 当前字符
			char c = s.charAt(right);
			if(need[c] > 0) { // 只有当need[c] > 0时, 则需要字符c, 比如当前字符是'A'
				count--;
			}

			need[c]--; // 把右边的字符加入窗口,  则need变为[A:0, B:1, C:1]

			// 满足条件时
			// 比如need[A:0,D:-1,O:-1,B:0,E:-1,C:0]
			if(count == 0) {
				// 开始移动左指针,直到遇到覆盖字符串的字符时
				while (left < right && need[s.charAt(left)] < 0) {
					need[s.charAt(left)]++;
					left++;
				}

				// 更新最小窗口值以及覆盖子串起始位置
				if(right - left + 1 < minSize) {
					minSize = Math.min(minSize, right - left + 1);
					start = left;
				}

				// 当前覆盖子串已完成,开始找下一个覆盖子串
				// 左指针向右移动,重新开始循环
				need[s.charAt(left)]++;
				left++;
				count++;
			}
			right++;
		}

		return minSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minSize);
	}

	public static void main(String[] args) {
		_76_最小覆盖子串 _76_最小覆盖子串 = new _76_最小覆盖子串();
		_76_最小覆盖子串.minWindow("ADOBECODEBANC", "ABC");
	}
}
