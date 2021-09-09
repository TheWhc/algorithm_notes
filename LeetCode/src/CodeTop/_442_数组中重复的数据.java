package CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _442_数组中重复的数据
 * @Author: whc
 * @Date: 2021/09/09/21:18
 */
public class _442_数组中重复的数据 {

	public List<Integer> findDuplicates(int[] nums) {

		List<Integer> res= new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			while(nums[i] != i + 1 && nums[i] != nums[nums[i]-1]) {
				swap(nums, i, nums[i]-1);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != i + 1) {
				res.add(nums[i]);
			}
		}

		return res;
	}

	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}
}
