package 回溯.其它;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: _491_递增子序列
 * @Author: whc
 * @Date: 2021/06/19/10:43
 */
public class _491_递增子序列 {


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
	 * 	  由于本题是无序排列的,所以要在每一层添加一个set集合,用于排除重复, 比如选择列表中[4,7,7], 最后一个元素7不应该考虑
	 *
	 */
	/*List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> findSubsequences(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return res;
		}
		backtrack(nums, 0);

		return res;
	}

	private void backtrack(int[] nums, int startIndex) {
		if(path.size() >= 2)
			res.add(new ArrayList<>(path));

		if(startIndex == nums.length) {
			return;
		}
		Set<Integer> set = new HashSet<>(); // 对本层元素进行去重
		for (int i = startIndex; i < nums.length; i++) {
			// 不符合条件的跳过本层循环
			// path不为空,如果当前元素小于路径中的最后一个元素,则结束本轮循环
			// 如果本层set已经包含了nums[i],那么也结束本层循环
			if(!path.isEmpty() && nums[i] < path.get(path.size()-1) || set.contains(nums[i])) {
				continue;
			}
			set.add(nums[i]); // 记录这个元素已经使用过了,本层后面就不能使用了
			path.add(nums[i]);
			backtrack(nums, i+1);
			path.remove(path.size()-1);
		}
	}*/

	// 优化
	// 用一个数组 代替 HashMap
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();

	public List<List<Integer>> findSubsequences(int[] nums) {
		if(nums == null || nums.length <= 1) {
			return res;
		}
		backtrack(nums, 0);

		return res;
	}

	private void backtrack(int[] nums, int startIndex) {
		if(path.size() >= 2)
			res.add(new ArrayList<>(path));

		if(startIndex == nums.length) {
			return;
		}
		int[] used = new int[201]; // 因为整数的范围是[-100,100] 对本层元素进行去重
		for (int i = startIndex; i < nums.length; i++) {
			// 不符合条件的跳过本层循环
			// path不为空,如果当前元素小于路径中的最后一个元素,则结束本轮循环
			// 如果本层set已经包含了nums[i],那么也结束本层循环
			if(!path.isEmpty() && nums[i] < path.get(path.size()-1) || used[nums[i] + 100] == 1) {
				continue;
			}
			used[nums[i] + 100] = 1; // 记录这个元素已经使用过了,本层后面就不能使用了
			path.add(nums[i]);
			backtrack(nums, i+1);
			path.remove(path.size()-1);
		}
	}


	public static void main(String[] args) {
		_491_递增子序列 a = new _491_递增子序列();
		a.findSubsequences(new int[]{1,2,3,4});
	}
}
