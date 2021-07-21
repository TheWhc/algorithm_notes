package 二分法.二分下标;

/**
 * @ClassName: _74_搜索二维矩阵
 * @Author: whc
 * @Date: 2021/07/21/20:17
 */
public class _74_搜索二维矩阵 {

	/*public boolean searchMatrix(int[][] matrix, int target) {
		int left = 0;
		int right = matrix.length - 1;

		if(matrix.length > 1) {
			while (left < right) {
				int mid = left + (right - left + 1) / 2;
				if (matrix[mid][0] > target) {
					right = mid - 1;
				} else {
					left = mid;
				}
			}
		}

		int row = left;

		left = 0;
		right = matrix[row].length-1;

		while(left < right) {
			int mid = left + (right - left) / 2;
			if (matrix[row][mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		int col = left;

		if(matrix[row][col] == target) {
			return true;
		}

		return false;
	}*/

	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int left = 0;
		int right = m * n - 1;

		while(left < right) {
			int mid = left + (right - left) / 2;
			if(matrix[mid / m][mid % n] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		if(matrix[left / m][left % n] == target) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		_74_搜索二维矩阵 _74_搜索二维矩阵 = new _74_搜索二维矩阵();
		System.out.println(_74_搜索二维矩阵.searchMatrix(new int[][]{{1}, {3}}, 3));
	}
}
