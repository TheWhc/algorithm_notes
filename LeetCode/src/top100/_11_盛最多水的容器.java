package top100;

/**
 * @ClassName: _11_盛最多水的容器
 * @Author: whc
 * @Date: 2021/04/29/11:53
 */
public class _11_盛最多水的容器 {


	/**
	 * 思路: 暴力解法,直接遍历任意两根柱子,求出能存储的水
	 *
	 * 时间: O(n^2)  (超时)
	 * 空间: O(1)
	 */
	/*public int maxArea(int[] height) {
		int res = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i+1; j < height.length; j++) {
				int h = Math.min(height[i], height[j]);
				if(h * (j-i) > res) {
					res = h * (j-i);
				}
			}
		}
		return res;
	}*/


	/**
	 * 思路: 双指针法, 指针i,j位于两端,根据规则移动指针,更新最大面积res,直到i == j
	 * 规则: 移动短板的一端,可能得到最大值
	 * 若移动长板的一端,得到的面积一定小于等于S(i,j)
	 */
	public int maxArea(int[] height) {
		int i = 0, j = height.length-1;
		int res = 0;
		while(i < j) {
			int low = Math.min(height[i], height[j]);
			res = Math.max(res, (j-i)*low);
			if(height[i] == low) {
				i++;
			} else {
				j--;
			}
		}
		return res;
	}

}
