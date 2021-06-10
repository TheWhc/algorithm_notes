package 待分类;

/**
 * @ClassName: 待分类._33_搜索旋转排序数组
 * @Author: whc
 * @Date: 2021/03/18/1:37
 */
public class _33_搜索旋转排序数组 {

	// 3 4 5 6 7 | 0 1 2
	// 5 6 7 | 0 1 2 3 4
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;

		while(left <= right) {
			int mid = left + (right - left) / 2;

			if(nums[mid] == target) {
				return mid;
			}

			// 判断target在左半块升序还是右板块升序中
			// taget在左半块
			if(target >= nums[0]) {
				// 判断mid在左半块还是右半块
				// mid在左板块
				if(nums[mid] >= nums[0]) {
					if(nums[mid] < target) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
				// mid在右半块
				else {
					right = mid - 1;
				}
			}
			// target在右半块
			else {
				// 判断mid在左半块还是右半块
				// mid在右半块
				if(nums[mid] < nums[0]) {
					if(nums[mid] < target) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				} else {
					left = mid + 1;
				}
			}
		}

		return -1;
	}
}
