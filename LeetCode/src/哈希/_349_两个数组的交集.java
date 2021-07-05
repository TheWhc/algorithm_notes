package 哈希;

import java.util.*;

/**
 * @ClassName: _349_两个数组的交集
 * @Author: whc
 * @Date: 2021/07/05/9:50
 */
public class _349_两个数组的交集 {

	/**
	 * 思路: 利用Set集合
	 *
	 * 时间: O(n+m)
	 * 空间: O(n+m)
	 */
	/*public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		Set<Integer> set = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}

		Set<Integer> resSet = new HashSet<>();
		for (int num : nums2) {
			if(set.contains(num)) {
				resSet.add(num);
			}
		}

		int[] res = new int[resSet.size()];
		int idx = 0;

		for (int num : resSet) {
			res[idx++] = num;
		}

		return res;
	}*/


	/**
	 * 思路：双指针法 + Set
	 *
	 * 时间: O(nlogn + mlogm)
	 * 空间: O(min(n, m))
	 */
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int index1 = 0;
		int index2 = 0;

		Set<Integer> resSet = new HashSet<>();

		while(index1 < nums1.length && index2 < nums2.length) {
			if(nums1[index1] < nums2[index2]) {
				index1++;
			} else if(nums1[index1] > nums2[index2]) {
				index2++;
			} else {
				resSet.add(nums1[index1]);
				index1++;
				index2++;
			}
		}

		int[] res = new int[resSet.size()];
		int idx = 0;

		for (int num : resSet) {
			res[idx++] = num;
		}

		return res;
	}

}
