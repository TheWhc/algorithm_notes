package 待分类;

/**
 * @ClassName: 待分类._34_在排序数组中查找元素的第一个和最后一个位置
 * @Author: whc
 * @Date: 2021/03/24/10:56
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

	/*public int[] searchRange(int[] nums, int target) {
		int[] res = new int[]{-1,-1};
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if(nums[i] == target) {
				res[0] = i;
				break;
			}
		}
		for (int j = len-1; j >= 0; j--) {
			if(nums[j] == target) {
				res[1] = j;
				break;
			}
		}
		return res;
	}*/

	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[]{-1, -1};
		if(nums == null || nums.length == 0) {
			return res;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		if (nums[left] == target) {
			res[0] = left;
		} else {
			return res;
		}

		left = 0;
		right = nums.length - 1;
		while (left < right) {
			// 向上取整
			int mid = left + ((right - left + 1) >> 1);
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] == target) {
				left = mid;
			} else {
				left = mid + 1;
			}
		}
		res[1] = left;
		return res;
	}

	public static void main(String[] args) {
		int[] a = new int[]{5,7,7,8,8,10};
		searchRange(a,8);
	}
}
