package 待分类;

/**
 * @ClassName: 待分类._162_寻找峰值
 * @Author: whc
 * @Date: 2021/04/06/9:33
 */
public class _162_寻找峰值 {

	/*public int findPeakElement(int[] nums) {
		if(nums.length == 1) {
			return 0;
		}

		if(nums.length == 2) {
			if(nums[0] < nums[1]) {
				return 1;
			} else {
				return 0;
			}
		}
		for (int i = 1; i < nums.length-1; i++) {
			if(nums[i] > nums[i-1]  && nums[i] > nums[i+1]) {
				return i;
			}
		}
		if(nums[0] < nums[nums.length-1]) {
			return nums.length - 1;
		} else {
			return 0;
		}
	}*/

	/*public int findPeakElement(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] > nums[i+1]) {
				return i;
			}
		}

		return nums.length - 1;
	}*/

	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (nums[mid] > nums[mid + 1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}


	public static void main(String[] args) {
		System.out.println(new _162_寻找峰值().findPeakElement(new int[]{6, 4, 1, 5, 8}));
	}


}
