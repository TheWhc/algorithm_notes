package 待分类;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: 待分类._128_最长连续序列
 * @Author: whc
 * @Date: 2021/04/08/13:47
 */
public class _128_最长连续序列 {

	// 时间O(nlogn)
	// 空间O(logn)
	/*public int longestConsecutive(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int res = 1;
		int count = 1;
		// 0 1 1 2
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i+1] == nums[i]) {
				continue;
			} else if(nums[i+1] == nums[i] + 1) {
				count++;
			} else {
				count = 1;
			}
			res = Math.max(res, count);
		}

		return res;
	}*/

	// Set方法
	// 时间O(n) 看似又双重遍历,但是每个元素最多被访问两次
	// 空间O(n)
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}
		int res = 0;
		for (int num : nums) {
			// 有左边界,num不可能是左边界
			if(set.contains(num-1)) {
				continue;
			}

			// len记录以num为左边界的连续序列的长度
			int len = 0;
			while(set.contains(num++)) {
				len++;
			}
			res = Math.max(res, len);
		}

		return res;
	}
}
