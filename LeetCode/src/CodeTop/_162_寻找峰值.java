package CodeTop;

/**
 * @ClassName: _162_寻找峰值
 * @Author: whc
 * @Date: 2021/07/26/10:39
 */
public class _162_寻找峰值 {

	/*public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = left + (right - left + 1) / 2;
			if(nums[mid] > nums[mid-1]) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}*/

	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] > nums[mid+1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

}
