package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _216_组合总和III
 * @Author: whc
 * @Date: 2021/04/28/9:38
 */
public class _216_组合总和III {

	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> path = new ArrayList<>();
		backtrack(path, 1, k, n);
		return res;
	}

	private void backtrack(List<Integer> path, int startIndex, int k, int count) {
		// 剪枝
		if(count < 0) {
			return;
		}
		if(path.size() == k) {
			if(count == 0) {
				res.add(new ArrayList<>(path));
			}
			return;
		}

		for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
			path.add(i);
			backtrack(path, i+1, k, count-i);
			path.remove(path.size()-1);
		}
	}
}
