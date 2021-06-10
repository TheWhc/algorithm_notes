package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _77_组合
 * @Author: whc
 * @Date: 2021/04/28/8:53
 */
public class _77_组合 {

	/*List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		List<Integer> path = new ArrayList<>();
		backtrack(path, 1, n, k);
		return res;
 	}

	private void backtrack(List<Integer> path, int startIndex, int n, int k) {
		if(path.size() == k) {
			res.add(new ArrayList<>(path));
			return;
		}

		// 单层处理逻辑
		for (int i = startIndex; i <= n; i++) {
			path.add(i);
			backtrack(path, i+1, n, k); // 递归,控制树的纵向遍历,注意下一层搜索要从i+1开始
			path.remove(path.size()-1);
		}
	}*/

	// 剪枝优化
	// 可以剪枝的地方就在递归中每一层的for循环所选择的起始位置
	// 如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		List<Integer> path = new ArrayList<>();
		backtrack(path, 1, n, k);
		return res;
	}

	private void backtrack(List<Integer> path, int startIndex, int n, int k) {
		if(path.size() == k) {
			res.add(new ArrayList<>(path));
			return;
		}

		// 单层处理逻辑
		for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
			path.add(i);
			backtrack(path, i+1, n, k); // 递归,控制树的纵向遍历,注意下一层搜索要从i+1开始
			path.remove(path.size()-1);
		}
	}
}
