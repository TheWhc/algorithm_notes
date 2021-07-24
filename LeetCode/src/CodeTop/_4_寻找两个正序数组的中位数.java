package CodeTop;

/**
 * @ClassName: _4_寻找两个正序数组的中位数
 * @Author: whc
 * @Date: 2021/07/24/17:06
 */
public class _4_寻找两个正序数组的中位数 {

	/*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];

		int p = 0;
		int q = 0;
		int idx = 0;
		while(p < nums1.length && q < nums2.length) {
			if(nums1[p] < nums2[q]) {
				nums[idx++] = nums1[p++];
			} else {
				nums[idx++] = nums2[q++];
			}
		}

		while(p < nums1.length) {
			nums[idx++] = nums1[p++];
		}

		while(q < nums2.length) {
			nums[idx++] = nums2[q++];
		}

		return nums.length % 2 == 1 ? nums[nums.length % 2] : (nums[nums.length % 2] + nums[nums.length % 2 + 1]) / 2;
	}*/


	/**
	 *
	 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/zhe-ban-shan-chu-xun-zhao-liang-ge-you-xu-shu-zu-d/
	 * 例子:
	 * A: 1 3 5 7 9 11 12 13 14    长度为9
	 * B: 2 4 6 8 10               长度为5
	 *
	 * 找中位数->找第k小的数,即第(9+5)/2=7小的数
	 *
	 * 从A数组中和B数组中找到第7小,第8小的数相加除以2
	 *
	 * 所以left = (14 + 1) / 2 = 7
	 * right = (14 + 2) / 2 = 8
	 *
	 * 第一次查找时, i和j = k/2 = 3 两个数组中第3个数字进行比较大小
	 * A: 1 3 5 7 9 11 12 13 14
	 *        i
	 * B: 2 4 6 8 10
	 *        j
	 *
	 * 5 < 6 所以删除第i个数字以及前面的所有数字,剩下的数组为
	 * A: 7 9 11 12 13 14
	 *
	 * B: 2 4 6 8 10
	 *
	 * 此时要找的第k小即第7小的数,变成了k-3=4,即要找第4小的数
	 *
	 * 第二次查找时, i和j = k/2 = 2 两个数组中第2个数字进行比较大小
	 * A: 7 9 11 12 13 14
	 *      i
	 * B: 2 4 6 8 10
	 *      j
	 *
	 * 4 < 9,所以删除第j个数字以及前面的所有数字,剩下的数组为
	 * A: 7 9 11 12 13 14
	 *
	 * B: 6 8 10
	 *
	 * 此时要找的第k小即第4小的数,变成了k-2=2,即要找第2小的数
	 *
	 * 第三次查找时, i和j = k/2 = 1 两个数组中第1个数字进行比较大小
	 * A: 7 9 11 12 13 14
	 *    i
	 * B: 6 8 10
	 *    j
	 *
	 * 6 < 7,所以删除第j个数字以及前面的所有数字,剩下的数组为
	 * A: 7 9 11 12 13 14
	 *
	 * B: 8 10
	 *
	 * 此时要找的第k小即第2小的数,变成了k-1=1,即要找第1小的数
	 *
	 *
	 * 第三次查找时, 由于k已经等于1了, 所以比较第i个数字和第j个数字大小,返回最小的数字
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int total = len1 + len2;
		int left = (total + 1) / 2;
		int right = (total + 2) / 2;

		return (findK(nums1, 0, nums2, 0, left) + findK(nums1, 0, nums2, 0, right)) / 2.0;
	}

	// 比较两个数组的第k/2个数字,哪个比较小,则前k/2个数都不是第k小数字,所以直接排除
	private double findK(int[] nums1, int i, int[] nums2, int j, int k) {
		// 这里的i,j相当于对k折半查找比较

		// 如果i此时大小已经超出数组大小,那么返回num2数组的第k小元素,即下标为j+k-1的元素
		if(i >= nums1.length) {
			return nums2[j + k - 1];
		}

		// 如果j此时大小已经超出数组大小,那么返回num1数组的第k小元素,即下标为i+k-1的元素
		if(j >= nums2.length) {
			return nums1[i + k - 1];
		}

		// 如果此时k大小已经等于1了,那么返回两个数组中i和j下标最小的数
		if(k == 1) {
			return Math.min(nums1[i], nums2[j]);
		}

		// 计算每次要比较的两个数的值,决定删除哪边的元素
		// 注意这里在进行两个数字中的第k/2个查找时,要判断是否越界,即是否超过各自的数组大小,如果超过,那么值就赋值为最大值,因为接下来的比较,就可以取数组的值
		int mid1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
		int mid2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

		if(mid1 < mid2) {
			return findK(nums1, i + k / 2, nums2, j, k - k/2);
		}

		return findK(nums1, i, nums2, j + k / 2, k - k / 2);
	}
}
