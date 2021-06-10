package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 剑指offer._剑指_Offer_21_调整数组顺序使奇数位于偶数前面
 * @Author: whc
 * @Date: 2021/04/02/10:19
 */
public class _剑指_Offer_21_调整数组顺序使奇数位于偶数前面 {

	// 2021/4/2 二刷
	/*public int[] exchange(int[] nums) {
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		for (int num : nums) {
			if(num % 2 == 0) {
				even.add(num);
			} else {
				odd.add(num);
			}
		}

		int[] res = new int[nums.length];
		for (int i = 0; i < odd.size(); i++) {
			res[i] = odd.get(i);
		}
		for (int i = odd.size(); i < nums.length; i++) {
			res[i] = even.get(nums.length -1 - i);
		}

		return res;
	}*/

	/*public static int[] exchange(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while(left < right) {
			while(left < right && nums[left] % 2 == 1) {
				left++;
			}
			while(left < right && nums[right] % 2 == 0) {
				right--;
			}
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
		}

		return nums;
	}*/


	/**
	 *  思路: 头尾双指针
	 *  1. left指向数组头,right指向数组尾
	 *  2. left右移直到遇到偶数
	 *  3. right左移直到遇到奇数
	 *  4. 如果此时left > right 则结束循环
	 *  5. 交换left和right所指数字
	 *  6. 继续以上步骤,直到left > right
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	public static int[] exchange(int[] nums) {
		if(nums == null || nums.length == 0) {
			return new int[0];
		}
		int left = 0;
		int right = nums.length-1;
		while(left < right) {
			// 左边索引一直递增,直到找到偶数为止
			while(left < right && nums[left] % 2 == 1) {
				left++;
			}
			// 右边索引一直递减,直到找到奇数为止
			while(left < right && nums[right] % 2 == 0) {
				right--;
			}
			if(left > right) {
				break;
			}
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
		}
		return nums;
	}

	public static void main(String[] args) {
		exchange(new int[]{1,3,2,4});
	}
}
