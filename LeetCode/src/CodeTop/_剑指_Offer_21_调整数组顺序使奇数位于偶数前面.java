package CodeTop;

/**
 * @ClassName: _剑指_Offer_21_调整数组顺序使奇数位于偶数前面
 * @Author: whc
 * @Date: 2021/07/26/15:40
 */
public class _剑指_Offer_21_调整数组顺序使奇数位于偶数前面 {

	public int[] exchange(int[] nums) {
		int left = 0;
		int right = nums.length-1;

		while(left < right) {

			// 找到偶数
			while(left < right && nums[left] % 2 != 0) {
				left++;
			}

			// 找到奇数
			while(left < right && nums[right] % 2 == 0) {
				right--;
			}

			swap(nums, left, right);
			left++;
			right--;
		}

		return nums;
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}
