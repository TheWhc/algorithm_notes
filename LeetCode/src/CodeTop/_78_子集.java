package CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _78_子集
 * @Author: whc
 * @Date: 2021/07/25/9:55
 */
public class _78_子集 {

	List<List<Integer>> res = new ArrayList<>();
	public List<List<Integer>> subsets(int[] nums) {
		backtrack(nums, new ArrayList<Integer>(), 0);
		return res;
	}

	private void backtrack(int[] nums, ArrayList<Integer> path, int startIndex) {
		if(startIndex > nums.length) {
			return;
		}

		res.add(new ArrayList<>(path));

		for (int i = startIndex; i < nums.length; i++) {
			path.add(nums[i]);
			backtrack(nums, path, i+1);
			path.remove(path.size()-1);
		}
	}
}
