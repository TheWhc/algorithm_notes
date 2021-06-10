import java.util.ArrayList;

/**
 * @ClassName: _NC38_螺旋矩阵
 * @Author: whc
 * @Date: 2021/02/25/12:48
 */
public class _NC38_螺旋矩阵 {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		if(matrix == null)
			return null;
		ArrayList<Integer> res = new ArrayList<>();
		// 1表示向右 2表示向下 3表示向左 4表示向上
		int flag = 1;
		int x = 0, y = 0;
		int n = matrix[0].length * matrix.length;
		boolean[][] vis = new boolean[matrix.length][matrix[0].length];
		while(res.size() < n) {
			// 越界判断, 代表需要转变方向
			if(x >= matrix.length || y >= matrix[0].length || x < 0 || y < 0 || vis[x][y]) {
				if(flag == 1) {
					flag = 2;
					y--;
					x++;
				} else if(flag == 2) {
					flag = 3;
					x--;
					y--;
				} else if(flag == 3) {
					flag = 4;
					y++;
					x--;
				} else {
					flag = 1;
					x++;
					y++;
				}
			} else {
				res.add(matrix[x][y]);
				vis[x][y] = true;
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
	}
}
