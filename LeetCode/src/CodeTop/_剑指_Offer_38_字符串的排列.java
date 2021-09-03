package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _剑指_Offer_38_字符串的排列
 * @Author: whc
 * @Date: 2021/08/21/23:13
 */
public class _剑指_Offer_38_字符串的排列 {

	List<String> res = new ArrayList<>();
	public String[] permutation(String s) {
		StringBuilder path = new StringBuilder();
		boolean[] used = new boolean[s.length()];
		char[] chars = s.toCharArray(); // 选择列表
		Arrays.sort(chars); // 排序
		backtrack(chars, path, used);
		return res.toArray(new String[res.size()]);
	}

	private void backtrack(char[] chars, StringBuilder path, boolean[] used) {
		if(path.length() == chars.length) {
			res.add(new String(path.toString()));
			return;
		}

		for (int i = 0; i < chars.length; i++) {
			// 去重
			if(i > 0 && chars[i] == chars[i-1] && !used[i-1]) {
				continue;
			}

			// 同层未被使用过的元素
			if(!used[i]) {
				used[i] = true;
				path.append(chars[i]);
				backtrack(chars, path, used);
				path.deleteCharAt(path.length()-1);
				used[i] = false;
			}
		}
	}
}
