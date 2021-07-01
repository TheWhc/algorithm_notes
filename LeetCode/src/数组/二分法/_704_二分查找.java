package 数组.二分法;

/**
 * @ClassName: _704_二分查找
 * @Author: whc
 * @Date: 2021/07/01/10:01
 */
public class _704_二分查找 {

	/**
	 * 思路: 二分查找
	 * 定义左闭右闭区间[left,right]
	 *
	 * 1. 计算mid = left + (right - left) / 2;  // 不写成(left + right)/2是为了防止整数溢出
	 * 2. 比较nums[mid]和目标值的大小关系
	 * 		 nums[mid] < target: left = mid + 1;
	 * 		 nums[mid] > target: right = mid - 1;
	 * 		 nums[mid] == target: return mid;
	 */
	public int search(int[] nums, int target) {
		int i = 0;
		int j = nums.length-1;

		while(i <= j) {
			int mid = i + (j - i) / 2;
			if(nums[mid] > target) {
				j = mid -1;
			} else if(nums[mid] < target) {
				i = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;
	}
}
