package CodeTop;

/**
 * @ClassName: _912_排序数组
 * @Author: whc
 * @Date: 2021/07/26/11:40
 */
public class _912_排序数组 {

	/*public int[] sortArray(int[] nums) {

		// 原地建堆
		for (int i = nums.length / 2 - 1; i >= 0; i--) {
			heapify(nums, nums.length, i);
		}

		// 排序,交换堆顶元素和末尾元素
		for (int i = nums.length - 1; i > 0; i--) {
			swap(nums, i, 0);
			// 交换后,维护堆的性质
			heapify(nums, i, 0);
		}

		return nums;
	}

	private void heapify(int[] nums, int n, int i) {
		int largest = i;
		int lson = i * 2 + 1;
		int rson = i * 2 + 2;

		if(lson < n && nums[largest] < nums[lson]) {
			largest = lson;
		}
		if(rson < n && nums[largest] < nums[rson]) {
			largest = rson;
		}

		if(largest != i) {
			swap(nums, i, largest);
			// 交换后的largest位置继续heapify
			heapify(nums, n, largest);
		}
	}

	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}*/

	// 归并排序
	// 平均时间: O(nlogn)
	// 空间： O(n)
	public int[] sortArray(int[] nums) {
		int[] newArray = new int[nums.length];
		merge(nums, 0, nums.length-1, newArray);
		return nums;
	}

	private void merge(int[] nums, int left, int right, int[] newArray) {
		if(left < right) {
			int mid = left + (right - left) / 2;
			merge(nums, left, mid, newArray);
			merge(nums, mid+1, right, newArray);

			mergeSort(nums, left, mid, right, newArray);
		}
	}

	private void mergeSort(int[] nums, int left, int mid, int right, int[] newArray) {
		int l_pos = left;
		int r_pos = mid + 1;
		int pos = 0;

		while(l_pos <= mid && r_pos <= right) {
			if(nums[l_pos] < nums[r_pos]) {
				newArray[pos++] = nums[l_pos++];
			} else {
				newArray[pos++] = nums[r_pos++];
			}
		}

		while(l_pos <= mid) {
			newArray[pos++] = nums[l_pos++];
		}

		while(r_pos <= right) {
			newArray[pos++] = nums[r_pos++];
		}

		for (int i = left; i <= right; i++) {
			nums[i] = newArray[i];
		}
	}
}
