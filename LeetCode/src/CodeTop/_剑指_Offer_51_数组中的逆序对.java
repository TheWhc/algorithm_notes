package CodeTop;

/**
 * @ClassName: _剑指_Offer_51_数组中的逆序对
 * @Author: whc
 * @Date: 2021/08/02/11:11
 */
public class _剑指_Offer_51_数组中的逆序对 {

	int res = 0;
	public int reversePairs(int[] nums) {
		if(nums == null || nums.length == 0) {
			return res;
		}
		int[] newArray =  new int[nums.length];
		mergeSort(nums, 0, nums.length-1, newArray);
		return res;
	}

	private void mergeSort(int[] nums, int left, int right, int[] newArray) {
		if(left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(nums, left, mid, newArray);
			mergeSort(nums, mid + 1, right, newArray);
			merge(nums, left, mid, right, newArray);
		}
	}

	private void merge(int[] nums, int left, int mid, int right, int[] newArray) {
		int left_pos = left;
		int right_pos = mid + 1;
		int pos = left;

		while(left_pos <= mid && right_pos <= right) {
			if(nums[left_pos] <= nums[right_pos]) {
				newArray[pos++] = nums[left_pos];
				left_pos++;
			} else {
				newArray[pos++] = nums[right_pos];
				right_pos++;
				res = res + (mid - left_pos + 1);
			}
		}

		while(left_pos <= mid) {
			newArray[pos++] = nums[left_pos++];
		}

		while(right_pos <= right) {
			newArray[pos++] = nums[right_pos++];
		}

		for (int i = left; i <= right; i++) {
			nums[i] = newArray[i];
		}
	}
}
