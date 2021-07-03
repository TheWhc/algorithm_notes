package 数组.滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _904_水果成篮
 * @Author: whc
 * @Date: 2021/07/03/20:20
 */
public class _904_水果成篮 {

	/**
	 * 思路: 滑动指针法
	 * 1. 设置left指向初始下标,right指向初始下标
	 * 2. 不断滑动right指针,直到遍历完水果数组为止
	 * 	  满足map.size() <= 2情况下,不断滑动右指针,直到map.size() > 2时停止,开始滑动左指针
	 * 	  滑动左指针时,不断将元素的数量-1,直到元素的数量为0时, 移除当前元素, 退出循环, 恢复滑动右指针
	 *
	 * 时间: O(n)
	 * 空间: O(1)
	 *
	 * 滑动窗口解题思路:
	 * - 窗口内是什么?
	 * 窗口就是 刚好为3种水果时
	 * - 如何移动窗口的起始位置？
	 * 如果当前窗口的值(水果种类)大于2了，窗口就要向前移动了（也就是该缩小了）。
	 * - 如何移动窗口的结束位置?
	 * 窗口的结束位置就是遍历数组的指针，窗口的起始位置设置为数组的起始位置就可以了。
	 */
	public int totalFruit(int[] fruits) {
		// 滑动窗口的大小
		int maxFruit = Integer.MIN_VALUE;

		int left = 0;
		int right = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		while(right < fruits.length) {
			map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

			// 2. 右移右指针不满足时, 开始右移左指针,直到不满足条件时,恢复右移右指针
			while(map.size() > 2) {
				map.put(fruits[left], map.get(fruits[left]) - 1);
				// 当一种水果的数量为0时,右移左指针结束,开始恢复右移右指针
				if(map.get(fruits[left]) == 0) {
					map.remove(fruits[left]);
				}
				left++;
			}
			maxFruit = Math.max(right - left + 1, maxFruit);
			// 1. 右移右指针,直到满足条件时,开始移动左指针
			right++;
		}
		return maxFruit;
	}

}
