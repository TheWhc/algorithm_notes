package 数学;

/**
 * @ClassName: _836_矩形重叠
 * @Author: whc
 * @Date: 2021/07/16/12:04
 */
public class _836_矩形重叠 {

	/**
	 * 思路：二维重叠转化为一维重叠(区间重叠)
	 * 1. 不重叠条件: e1 <= s2 || e2 <= s1
	 * 2. 重叠取反即可
	 * 3. 将x,y轴的坐标转化为一维
	 */
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		boolean x_overlap = !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]);
		boolean y_overlap = !(rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
		return x_overlap && y_overlap;
	}
}
