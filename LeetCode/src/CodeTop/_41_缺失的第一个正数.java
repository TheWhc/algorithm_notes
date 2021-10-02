package CodeTop;

/**
 * @ClassName: _41_缺失的第一个正数
 * @Author: whc
 * @Date: 2021/07/24/23:16
 */
public class _41_缺失的第一个正数 {

//	public int firstMissingPositive(int[] nums) {
//
//		for (int i = 0; i < nums.length; i++) {
//			while(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]-1]) {
//				int temp = nums[i]; // 3
//				nums[i] = nums[nums[i]-1]; // nums[0] = -1
//				nums[temp-1] = temp; // nums[3-1] = 3
//			}
//		}
//
//		for (int i = 0; i < nums.length; i++) {
//			if(nums[i] != i + 1) {
//				return i + 1;
//			}
//		}
//
//		return nums.length + 1;
//	}

	public int firstMissingPositive(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			while(nums[i] != i + 1 && nums[i] >= 1 && nums[i] <= nums.length) {
				swap(nums, i, nums[i]-1);
			}
		}

		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != i+1) {
				return i + 1;
			}
		}

		return nums.length;
	}

	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}

	public static void main(String[] args) {
		_41_缺失的第一个正数 _41_缺失的第一个正数 = new _41_缺失的第一个正数();
		_41_缺失的第一个正数.firstMissingPositive(new int[]{1});
	}
}
