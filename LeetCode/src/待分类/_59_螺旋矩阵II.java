package 待分类;

/**
 * @ClassName: 待分类._59_螺旋矩阵II
 * @Author: whc
 * @Date: 2021/03/29/2:04
 */
public class _59_螺旋矩阵II {

	public static int[][] generateMatrix(int n) {
		int x = 0, y = 0;
		boolean[][] visit = new boolean[n][n];
		int flag = 1; // 1代表向右 2向下 3向左 4向上
		int count = 1;
		int[][] arr = new int[n][n];
		while(count <= n * n) {
			// 超过边界
			if(x >= n || x < 0 || y >= n || y < 0 || visit[x][y]) {
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
				arr[x][y] = count;
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
				count++;
			}
		}

		int[][] res = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				res[i][j] = arr[i][j];
			}
		}

		return res;
	}

	public static void main(String[] args) {
		generateMatrix(3);
	}
}
