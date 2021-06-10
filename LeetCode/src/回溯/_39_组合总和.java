package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: 待分类._39_组合总和
 * @Author: whc
 * @Date: 2021/04/28/11:15
 */

// 一个集合求组合,就需要startIndex
// 多个集合取组合,各个集合之间互不影响,就不用startIndex
public class _39_组合总和 {

	/*List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> path = new ArrayList<>();
		backtrack(path, candidates, target, 0);
		return res;
	}

	private void backtrack(List<Integer> path, int[] candidates, int count, int startIndex) {
		if(count < 0) {
			return;
		}
		if(count == 0) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < candidates.length; i++) {
			path.add(candidates[i]);
			// 此处i不用i+1,表示可以重复读取当前的数
			backtrack(path, candidates, count - candidates[i], i);
			path.remove(path.size()-1);
		}
	}*/

	// 优化
	// 排序 + 剪枝
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> path = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(path, candidates, target, 0);
		return res;
	}

	private void backtrack(List<Integer> path, int[] candidates, int count, int startIndex) {
		if(count < 0) {
			return;
		}
		if(count == 0) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < candidates.length && count - candidates[i] >= 0; i++) {
			path.add(candidates[i]);
			// 此处i不用i+1,表示可以重复读取当前的数
			backtrack(path, candidates, count - candidates[i], i);
			path.remove(path.size()-1);
		}
	}
}
