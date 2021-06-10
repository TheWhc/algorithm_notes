package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_29_顺时针打印矩阵
 * @Author: whc
 * @Date: 2021/04/02/17:48
 */
public class _剑指_Offer_29_顺时针打印矩阵 {

	/*public int[] spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return new int[0];
		int n = matrix.length * matrix[0].length;
		int[] res = new int[n];
		int count = 0;
		int flag = 1; // 1向右  2向下 3向左 4向上
		int x = 0, y = 0; // 坐标
		boolean[][] visit = new boolean[matrix.length][matrix[0].length];
		while(count < n) {
			// 越界判断
			if(y >= matrix[0].length || y < 0 || x >= matrix.length || x < 0 || visit[x][y]) {
				if(flag == 1) {
					y--;
					x++;
					flag = 2;
				} else if(flag == 2) {
					x--;
					y--;
					flag = 3;
				} else if(flag == 3) {
					y++;
					x--;
					flag = 4;
				} else {
					x++;
					y++;
					flag = 1;
				}
			} else {
				res[count] = matrix[x][y];
				count++;
				visit[x][y] = true;
				if(flag == 1) {
					y++;
				} else if(flag == 2) {
					x++;
				} else if(flag == 3) {
					y--;
				} else {
					x--;
				}
			}
		}

		return res;
	}*/


	/**
	 *  思路: 模拟打印
	 *  1. 每次一旦遍历到边界就转换方向,并且边界紧缩
	 *  2. 总共遍历四个方向
	 *  	左->右, res.append(matrix[top][i]),遍历到边界后,top下移
	 *  	上->下, res.append(matrix[i][right]),遍历到边界后,right左移
	 *      右->左, res.append(matrix[bottom][i]),遍历到边界后,bottom上移
	 *      下->上, res.append(matrix[i][left]),遍历到边界后,left右移
	 *
	 * 	时间: O(m*n)
	 * 	空间: O(1)
	 */
	public int[] spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return new int[0];
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[] res = new int[m * n];
		int count = 0;
		int left = 0;
		int right = n-1;
		int top = 0;
		int bottom = m-1;
		while(count < res.length) {
			// 左->右
			for (int i = left; i <= right; i++) {
				res[count++] = matrix[top][i];
			}
			top++;
			if(top > bottom) {
				break;
			}
			// 上->下
			for (int i = top; i <= bottom; i++) {
				res[count++] = matrix[i][right];
			}
			right--;
			if(left > right) {
				break;
			}
			// 右->左
			for (int i = right; i >= left; i--) {
				res[count++] = matrix[bottom][i];
			}
			bottom--;
			if(top > bottom) {
				break;
			}
			// 下->上
			for (int i = bottom; i >= top; i--) {
				res[count++] = matrix[i][left];
			}
			left++;
			if(left > right) {
				break;
			}
		}

		return res;
	}

}
