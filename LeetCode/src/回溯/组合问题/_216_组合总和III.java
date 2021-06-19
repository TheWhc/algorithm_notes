package 回溯.组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _216_组合总和III
 * @Author: whc
 * @Date: 2021/06/18/11:09
 */
public class _216_组合总和III {

	/**
	 * 思路: 回溯法
	 * 1. 递归函数的返回值以及参数
	 * 	  定义两个全局变量, 一个是存放符合条件的单一结果, 一个用来存放符合条件结果的集合
	 *    函数一定要有targetSum和k,还需要有一个参数为int类型的startIndex,用于记录本层递归中,集合从哪里开始遍历
	 *    targetSum表示减去当前选择的元素后, 还需要多少目标和
	 *
	 * 2. 回溯函数终止条件
	 * 	  path数组大小等于k并且targetSum == 0时,保存起来,结束本层递归
	 *
	 * 3. 单层搜索的过程
	 * 	  for循环每次从startIndex开始
	 *
	 * 时间: O(n * 2^n) 组合问题其实也是一种子集问题,所以时间复杂度不会超过子集的时间复杂度
	 * 空间: O(n)
	 */
	/*List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		if(k <= 0) {
			return res;
		}

		backtrack(n, k, 1);

		return res;
	}

	private void backtrack(int targetSum,int k, int startIndex) {

		if(targetSum < 0) {
			return;
		}

		if(targetSum == 0 && k == path.size()) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = startIndex; i <= 9; i++) {
			path.add(i);
			targetSum -= i;
			backtrack(targetSum,k, i+1);
			targetSum += i;
			path.remove(path.size()-1);
		}
	}*/

	// 剪枝优化
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		if(k <= 0) {
			return res;
		}

		backtrack(n, k, 1);

		return res;
	}

	private void backtrack(int targetSum,int k, int startIndex) {

		// 剪枝优化
		if(targetSum < 0) {
			return;
		}

		if(targetSum == 0) {
			if(k == path.size()) {
				res.add(new ArrayList<>(path));
			}
			// 可能出现不满大小为k的路径, 虽然满足targetSum == 0,但是依然提前返回
			return;
		}

		// 剪枝优化
		// 范围优化: 9 - (k - path.size()) + 1
		for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
			path.add(i);
			backtrack(targetSum - i,k, i+1);
			path.remove(path.size()-1);
		}
	}
}
