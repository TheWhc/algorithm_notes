package 贪心;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: _763_划分字母区间
 * @Author: whc
 * @Date: 2021/04/14/12:45
 */
public class _763_划分字母区间 {

	/*public static void main(String[] args) {
		partitionLabels("ababcbacadefegdehijhklij");
	}

	public static List<Integer> partitionLabels(String S) {
		if(S == null || S.length() == 0) {
			return new ArrayList<>();
		}
		List<Integer> res = new ArrayList<>();
		// 记录字符串每个字符的最远出现下标
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			map.put(S.charAt(i), i);
		}

		int begin = 0;
		int end = 0;
		for (int i = 0; i < S.length(); i++) {
			// 找到最远出现下标
			end = Math.max(map.get(S.charAt(i)), end);
			// 如果相等
			if(end == i) {
				res.add(i - begin + 1);
				begin = i + 1;
			}
		}

		return res;
	}*/

	/**
	 * 思路: 贪心
	 *
	 * 1. 统计每个字符的最后出现位置
	 * 2. 从头开始遍历字符串, 并更新字符的最远下标, 如果当前下标 == 字符的最远下标 , 则找到了分割点
	 */
	public List<Integer> partitionLabels(String s) {

		int[] idxArray = new int[26];

		for (int i = 0; i < s.length(); i++) {
			idxArray[s.charAt(i) - 'a'] = i;
		}

		List<Integer> res = new ArrayList<>();

		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			// 找到字符出现的最远边界
			right = Math.max(right, idxArray[s.charAt(i) - 'a']);
			if(i == right) {
				res.add(right - left + 1);
				left = i + 1;
			}
		}

		return res;
	}



}
