package 待分类;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._93_复原IP地址
 * @Author: whc
 * @Date: 2021/03/22/16:00
 */
public class _93_复原IP地址 {

	List<String> res = new ArrayList<>(); // 记录结果

	public List<String> restoreIpAddresses(String s) {
		if(s == null || s.length() == 0 || s.length() > 12)
			return res;
		// 回溯三部曲: 1. 递归参数 2. 递归终止条件 3. 单层搜索的逻辑
		StringBuilder path = new StringBuilder();
		backtrack(path, s, 0, 0);
		return res;
	}

	/**
	 *
	 * @param s
	 * @param startIndex 搜索的起始位置
	 * @param pointNum 添加逗点的数量
	 */
	private void backtrack(StringBuilder path, String s, int startIndex, int pointNum) {
		if(pointNum == 3) { // 逗点数量为3时, 分割结束
			String last = s.substring(startIndex);
			// 判断第四段子字符串是否合法,如果合法就放进result
			if(isValid(last)) {
				path.append(last);
				res.add(new String(path));
			}
			return;
		}

		for (int i = startIndex; i < s.length(); i++) {
			String str = s.substring(startIndex, i+1);
			if(isValid(str)) {
				path.append(str);
				path.append(".");
				pointNum += 1;
				backtrack(path, s, i+1, pointNum);
				pointNum -= 1;
				path.deleteCharAt(path.lastIndexOf("."));
				int pointLastNum = path.lastIndexOf(".");
				path.delete(pointLastNum + 1, path.length());
			} else {
				break;
			}
		}
	}

	/*
		- 段位以0为开头的数字不合法
		- 段位里有非正整数字符不合法
		- 段位如果大于255不合法
	 */
	// 判断字符串s在左闭右闭区间[start, end]所组成的数字是否合法
	private boolean isValid(String s) {
		if(s == null || s.length() == 0)
			return false;
		int start = 0;
		int end = s.length()-1;
		if(s.charAt(start) == '0' && start != end) {
			return false;
		}
		int num = 0;
		for (int i = start; i <= end; i++) {
			if(s.charAt(i) > '9' || s.charAt(i) < '0') {
				return false;
			}
			num = num * 10 + (s.charAt(i) - '0');
			if(num > 255) {
				return false;
			}
		}
		return true;
	}
}
