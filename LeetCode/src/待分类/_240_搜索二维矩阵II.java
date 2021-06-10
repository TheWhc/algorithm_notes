package 待分类;

/**
 * @ClassName: 待分类._240_搜索二维矩阵II
 * @Author: whc
 * @Date: 2021/03/20/16:29
 */
public class _240_搜索二维矩阵II {

/*	public boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == target) {
					return true;
				}
			}
		}

		return false;
	}*/

	/*public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}

		int x = 0;
		int y = matrix[0].length-1;
		while(x < matrix.length && y >= 0) {
			if(matrix[x][y] == target) {
				return true;
			}
			if(matrix[x][y] > target) {
				y--;
			} else {
				x++;
			}
		}

		return false;
	}*/

	// 二分查找
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}

		for (int i = 0; i < matrix.length; i++) {
			// 行的第一个元素大于target 提前结束
			if(matrix[i][0] > target) {
				break;
			}
			// 行的最后一个元素小于target 当前行提前结束
			if(matrix[i][matrix[0].length-1] < target) {
				continue;
			}
			// 二分查找
			int col = binarySearch(matrix[i], target);
			if(col != -1) {
				return true;
			}
		}

		return false;
	}

	private int binarySearch(int[] matrix, int target) {
		int left = 0;
		int right = matrix.length-1;
		while(left <= right) {
			int mid = (left + right) >> 1;
			if(matrix[mid] == target) {
				return mid;
			}
			if(matrix[mid] > target) {
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return -1;
	}
}
