package top100;

import java.util.*;

/**
 * @ClassName: _49_字母异位词分组
 * @Author: whc
 * @Date: 2021/05/08/9:25
 */
public class _49_字母异位词分组 {

	/**
	 * 思路: 对于每个字符串,比较它们出现的个数是否相等(用一个HashMap记录每个字符出现的次数(第二个字符串比较时减去相同字符个数))
	 * 如果字符串相等,则放在一个类别中。最外层用一个for循环,另外设置一个访问过(已相同)的标记,判断当前是否已加入
	 */
	// 时间复杂度O(n^2K) K为字符串长度
	/*public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		boolean[] used = new boolean[strs.length];
		for (int i = 0; i < strs.length; i++) {
			if(!used[i]) {
				List<String> temp = new ArrayList<>();
				temp.add(strs[i]);
				// 两两比较字符串是否相同
				for (int j = i+1; j < strs.length; j++) {
					if(stringEquals(strs[i], strs[j])) {
						used[j] = true;
						temp.add(strs[j]);
					}
				}
				if(!temp.isEmpty()) {
					res.add(temp);
				}
			}
		}
		return res;
	}

	private boolean stringEquals(String str1, String str2) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			if(map.containsKey(str1.charAt(i))) {
				map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
			} else {
				map.put(str1.charAt(i), 1);
			}
		}

		for (int i = 0; i < str2.length(); i++) {
			if(map.containsKey(str2.charAt(i))) {
				map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
			} else {
				return false;
			}
		}

		// 判断每个字符次数是否为0,不是则返回false
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() != 0) {
				return false;
			}
		}

		return true;
	}*/

	// 每个字符串按照字母排序的方式, 比如eat、tea、ate映射到aet
	public List<List<String>> groupAnagrams(String[] strs) {

		// 时间复杂度: O(n klog(k))
		// 空间: O(nk)
		Map<String, List<String>> hash = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] s_arr = strs[i].toCharArray();
			Arrays.sort(s_arr);
			String key = String.valueOf(s_arr);

			if(hash.containsKey(key)) {
				hash.get(key).add(strs[i]);
			} else {
				List<String> temp = new ArrayList<>();
				temp.add(strs[i]);
				hash.put(key, temp);
			}
		}
		return new ArrayList<>(hash.values());
	}
}
