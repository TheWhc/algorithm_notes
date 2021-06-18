package 回溯.组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _77_组合
 * @Author: whc
 * @Date: 2021/06/18/10:36
 */
public class _77_组合 {

	/**
	 * 思路: 回溯法
	 * n相当于树的宽度, k相当于树的高度
	 * 1. 递归函数的返回值以及参数
	 * 	  定义两个全局变量, 一个是存放符合条件的单一结果, 一个用来存放符合条件结果的集合
	 *    函数一定要有n和k,还需要有一个参数为int类型的startIndex,用于记录本层递归中,集合从哪里开始遍历
	 *
	 * 2. 回溯函数终止条件
	 * 	  path数组大小等于k的时候,保存起来,结束本层递归
	 *
	 * 3. 单层搜索的过程
	 * 	  for循环每次从startIndex开始
	 */
	/*List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		if(n <= 0 || k <= 0) {
			return res;
		}
		List<Integer> path = new ArrayList<>();
		backtrack(n, k, 1);
		return res;
	}

	private void backtrack(int n, int k, int start) {
		if(path.size() == k) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = start; i <= n; i++) {
			path.add(i);
			backtrack(n, k, i+1);
			path.remove(path.size()-1);
		}
	}*/


	// 剪枝优化
	// 遍历的范围是可以优化的,比如n=4,k=4时,第一层for循环开始,从2开始就没有意义了。第二层for循环,从3开始就没有意义了
	// 因此每层for循环最多到达 n - (k - path.size()) + 1
    //						n - 还需要选择的元素大小 + 1
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		if(n <= 0 || k <= 0) {
			return res;
		}
		List<Integer> path = new ArrayList<>();
		backtrack(n, k, 1);
		return res;
	}

	private void backtrack(int n, int k, int start) {
		if(path.size() == k) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = start; i <= n - (k - path.size()) + 1; i++) {
			path.add(i);
			backtrack(n, k, i+1); // 递归,控制树的纵向遍历,注意下一层搜索要从i+1开始
			path.remove(path.size()-1);
		}
	}


}
