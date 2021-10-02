package cvte;

/**
 * @ClassName: _11_二维数组中的查找
 * @Author: whc
 * @Date: 2021/10/01/13:40
 */
public class _11_二维数组中的查找 {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}

		int i = 0;
		int j = matrix[0].length - 1;
		while(i < matrix.length && j >= 0) {
			if(matrix[i][j] > target) {
				j--;
			} else if(matrix[i][j] < target) {
				i++;
			} else {
				return true;
			}
		}

		return false;
	}
}
