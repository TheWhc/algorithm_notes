package CodeTop;

/**
 * @ClassName: _剑指_Offer_53_在排序数组中查找数字I
 * @Author: whc
 * @Date: 2021/09/08/22:06
 */
public class _剑指_Offer_53_在排序数组中查找数字I {

	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		if(nums[left] != target) {
			return 0;
		}

		int leftIdx = left;

		left = 0;
		right = nums.length - 1;
		while(left < right) {
			int mid = left + (right - left + 1) / 2;
			if(nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}

		if(nums[left] != target) {
			return 1;
		} else {
			return left - leftIdx + 1;
		}
	}
}
