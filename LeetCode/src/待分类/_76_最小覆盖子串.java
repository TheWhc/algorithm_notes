package 待分类;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: 待分类._76_最小覆盖子串
 * @Author: whc
 * @Date: 2021/04/06/10:56
 */
public class _76_最小覆盖子串 {

	/**
	 * s = ABAACBAB
	 * t = ABC
	 *
	 * count = {A:1}
	 * count = {A:1, B:1}
	 * count = {A:3, B:1, C:1}
	 *
	 * origin = {A:1, B:1, C:1}
	 */
	Map<Character, Integer> origin;
	Map<Character, Integer> count;

	public String minWindow(String s, String t) {
		origin = new HashMap<>();
		count = new HashMap<>();

		for (char c : t.toCharArray()) {
			origin.put(c, origin.getOrDefault(c, 0) + 1);
		}

		// left为滑动窗口左边界, right为有边界, ansLeft是最终答案的左边, ansRight是最终答案的右边界
		int left = 0, right = 0;
		int ansLeft = -1, ansRight = -1;
		// 滑动窗口最小长度
		int len = Integer.MAX_VALUE;
		int size = s.length();
		// 固定右边界,进行扩张
		while(right < size) {
			char c = s.charAt(right);
			// 对窗口右边界进行读入,并将对应的字符个数进行累加和
			if(origin.containsKey(c)) {
				count.put(c, count.getOrDefault(c, 0) + 1);
			}

			// 遍历左边界,收缩
			// 检查一下当前两个哈希表中的值是否符合要求,而且要求左边界不能超过右边界
			while(check() && left <= right) {
				if(right - left + 1 < len) {
					len = right - left + 1;
					ansLeft = left;
					ansRight = right + 1;
				}
				// 右移左边界,并吐出来之前左边界的字符统计个数
				if(origin.containsKey(s.charAt(left))) {
					count.put(s.charAt(left), count.getOrDefault(s.charAt(left), 0) - 1);
				}
				left++;
			}

			right++;
		}
		return ansRight == -1 ? "" : s.substring(ansLeft, ansRight);
	}

	private boolean check() {
		for (Map.Entry<Character, Integer> entry : origin.entrySet()) {
			// 只要当前序列中的某个字符的个数小于要求的个数 就返回false
			if(count.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
				return false;
			}
		}
		return true;
	}
}
