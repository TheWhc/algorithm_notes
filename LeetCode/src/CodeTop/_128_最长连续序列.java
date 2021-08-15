package CodeTop;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _128_最长连续序列
 * @Author: whc
 * @Date: 2021/07/28/8:58
 */
public class _128_最长连续序列 {

	/*public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		int maxLen = 0;

		for (int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i]-1)) {
				continue;
			}

			int a = nums[i];
			int len = 0;
			while(set.contains(a)) {
				a++;
				len++;
			}

			maxLen = Math.max(maxLen, len);
		}

		return maxLen;
	}*/

	/**
	 * 思路: 哈希Set
	 * 1. 创建一个Set,添加所有元素
	 * 2. 遍历数组,当遍历到元素num时,判断num-1是否存在于set当中,如果存在,那么说明此时以num开始的肯定不是最长连续序列
	 * 3. 如果不是,则统计以num开始的元素,每次+1后的值看是否在于Set中,如果存在,则临时长度+1
	 */
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}

		int maxLen = 0;

		for (int num : nums) {
			if(set.contains(num-1)) {
				continue;
			}

			int len = 0;
			while(set.contains(num)) {
				set.remove(num++);
				len++;
			}

			maxLen = Math.max(maxLen, len);

		}

		return maxLen;
	}
}
