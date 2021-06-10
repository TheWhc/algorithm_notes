package top100;

/**
 * @ClassName: _283_移动零
 * @Author: whc
 * @Date: 2021/05/01/23:12
 */
public class _283_移动零 {

	// 暴力 双层for循环
	/*public void moveZeroes(int[] nums) {
		int len = nums.length;
		int n = len;
		int j = len - 1;
		while(j >= 0) {
			if(nums[j] == 0) {
				for (int k = j; k < n-1; k++) {
					int temp = nums[k];
					nums[k] = nums[k+1];
					nums[k+1] = temp;
				}
				n--;
			}
			j--;
		}
	}*/

	// 双指针法
	public void moveZeroes(int[] nums) {
		int slow = 0;
		for (int fast = 0; fast < nums.length; fast++) {
			if(nums[fast] != 0) {
				nums[slow++] = nums[fast];
			}
		}

		// 将slow后面冗余元素为0
		for (int i = slow; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
