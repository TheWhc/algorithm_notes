package CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _22_括号生成
 * @Author: whc
 * @Date: 2021/07/26/14:50
 */
public class _22_括号生成 {

	// 回溯,深度优先搜索
	List<String> res = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		if(n == 0) {
			return res;
		}

		dfs("", n, n);

		return res;
	}

	/**
	 *
	 * @param path 路径
	 * @param left 左括号剩余数量
	 * @param right 右括号剩余数量
	 */
	private void dfs(String path, int left, int right) {

		// 递归终止条件
		if(left == 0 && right == 0) {
			res.add(path);
			return;
		}

		// 剪枝
		// 左括号数大于右括号数时
		if(left > right) {
			return;
		}

		// 这里并不需要回溯后进行删除添加的字符,因为这里字符串拼接会产生新的字符串
		if(left > 0) {
			dfs(path + "(", left - 1, right);
		}
		if(right > 0) {
			dfs(path + ")", left, right - 1);
		}
	}
}
