package 哈希.原地哈希;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _442_数组中重复的数据
 * @Author: whc
 * @Date: 2021/04/27/12:15
 */
public class _442_数组中重复的数据 {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			while(nums[i] > 0 && nums[i] != i+1) {
				if(nums[i] == nums[nums[i]-1]) {
					res.add(nums[i]);
					nums[i] = 0;
					break;
				} else {
					int temp = nums[i];
					nums[i] = nums[nums[i]-1];
					nums[temp-1] = temp;
				}
			}
		}
		return res;
	}

}
