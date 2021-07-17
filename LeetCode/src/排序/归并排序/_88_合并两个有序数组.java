package 排序.归并排序;

/**
 * @ClassName: _88_合并两个有序数组
 * @Author: whc
 * @Date: 2021/07/17/17:06
 */
public class _88_合并两个有序数组 {


	/**
	 * 思路：按照归并排序最后归并的思路
	 * 1. 对已经排好顺序的区间, l_pos指向左半区的第一个元素下标, r_pos指向右半区的第一个元素下标
	 * 2. 比较元素大小然后插入到新数组中,post记录新数组下标
	 *
	 * 时间: O(m+n)
	 * 空间: O(m+n)
	 */
	/*public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int l_pos = 0; // 左半区第一个元素下标
		int r_pos = 0; // 右半区第一个元素下标
		int[] newArray = new int[m+n];
		int post = 0; // 合并后新数组的下标
		while(l_pos < m && r_pos < n) {
			if(nums1[l_pos] < nums2[r_pos]) {
				newArray[post++] = nums1[l_pos++];
			} else {
				newArray[post++] = nums2[r_pos++];
			}
		}

		while(l_pos < m) {
			newArray[post++] = nums1[l_pos++];
		}

		while(r_pos < n) {
			newArray[post++] = nums2[r_pos++];
		}

		for(int i = 0; i < nums1.length; i++) {
			nums1[i] = newArray[i];
		}
	}*/


	/**
	 * 思路：从数组nums1的最后一个位置开始赋值
	 *
	 * 时间: O(m+n)
	 * 空间：O(1)
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int post = m + n - 1;
		m -= 1;
		n -= 1;
		while(m >= 0 && n >= 0) {
			if(nums1[m] < nums2[n]) {
				nums1[post--] = nums2[n--];
			} else {
				nums1[post--] = nums1[m--];
			}
		}

		while(n >= 0) {
			nums1[post--] = nums2[n--];
		}
	}

	public static void main(String[] args) {
		_88_合并两个有序数组 _88_合并两个有序数组 = new _88_合并两个有序数组();
		_88_合并两个有序数组.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
	}
}
