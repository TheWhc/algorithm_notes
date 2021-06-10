package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._78_子集
 * @Author: whc
 * @Date: 2021/04/30/8:58
 */
public class _78_子集 {

	// 时间复杂度: O(n * 2^n) 每一个元素所以2^n, 每一组子集都要数组,需要n
	// 空间复杂度: O(n)

	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> subsets(int[] nums) {
		if(nums == null || nums.length == 0) {
			return res;
		}
		List<Integer> path = new ArrayList<>();
		backtrack(path, nums, 0);
		return res;
	}

	private void backtrack(List<Integer> path, int[] nums, int startIndex) {
		res.add(new ArrayList<>(path));
		if(startIndex >= nums.length) {
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			path.add(nums[i]);
			backtrack(path, nums, i+1);
			path.remove(path.size()-1);
		}
	}

}
