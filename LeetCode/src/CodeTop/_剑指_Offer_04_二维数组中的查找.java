package CodeTop;

/**
 * @ClassName: _剑指_Offer_04_二维数组中的查找
 * @Author: whc
 * @Date: 2021/09/08/21:11
 */
public class _剑指_Offer_04_二维数组中的查找 {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}

		int i = 0, j = matrix[0].length - 1;

		while(i < matrix.length && j >= 0) {
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
