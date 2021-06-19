package 回溯.子集问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _78_子集
 * @Author: whc
 * @Date: 2021/06/19/10:26
 */
public class _78_子集 {

	/**
	 *  思路: 回溯
	 *
	 * 1. 递归函数的返回值以及参数
	 * 	  定义两个全局变量, 一个是存放符合条件的单一结果, 一个用来存放符合条件结果的集合
	 *
	 * 	  backtrack(int[] nums, int startIndex)
	 * 	  nums: 选择列表
	 * 	  startIndex: 用于记录本层递归中,集合从哪里开始遍历
	 *
	 * 2. 回溯函数终止条件
	 * 	  startIndex == nums.length时
	 *
	 * 3. 单层搜索的过程
	 * 	  for循环每次从startIndex开始
	 *
	 * 时间: O(n * 2^n)  每一个元素的状态无外乎取与不取,所以时间复杂度为O(2^n) 构造每一组子集都需要填进数组,又需要O(n)
	 * 空间: O(n) 		递归深度为n
	 */
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		backtrack(nums, 0);
		return res;
	}

	private void backtrack(int[] nums, int startIndex) {
		res.add(new ArrayList<>(path));
		if(startIndex == nums.length) {
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			path.add(nums[i]);
			backtrack(nums, i+1);
			path.remove(path.size()-1);
		}
	}
}
