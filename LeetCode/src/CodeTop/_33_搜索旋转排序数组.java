package CodeTop;

/**
 * @ClassName: _33_搜索旋转排序数组
 * @Author: whc
 * @Date: 2021/07/21/11:56
 */
public class _33_搜索旋转排序数组 {

	// 将旋转数组中找目标值 转化为 有序数组中找目标值
	// 通过nums[mid]和nums[0]比较
	/*public int search(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;

		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == target) {
				return mid;
			}

			// 先根据 nums[0] 与 target 的关系判断目标值是在左半段还是右半段
			if(target >= nums[0]) {
				// 目标值在左半段,如果mid在右半段,需要将mid索引的值改为inf,保证左半段递增
				if(nums[mid] < nums[0]) {
					nums[mid] = Integer.MAX_VALUE;
				}
			} else {
				// 目标值在右半段,如果mid在左半段,需要将mid索引的值改为-inf,保证右半段递增,注意这里的等于也要判断进去
				if(nums[mid] >= nums[0]) {
					nums[mid] = Integer.MIN_VALUE;
				}
			}

			if(nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return -1;
	}*/


	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		// 找到最小值
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		if(target <= nums[nums.length-1]) {
			// left不变, target在最小值所在的单调边上
			right = nums.length - 1;
		} else {
			// target在另外一边
			left = 0;
			right--;
		}

		while(left < right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		if(nums[left] == target) {
			return left;
		}

		return -1;
	}

	public static void main(String[] args) {
		_33_搜索旋转排序数组 _33_搜索旋转排序数组 = new _33_搜索旋转排序数组();
		_33_搜索旋转排序数组.search(new int[]{1,3}, 3);
	}
}
