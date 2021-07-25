package CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _93_复原IP地址
 * @Author: whc
 * @Date: 2021/07/25/22:43
 */
public class _93_复原IP地址 {

	List<String> res = new ArrayList<>();
	public List<String> restoreIpAddresses(String s) {
		if(s == null || s.length() == 0) {
			return res;
		}

		if(s.length() > 12) {
			return res;
		}

		backtrack(s, 0, 0, "");

		return res;
	}

	private void backtrack(String s, int startIndex, int dotNum, String path) {

		// 递归终止条件,点数量等于3时,添加结果并返回
		if(dotNum == 3) {
			// 检查第四段子串是否合法
			if(startIndex < s.length() && isValid(s.substring(startIndex, s.length()))) {
				path += s.substring(startIndex, s.length());
				res.add(new String(path));
				return;
			}
		}

		// 单层搜索逻辑
		for (int i = startIndex; i < s.length(); i++) {
			String substring = s.substring(startIndex, i + 1);
			// 子串合法的话,则进行添加
			if(isValid(substring)) {
				backtrack(s, i+1, dotNum+1, path + substring + ".");
			} else {
				break;
			}
		}
	}

	private boolean isValid(String s) {
		// "0"
		if(s.length() == 1) {
			return true;
		}

		// "000" "012" "013"
		if(s.charAt(0) == '0') {
			return false;
		}

		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum = sum * 10 + (s.charAt(i) - '0');
			if(sum > 255) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		_93_复原IP地址 _93_复原IP地址 = new _93_复原IP地址();
		_93_复原IP地址.restoreIpAddresses("101023");
	}
}
