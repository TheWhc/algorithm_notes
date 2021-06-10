package 待分类;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: 待分类._136_只出现一次的数字
 * @Author: whc
 * @Date: 2021/03/25/11:21
 */
public class _136_只出现一次的数字 {

	/*public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if(!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, 2);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return -1;
	}*/

	/*public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i+=2) {
			if(i == nums.length-1) {
				return nums[nums.length-1];
			}
			if(nums[i] != nums[i+1]) {
				return nums[i];
			}
		}
		return -1;
	}*/

	// 异或运算
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res =  res ^ nums[i];
		}
		return res;
	}

}
