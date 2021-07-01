package 双指针法.数组;

/**
 * @ClassName: _27_移除元素
 * @Author: whc
 * @Date: 2021/07/01/13:50
 */
public class _27_移除元素 {

	/**
	 * 思路: 双指针法
	 * 1. i指向新的数组下标
	 * 2. k指向旧的数组下标
	 * 3. 遇到nums[k] != val, 则将k下标对应的值赋值给i下标对应的值, 移动i指针
	 */
	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int k = 0; k < nums.length; k++) {
			if(nums[k] != val) {
				nums[i++] = nums[k];
			}
		}
		return i;
	}
}
