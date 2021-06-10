package 滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 剑指offer._剑指_Offer_57_II_和为s的连续正数序列
 * @Author: whc
 * @Date: 2021/04/02/1:03
 */
public class _剑指_Offer_57_II_和为s的连续正数序列 {

	/**
	 *  思路: 滑动窗口
	 *	1. 使用两个指针left和right, left指向1,right指向1,分别表示窗口左边界和右边界,然后计算窗口内元素的和
	 * 	2. 如果窗口内的值大于target,说明窗口大了,left右移
	 * 	   如果窗口内的值小于target,说明窗口小了,right右移
	 * 	   如果窗口内的值等于target,说明找到了一组序列,加入到列表中
	 *
	 *  记住左闭右开区间,找到一组序列时,此时right值是右边界,不纳入范围内
	 *
	 *  左闭右开区间
	 */
	/*public int[][] findContinuousSequence(int target) {
		List<int[]> res = new ArrayList<>();
		int left = 1; // 滑动窗口左边界
		int right = 1; // 滑动窗口右边界
		int sum = 0;
		while(left <= target/2) {
			if(sum < target) {
				sum += right;
				right++;
			} else if(sum > target) {
				sum -= left;
				left++;
			} else {
				int[] tmp = new int[right-left];
				for (int k = left; k < right; k++) {
					tmp[k - left] = k;
				}
				res.add(tmp);
				sum -= left;
				left++;
			}
		}

		return res.toArray(new int[res.size()][]);
	}*/


	/**
	 *  思路: 滑动窗口
	 *	1. 使用两个指针left和right, left指向1,right指向2,分别表示窗口左边界和右边界,然后计算窗口内元素的和
	 * 	2. 如果窗口内的值大于target,说明窗口大了,left右移
	 * 	   如果窗口内的值小于target,说明窗口小了,right右移
	 * 	   如果窗口内的值等于target,说明找到了一组序列,加入到列表中
	 *
	 *  左闭右闭区间
	 */
	public int[][] findContinuousSequence(int target) {
		List<int[]> res = new ArrayList<>();
		int left = 1; // 滑动窗口左边界
		int right = 2; // 滑动窗口右边界
		int sum = left + right;
		while(left <= target/2) {
			if(sum < target) {
				sum += ++right;
			} else if(sum > target) {
				sum -= left;
				left++;
			} else {
				int[] tmp = new int[right-left+1];
				for (int k = left; k <= right; k++) {
					tmp[k - left] = k;
				}
				res.add(tmp);
				sum -= left;
				left++;
			}
		}

		return res.toArray(new int[res.size()][]);
	}
}
