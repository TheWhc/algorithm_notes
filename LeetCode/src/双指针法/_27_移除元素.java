package 双指针法;

/**
 * @ClassName: _27_移除元素
 * @Author: whc
 * @Date: 2021/04/25/9:07
 */
public class _27_移除元素 {

	/*public int removeElement(int[] nums, int val) {
		int i = 0;
		int j = nums.length-1;
		while(i <= j) {
			if(nums[i] == val && nums[j] != val) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
				j--;
			} else if(nums[j] == val) {
				j--;
			} else {
				i++;
			}
		}
		return j+1;
	}*/

	public int removeElement(int[] nums, int val) {
		int slowIndex = 0;
		for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
			if(val != nums[fastIndex]) {
				nums[slowIndex++] = nums[fastIndex];
			}
		}
		return slowIndex;
	}
}
