package 回溯.分割问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _93_复原IP地址
 * @Author: whc
 * @Date: 2021/06/18/15:16
 */
public class _93_复原IP地址 {


	/**
	 *  思路: 回溯
	 *
	 * 1. 递归函数的返回值以及参数
	 * 	  定义两个全局变量, 一个是存放符合条件的单一结果, 一个用来存放符合条件结果的集合
	 *
	 * 	  backtrack(String s, int startIndex, int dotNum)
	 * 	  s: 选择列表
	 * 	  startIndex: 用于记录本层递归中,集合从哪里开始遍历
	 * 	  dotNum: 句点的数量
	 *
	 * 2. 回溯函数终止条件
	 * 	  dotNum == 3时, 做进一步判断
	 * 	  (要注意第四段的下标是否越界)
	 * 	  如果第四段子串是合法的,则将第四段添加到路径中,最后添加到结果集res中,添加完毕后还要进行一步回溯操作,剔除刚刚添加的第4段
	 *
	 * 3. 单层搜索的过程
	 * 	  for循环每次从startIndex开始,如果子串是合法的,则进入下一层递归
	 * 	  若不合法,则提前结束本层循环
	 *
	 */
	List<String> res = new ArrayList<>();
	StringBuilder path = new StringBuilder();

	public List<String> restoreIpAddresses(String s) {
		if(s == null || s.length() == 0) {
			return res;
		}

		// 超过12个数字无法组成IP地址
		if(s.length() > 12) {
			return res;
		}

		backtrack(s, 0, 0);

		return res;
	}

	private void backtrack(String s, int startIndex, int dotNum) {

		// 当出现 0.10.0.时, 即出现3个'.'时, 就进入判断
		if(dotNum == 3) {
			// 判断第四段子字符串是否合法,合法就放入res中
			// 要注意第四段子字符串下标是否已经超过s字符串的大小！！！！
			if(startIndex < s.length() && isValid(s.substring(startIndex, s.length()))) {
				// 满足则添加最后一段,然后添加到结果集中
				res.add(path.append(s.substring(startIndex, s.length())).toString());
				// 添加完0.10.0.10后, 要记得回溯, 即删除最后的"10", 回退到只有3段的时候, 即0.10.0.
				String[] split = path.toString().split("\\.");
				// path的长度 - 最后"10"的长度 得到"10"的起始位置
				path.delete(path.length() - split[split.length-1].length(), path.length());
			}
			return;
		}

		for (int i = startIndex; i < s.length(); i++) {
			String substring = s.substring(startIndex, i + 1);
			if(isValid(substring)) {
				// 满足条件的,添加到路径中
				path.append(substring + ".");
				// 递归进入下一层, dotNum数量要+1
				backtrack(s, i+1, dotNum+1);
				// 回溯,删除 0.10.0. 中的 0. 回退到上一步的 0.10.
				String[] split = path.deleteCharAt(path.length() - 1).toString().split("\\.");
				path.delete(path.length() - split[split.length-1].length(), path.length());
			} else {
				// 本层不符合的时候 提前结束本层循环
				break;
			}
		}
	}

	private boolean isValid(String substring) {
		// 只有一个'0'是合法的
		if(substring.length() == 1) {
			return true;
		}

		// "00" "000": 0开头的数字不合法
		if(substring.charAt(0) == '0') {
			return false;
		}

		int num = 0;
		// 防止大数溢出,提前判断是否大于255
		for (int i = 0; i < substring.length(); i++) {
			num = num * 10 + (substring.charAt(i) - '0');
			if(num > 255) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		_93_复原IP地址 a = new _93_复原IP地址();
		a.restoreIpAddresses(
				"2736786374048");
	}
}
