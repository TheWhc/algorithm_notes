package CodeTop;

/**
 * @ClassName: _81_搜索旋转排序数组II
 * @Author: whc
 * @Date: 2021/09/28/11:53
 */
public class _81_搜索旋转排序数组II {

	public boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		// 最先处理重复的数字
		while(left < right && nums[left] == nums[left + 1]) {
			left++;
		}

		while(left < right && nums[right] == nums[right-1]) {
			right--;
		}

		while(left < right) {
			// 1. 先分成两段排序的段,即找到最小值
			int mid = left + (right - left) / 2;
			if(nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		// 2. 判断target在哪个分段里面
		if(target <= nums[nums.length-1]) {
			// 在右边分段
			right = nums.length-1;
		} else {
			// 在左边分段
			left = 0;
		}

		// 3. 进行搜索
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				return true;
			} else if(nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return nums[left] == target;
	}

}
