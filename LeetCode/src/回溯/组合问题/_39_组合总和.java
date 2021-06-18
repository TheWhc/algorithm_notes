package 回溯.组合问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _39_组合总和
 * @Author: whc
 * @Date: 2021/06/18/12:11
 */
public class _39_组合总和 {

	// 选择列表中元素无重复,但是可以重复选

	/**
	 * 思路: 回溯
	 * 1. 递归函数的返回值以及参数
	 * 	  定义两个全局变量, 一个是存放符合条件的单一结果, 一个用来存放符合条件结果的集合
	 *
	 *    函数一个是选择列表, 一个startIndex, 一个是targetSum
	 *	  startIndex用于记录本层递归中,集合从哪里开始遍历, 由于可以重复选择元素, 所以下一层递归应该还是从当前元素的下标开始
	 *
	 * 2. 回溯函数终止条件
	 * 	  targetSum == 0时,保存起来,结束本层递归
	 *
	 * 3. 单层搜索的过程
	 * 	  for循环每次从startIndex开始
	 */
	/*List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		backtrack(candidates,0, target);
		return res;
	}

	private void backtrack(int[] candidates, int startIndex, int targetSum) {
		if(targetSum < 0) {
			return;
		}

		if(targetSum == 0) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < candidates.length; i++) {
			path.add(candidates[i]);
			backtrack(candidates, i, targetSum - candidates[i]);
			path.remove(path.size()-1);
		}
	}*/

	// 剪枝优化
	// 排序 + 遍历范围优化
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		backtrack(candidates,0, target);
		return res;
	}

	private void backtrack(int[] candidates, int startIndex, int targetSum) {
		if(targetSum < 0) {
			return;
		}

		if(targetSum == 0) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i < candidates.length && targetSum - candidates[i] >= 0; i++) {
			path.add(candidates[i]);
			backtrack(candidates, i, targetSum - candidates[i]);
			path.remove(path.size()-1);
		}
	}
}
