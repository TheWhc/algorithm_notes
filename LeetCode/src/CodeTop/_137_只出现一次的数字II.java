package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _137_只出现一次的数字II
 * @Author: whc
 * @Date: 2021/09/12/10:42
 */
public class _137_只出现一次的数字II {

	/*public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		return -1;
	}*/

	public int singleNumber(int[] nums) {
		int[] cnt = new int[32];
		for (int num : nums) {
			for (int i = 0; i < 32; i++) {
				if(((num >> i) & 1) == 1) {
					cnt[31 - i]++;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < 32; i++) {
			if(cnt[i] % 3 == 1) {
				res += (1 << (31 - i));
			}
		}

		return res;
	}

	public static void main(String[] args) {
		_137_只出现一次的数字II _137_只出现一次的数字II = new _137_只出现一次的数字II();
		_137_只出现一次的数字II.singleNumber(new int[]{3,3,3,5});
	}
}
