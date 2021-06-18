package 回溯.组合问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _40_组合总和II
 * @Author: whc
 * @Date: 2021/06/18/12:35
 */
public class  _40_组合总和II {

	/**
	 * 思路: 回溯 + 剪枝优化(排序、遍历过程)
	 *
	 * 先对数组进行排序
	 *
	 * 1. 递归函数的返回值以及参数
	 * 	  定义两个全局变量, 一个是存放符合条件的单一结果, 一个用来存放符合条件结果的集合
	 *
	 * 	  backtrack(int[] candidates, int startIndex, int targetSum, boolean[] visited)
	 * 	  candidates: 选择列表
	 * 	  startIndex: 用于记录本层递归中,集合从哪里开始遍历
	 * 	  targetSum: 目标和
	 * 	  visited: 访问数组,判断同层节点是否已经遍历过
	 *
	 * 2. 回溯函数终止条件
	 * 	  targetSum < 0时, 不符合条件, 提前返回
	 * 	  targetSum == 0时,保存起来,结束本层递归
	 *
	 * 3. 单层搜索的过程
	 * 	  for循环每次从startIndex开始, 因为是排序数组,所以如果遍历到i时, targetSum已经小于0,则后面就不用再遍历了
	 *
	 */
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if(candidates == null || candidates.length == 0 || target == 0) {
			return res;
		}
		// 访问数组,判断同层节点是否已经遍历过
		boolean[] visited = new boolean[candidates.length];
		Arrays.sort(candidates);
		backtrack(candidates, 0, target, visited);
		return res;
	}

	private void backtrack(int[] candidates, int startIndex, int targetSum, boolean[] visited) {
		if(targetSum < 0) {
			return;
		}

		if(targetSum == 0) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < candidates.length && targetSum - candidates[i] >= 0; i++) {
			// 同一树层有两个重复的元素,不可以重复被选取
			if(i > 0 && candidates[i] == candidates[i-1] && !visited[i-1]) {
				continue;
			}
			// 同一树枝有两个重复的元素,但visited[i-1]为true,可以重复选取
			path.add(candidates[i]);
			visited[i] = true;
			backtrack(candidates, i+1, targetSum-candidates[i], visited);
			visited[i] = false;
			path.remove(path.size()-1);
		}
	}
}
