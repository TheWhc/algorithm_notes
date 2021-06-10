package 待分类;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._复原IP地址
 * @Author: whc
 * @Date: 2021/03/22/17:51
 */
public class _复原IP地址 {

	private List<String> res = new ArrayList<>();

	public List<String> restoreIpAddresses(String s) {
		if(s == null || s.length() == 0 || s.length() > 12)
			return res;
		StringBuffer path = new StringBuffer();
		backtrack(path, s, 0, 0);
		return res;
	}

	// 1. 递归参数

	/**
	 *
	 * @param path 选择的路径
	 * @param s
	 * @param startIndex 搜索的起始位置
	 * @param pointNum 添加逗点的数量
	 */
	private void backtrack(StringBuffer path, String s, int startIndex, int pointNum) {
		// 2. 递归终止条件
		if(pointNum == 3) {
			// 判断第四段子串是否合法
			String lastString = s.substring(startIndex);
			if(isValid(lastString)) {
				path.append(lastString);
				res.add(new String(path));
			}
			return;
		}

		// 3. 单层递归搜索逻辑
		for (int i = startIndex; i < s.length(); i++) {
			String str = s.substring(startIndex, i + 1);
			if(isValid(str)) {
				path.append(str);
				pointNum += 1;
				path.append(".");
				// 回溯
				backtrack(path, s, i + 1, pointNum);
				// 回溯删除逗点
				pointNum -= 1;
				path.deleteCharAt(path.lastIndexOf("."));
				int pointLastNum = path.lastIndexOf(".");
				path.delete(pointLastNum+1, path.length());
			} else {
				break;
			}
		}
	}

	// 判断字串是否合法
	// 以0开头且不少于1个长度的子串非法、字符中不是数字非法、超过255非法
	private boolean isValid(String str) {
		if(str == null || str.length() == 0)
			return false;
		int start = 0;
		int end = str.length() - 1;
		int sum = 0;
		if(str.charAt(start) == '0' && start != end) {
			return false;
		}
		while(start <= end) {
			if(str.charAt(start) < '0' || str.charAt(start) > '9') {
				return false;
			}
			sum = sum * 10 + (str.charAt(start) - '0');
			if(sum > 255) {
				return false;
			}
			start++;
		}

		return true;
	}
}
