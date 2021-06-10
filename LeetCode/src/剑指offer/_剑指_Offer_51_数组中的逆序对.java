package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_51_数组中的逆序对
 * @Author: whc
 * @Date: 2021/03/30/20:48
 */
public class _剑指_Offer_51_数组中的逆序对 {

	int res = 0;
	public int reversePairs(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int[] tmp = new int[nums.length];
		mergeSort(nums, 0, nums.length-1, tmp);
		return res;
	}

	private void mergeSort(int[] nums, int left, int right, int[] tmp) {
		if(left < right) {
			int mid = (left + right) >> 1;
			// 递归划分左区间
			mergeSort(nums, left, mid, tmp);
			// 递归划分右区间
			mergeSort(nums, mid+1, right, tmp);
			// 合并已经排好序的部分
			merge(nums, left, mid, right, tmp);
		}
	}

	private void merge(int[] nums, int left, int mid,  int right, int[] tmp) {
		// 标记左半区第一个未排序的元素
		int l_pos = left;
		// 标记右半区第一个未排序的元素
		int r_pos = mid+1;
		// 临时数组下标
		int pos = left;

		while(l_pos <= mid && r_pos <= right) {
			if(nums[l_pos] <= nums[r_pos]) {
				tmp[pos++] = nums[l_pos++];
			} else {
				res += mid - l_pos + 1;
				tmp[pos++] = nums[r_pos++];
			}
		}

		// 合并左区间剩余元素
		while(l_pos <= mid) {
			tmp[pos++] = nums[l_pos++];
		}

		// 合并右区间剩余元素
		while(r_pos <= right) {
			tmp[pos++] = nums[r_pos++];
		}

		// 拷贝临时数组到原数组中
		while(left <= right) {
			nums[left] = tmp[left++];
		}
	}
}
