package 单调栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName: _496_下一个更大元素I
 * @Author: whc
 * @Date: 2021/07/13/10:57
 */
public class _496_下一个更大元素I {

	/**
	 * 思路: 暴力解法
	 *
	 */
	/*public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];

		for (int k = 0; k < nums1.length; k++) {
			for (int i = 0; i < nums2.length; i++) {
				if(nums2[i] == nums1[k]) {
					int j;
					for (j = i + 1; j < nums2.length; j++) {
						if(nums2[j] > nums1[k]) {
							res[k] = nums2[j];
						}
					}
					if(j == nums2.length) {
						res[k] = -1;
					}
				}
			}
		}

		return res;
	}*/

	/**
	 * 思路: 单调栈 + HashMap
	 * 1. HashMap中key为nums2元素,value在nums2比元素大的下一个右边元素
	 * 2. 倒叙遍历数组nums2,保持栈为单调递增(栈顶到栈底)
	 *
	 * 举例: nums1=[4,1,2], nums2=[1,3,4,2]
	 *      key  value
	 * map  2      -1
	 *      4      -1
	 *      3		4
	 *      1		3
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		HashMap<Integer, Integer> map = new HashMap<>();
		// 单调栈, 栈顶到栈底为单调递增
		Stack<Integer> stack = new Stack<>();

		for (int i = nums2.length - 1; i >= 0; i--) {
			while(!stack.isEmpty() && nums2[i] > stack.peek()) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				map.put(nums2[i], -1);
			} else {
				map.put(nums2[i], stack.peek());
			}
			stack.push(nums2[i]);
		}

		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.get(nums1[i]);
		}

		return res;
	}

}
