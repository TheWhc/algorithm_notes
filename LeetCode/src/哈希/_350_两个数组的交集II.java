package 哈希;

import java.util.*;

/**
 * @ClassName: _350_两个数组的交集II
 * @Author: whc
 * @Date: 2021/07/05/9:58
 */
public class _350_两个数组的交集II {

	/**
	 * 1. 如果给定的数组已经排好序呢？你将如何优化你的算法？
	 *   排序 + 双指针
	 * 2. 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
	 * 哈希计数, 将较小的数组哈希计数，随后在另一个数组中根据哈希来寻找。
	 * 3. 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
	 *   通过归并外排将两个数组排序后再使用排序双指针查找
	 *   一般说排序算法都是针对于内部排序，一旦涉及到跟磁盘打交道（外部排序），则需要特殊的考虑。
	 *   归并排序是天然适合外部排序的算法，可以将分割后的子数组写到单个文件中，归并时将小文件合并为更大的文件。
	 *   当两个数组均排序完成生成两个大文件后，即可使用双指针遍历两个文件，如此可以使空间复杂度最低。
	 *
	 */

	/**
	 * 思路: 哈希表统计法
	 *
	 * 时间: O(n+m) m,n分别是两个数组的长度
	 * 空间： O(min(n,m))
	 */
	/*public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}

		Map<Integer, Integer> map = new HashMap<>();
		for(int num : nums1) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		List<Integer> list = new ArrayList<>();
		for(int num : nums2) {
			if(!map.containsKey(num)) {
				continue;
			}
			if(map.get(num) > 0) {
				list.add(num);
				map.put(num, map.get(num) - 1);
			}
		}
		int[] res = new int[list.size()];
		for(int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}*/


	/**
	 * 思路：排序 + 双指针
	 *
	 * 1. 一开始,两个数组的指针都指向起始位置
	 * 2. 不断移动指针,直到两个指针有一个指针遍历完数组,就停止循环遍历
	 * 3. 若下标index1元素的值 < 下标index2元素的值, 则index1++
	 *    若下标index1元素的值 > 下标index2元素的值, 则index2++
	 *    若下标index1元素的值 == 下标index2元素的值, 则index1++,index2++
	 *
	 * 时间: O(nlogn + mlogm)
	 * 额外空间：O(1)
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int index1 = 0;
		int index2 = 0;
		int[] res = new int[Math.min(nums1.length, nums2.length)];
		int idx = 0;

		while(index1 < nums1.length && index2 < nums2.length) {
			if(nums1[index1] < nums2[index2]) {
				index1++;
			} else if(nums1[index1] > nums2[index2]) {
				index2++;
			} else {
				res[idx++] = nums1[index1];
				index1++;
				index2++;
			}
		}

		return Arrays.copyOfRange(res, 0, idx);
	}

}
