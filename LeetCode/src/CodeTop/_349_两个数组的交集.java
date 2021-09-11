package CodeTop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: _349_两个数组的交集
 * @Author: whc
 * @Date: 2021/09/11/16:23
 */
public class _349_两个数组的交集 {

	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
			return new int[0];
		}

		Set<Integer> set = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}

		Set<Integer> interSet = new HashSet<>();
		for (int num : nums2) {
			if(set.contains(num)) {
				interSet.add(num);
			}
		}

		int[] res = new int[interSet.size()];
		int idx = 0;
		for (Integer num : interSet) {
			res[idx++] = num;
		}

		return res;
	}
}
