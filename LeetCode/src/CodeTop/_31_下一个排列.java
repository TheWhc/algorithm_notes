package CodeTop;

import java.util.Arrays;

/**
 * @ClassName: _31_下一个排列
 * @Author: whc
 * @Date: 2021/07/23/16:18
 */
public class _31_下一个排列 {

	/**
	 * 思路:
	 * 例子: 1 2 3 4 6 5
	 *            i j
	 * 尽可能小的【大数】与前面的【小数】交换，比如这里是4和5交换,而不是4和6交换
	 *
	 * 1. 从后向前找第一个相邻升序的元素对(i,j)
	 * 2. 然后在[j,end)从后向前找第一个大于A[i]的值A[k],这里A[i]为4,A[k]为5
	 * 3. 将A[i]和A[k]交换, 此时变成1 2 3 5 6 4
	 * 4. 将[j,end)进行升序, 此时变成1 2 3 5 4 6
	 */
	public void nextPermutation(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}

		int i;
		for (i = nums.length-1; i > 0; i--) {
			if(nums[i] > nums[i-1]) { // 找到相邻升序
				for (int j = nums.length-1; j >= i; j--) {
					if(nums[j] > nums[i-1]) {
						int temp = nums[i-1];
						nums[i-1] = nums[j];
						nums[j] = temp;
						Arrays.sort(nums, i, nums.length);
						return;
					}
				}
			}
		}

		Arrays.sort(nums);
	}

}
