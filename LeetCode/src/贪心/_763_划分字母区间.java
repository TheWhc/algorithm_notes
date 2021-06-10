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

	public static void main(String[] args) {
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
	}

}
