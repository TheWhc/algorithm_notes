package 待分类;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: 待分类._39_组合总和
 * @Author: whc
 * @Date: 2021/03/24/15:09
 */
// 求组合问题 需要startIndex
public class _39_组合总和 {

	/*List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> path = new ArrayList<>();
		backtrack(path, candidates, 0, target, 0);
		return res;
	}

	private void backtrack(List<Integer> path, int[] candidates, int sum, int target, int startIndex) {
		// 递归终止条件
		if(sum == target) {
			res.add(new ArrayList<>(path));
			return;
		} else if(sum > target) {
			return;
		}

		// 单层递归逻辑
		for (int i = startIndex; i < candidates.length; i++) {
			sum += candidates[i];
			path.add(candidates[i]);
			// 回溯
			backtrack(path, candidates, sum, target, i);
			// 撤销选择
			sum -= candidates[i];
			path.remove(path.size()-1);
		}
	}*/

	// 求和问题中 排序之后加剪枝
	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<Integer> path = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(path, candidates, 0, target, 0);
		return res;
	}

	private void backtrack(List<Integer> path, int[] candidates, int sum, int target, int startIndex) {
		// 递归终止条件
		if(sum == target) {
			res.add(new ArrayList<>(path));
			return;
		} else if(sum > target) {
			return;
		}

		// 单层递归逻辑
		// 如果 sum + candidates[i] > target 就终止遍历
		for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
			sum += candidates[i];
			path.add(candidates[i]);
			// 回溯
			backtrack(path, candidates, sum, target, i);
			// 撤销选择
			sum -= candidates[i];
			path.remove(path.size()-1);
		}
	}
}
