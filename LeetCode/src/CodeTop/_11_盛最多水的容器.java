package CodeTop;

/**
 * @ClassName: _11_盛最多水的容器
 * @Author: whc
 * @Date: 2021/09/11/1:03
 */
public class _11_盛最多水的容器 {

	/**
	 * 思路: 双指针法
	 *
	 * 木桶容量由短板决定,移动长板不可能再上升且宽度变小了,所以只能通过移动短板,才有可能使水位上升
	 *
	 */
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		while(left < right) {
			int lowHeight = Math.min(height[left], height[right]);
			maxArea = Math.max((right - left) * lowHeight, maxArea);
			if(lowHeight == height[left]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}
}
