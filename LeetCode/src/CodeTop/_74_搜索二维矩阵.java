package CodeTop;

/**
 * @ClassName: _74_搜索二维矩阵
 * @Author: whc
 * @Date: 2021/09/02/13:59
 */
public class _74_搜索二维矩阵 {

	/*public boolean searchMatrix(int[][] matrix, int target) {
		int left = 0;
		int right = matrix.length - 1;
		while(left < right) {
			int mid = left + (right - left + 1) / 2;
			if(matrix[mid][0] > target) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}

		int row = left;

		left = 0;
		right = matrix[0].length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(matrix[row][mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return matrix[row][left] == target;
	}*/

	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int col = matrix[0].length;

		for (int i = 0, j = col - 1; i < row && j >= 0;) {
			if(matrix[i][j] == target) {
				return true;
			} else if(matrix[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}

		return false;
	}
}
