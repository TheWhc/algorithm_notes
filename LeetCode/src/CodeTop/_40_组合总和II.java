package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _40_组合总和II
 * @Author: whc
 * @Date: 2021/09/02/9:40
 */
public class _40_组合总和II {

	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if(candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		boolean[] visited = new boolean[candidates.length];
		backtrack(candidates, 0, visited, target);
		return res;
	}

	private void backtrack(int[] candidates, int startIndex, boolean[] visited, int targetSum) {
		if(targetSum < 0) {
			return;
		}

		if(targetSum == 0) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < candidates.length && targetSum - candidates[i] >= 0; i++) {
			if(i > 0 && candidates[i] == candidates[i-1] && !visited[i-1]) {
				continue;
			}

			visited[i] = true;
			path.add(candidates[i]);
			backtrack(candidates, i+1, visited, targetSum - candidates[i]);
			path.remove(path.size()-1);
			visited[i] = false;
		}
	}
}
