package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _40_组合总和II
 * @Author: whc
 * @Date: 2021/04/28/11:33
 */
public class _40_组合总和II {

	// 时间复杂度O(n*2^n)  // 组合问题其实就是一种子集的问题
	// 空间复杂度O(n)
	/*List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if(candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		List<Integer> path = new ArrayList<>();
		boolean[] used = new boolean[candidates.length];
		backtrack(path, candidates, target, 0, used);
		return res;
	}

	private void backtrack(List<Integer> path, int[] candidates, int count, int startIndex, boolean[] used) {
		if(count < 0) {
			return;
		}
		if(count == 0) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < candidates.length && count - candidates[i] >= 0; i++) {
			// used[i-1] == false 说明同一树层candidates[i-1]使用过
			// used[i-1] == true 说明同一树枝candidates[i-1]使用过
			if(i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false) continue;
			path.add(candidates[i]);
			used[i] = true;
			backtrack(path, candidates, count - candidates[i], i+1, used);
			used[i] = false;
			path.remove(path.size()-1);
		}
	}*/

	// 不用used数组去重
	// 以i和startIndex判断大小进行去重
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if(candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
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

		for (int i = startIndex; i < candidates.length && count - candidates[i] >= 0; i++) {
			if(i > startIndex && candidates[i] == candidates[i-1]) continue;
			path.add(candidates[i]);
			backtrack(path, candidates, count - candidates[i], i+1);
			path.remove(path.size()-1);
		}
	}
}
