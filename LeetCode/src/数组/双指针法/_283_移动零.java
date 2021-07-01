package 数组.双指针法;

/**
 * @ClassName: _283_移动零
 * @Author: whc
 * @Date: 2021/07/01/14:02
 */
public class _283_移动零 {

	/**
	 * 思路: 双指针法
	 * 1. i指向新数组元素的下标
	 * 2. k指向旧数组元素的下标
	 * 3. 一旦k下标对应的值不等于0,则将k下标对应的值赋值给i下标对应的值, 移动i指针
	 * 4. 遍历完k后,再从i指向下标遍历,将后面的元素都赋值为0
	 */
	public void moveZeroes(int[] nums) {
		int i = 0;
		for (int k = 0; k < nums.length; k++) {
			if(nums[k] != 0) {
				nums[i++] = nums[k];
			}
		}

		for (int k = i; k < nums.length; k++) {
			nums[k] = 0;
		}
	}
}
