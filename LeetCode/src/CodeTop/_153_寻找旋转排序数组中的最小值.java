package CodeTop;

/**
 * @ClassName: _153_寻找旋转排序数组中的最小值
 * @Author: whc
 * @Date: 2021/07/21/13:50
 */
public class _153_寻找旋转排序数组中的最小值 {

	/**
	 *
	 * 比较中间元素 和 末尾元素
	 *
	 * 例子: 4 5 0 1 2 3
	 *      l   m     r
	 * 思路: 比较中间位置的值和末尾位置的值大小
	 * 1. 如果中间值比right值小,那么舍弃右部分,即r = m    (最小值有在左部分)
	 * 2. 如果中间值比right值大,那么舍弃左部分,即l = m + 1 比如 4 5 6 7 0 1 2  (最小值在右部分)
	 *                                                   l     m     r
	 */
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;

			// 舍弃左部分
			if(nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				// 舍弃右部分
				right = mid;
			}
		}

		return nums[left];
	}

	/**
	 * 比较中间元素和起始元素
	 *
	 * 例子: 4 5 0 1 2 3
	 *      l   m     r
	 * 思路: 比较中间位置的值和起始位置的值大小
	 * 1. 如果中间值比left值小,那么舍弃右部分,即r = m    (最小值有在左部分)
	 * 2. 如果中间值比left值大,分两种情况,最小值可能出现在左部分和右部分
	 *
	 * 当最小值出现在左部分时,比如 1 2 3 4 5 6
	 *                        l   m     r
	 *  那么最小值为起始位置,直接返回 return nums[left]
	 *
	 * 当最小值出现在右部分时,比如 6 7 8 9 0 1 2
	 * 						  l     m     r
	 *  那么最小值为右部分,所以要舍弃左部分,即l = m + 1
	 *
	 *  while (left < right) 用在要找的数的性质复杂的时候，把区间分成两个部分，在退出循环以后才可以返回；
	 */
	/*public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;

			if(nums[left] < nums[right]) {
				return nums[left];
			}

			// 舍弃左部分
			// 必须是大于等于,比如nums=[9,8], mid和left都指向了9
			if(nums[mid] >= nums[left]) {
				left = mid + 1;
			} else {
				// 舍弃右部分
				right = mid;
			}
		}

		return nums[left];
	}*/

	public static void main(String[] args) {
		_153_寻找旋转排序数组中的最小值 _153_寻找旋转排序数组中的最小值 = new _153_寻找旋转排序数组中的最小值();
		_153_寻找旋转排序数组中的最小值.findMin(new int[]{3,1,2});
	}
}
