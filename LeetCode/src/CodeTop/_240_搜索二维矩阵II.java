package CodeTop;

/**
 * @ClassName: _240_搜索二维矩阵II
 * @Author: whc
 * @Date: 2021/07/25/18:31
 */
public class _240_搜索二维矩阵II {
/*

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}

		// 1. 先找到目标值行的位置

		for (int i = 0; i < matrix.length; i++) {
			// 每行的第一个元素值大于目标值的话,若没有找到,提前结束返回false
			if(matrix[i][0] > target) {
				break;
			}

			// 每行的最后一个元素值小于目标值的话,则当前行都不符合,那么继续循环下一行
			if(matrix[i][matrix[0].length-1] < target) {
				continue;
			}

			// 尝试每行进行二分查找
			if(binarySearch(matrix, i, target)) {
				return true;
			}
		}

		return false;
	}

	private boolean binarySearch(int[][] matrix, int row, int target) {
		int left = 0;
		int right = matrix[0].length;

		while(left < right) {
			int mid = left + (right - left) / 2;
			if(matrix[row][mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		if(matrix[row][left] != target) {
			return false;
		}

		return true;
	}
*/


	/**
	 *  类BST
	 *  从右上角出发
	 *
	 * 当前节点大于目标值，搜索当前节点的左子树，也就是当前位置的左侧格子
	 * 当前节点小于目标值，搜索当前节点的右子树，也就是当前位置的右侧格子
	 */
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
