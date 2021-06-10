package 剑指offer;

/**
 * @ClassName: _剑指_Offer_04_二维数组中的查找
 * @Author: whc
 * @Date: 2021/05/22/9:52
 */
public class _剑指_Offer_04_二维数组中的查找 {

	// 暴力解法,时间复杂度O(n*m) 空间复杂度O(1)
	/*public boolean findNumberIn2DArray(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == target) {
					return true;
				}
			}
		}

		return false;
	}*/

	/**
	 * 思路: 二分查找
	 * 枚举每行的最后一个元素x,进行二分查找
	 * 如果 x == target, 则直接返回
	 * 如果 x > target, 则排除当前整一列(纵坐标减1)
	 * 如果 x < target, 则排除当前整一行(横坐标加1)
	 *
	 * 时间复杂度: O(n+m)
	 * 空间复杂度: O(1)
	 */
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}

		int i = 0, j = matrix[0].length-1;
		while(i <= matrix.length && j >= 0) {
			if(matrix[i][j] == target) {
				return true;
			} else if(matrix[i][j] > target) {
				j--;
			} else {
				i++;
			}
		}

		return false;
	}
}
