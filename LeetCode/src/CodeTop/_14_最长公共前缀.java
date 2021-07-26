package CodeTop;

/**
 * @ClassName: _14_最长公共前缀
 * @Author: whc
 * @Date: 2021/07/26/10:53
 */
public class _14_最长公共前缀 {

	/*public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		}

		String prefix = strs[0];

		// prefix = "flow" , strs[i] = "flight"
		for (int i = 1; i < strs.length; i++) {
			while(!strs[i].startsWith(prefix)) {
				prefix = prefix.substring(0, prefix.length()-1);
				// 提前结束
				if(prefix.length() == 0) {
					return "";
				}
			}
		}

		return prefix;
	}*/

	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) {
			return "";
		}

		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {

			int j = 0;
			while(j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
				j++;
			}

			prefix = prefix.substring(0, j);

			if(prefix.equals("")) {
				return "";
			}
		}

		return prefix;
	}

}
