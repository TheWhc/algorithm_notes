package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: _剑指_Offer_48_最长不含重复字符的子字符串
 * @Author: whc
 * @Date: 2021/06/02/12:40
 */
public class _剑指_Offer_48_最长不含重复字符的子字符串 {

	/**
	 *  思路: 滑动窗口,双指针法
	 *
	 *  1. left和right指针,最开始指向下标为0,然后right开始往右移动
	 *  2. 把扫描过的元素放到map中,如果right扫描过的元素没有重复就一直后移,顺便记录一下最大值
	 *  3. 如果right扫描过的元素有重复元素,则改变left指针,取Math.max(left, 原来元素下标值+1)
	 *
	 *  时间: O(n)
	 *  空间: O(1) 字符最多128个
	 *
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int res = 0;
		// 存储元素对应的下标值
		Map<Character, Integer> map = new HashMap<>();
		while(right < s.length()) {
			if(map.containsKey(s.charAt(right))) {
				// 取最大值是因为可能出现 a b b a情况时, 当right = 3时, 此时left = 2,若不取最大值,则left会变为1
				left = Math.max(left, map.get(s.charAt(right)) + 1);
			}
			map.put(s.charAt(right), right);
			res = Math.max(res, right - left  +1);
			right++;
		}

		return res;
	}
}
