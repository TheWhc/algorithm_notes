package 待分类;

/**
 * @ClassName: 待分类._704_二分查找
 * @Author: whc
 * @Date: 2021/03/21/21:46
 */
public class _704_二分查找 {

	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[mid] > target) {
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return -1;
	}

}
