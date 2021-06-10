package 待分类;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._54_螺旋矩阵
 * @Author: whc
 * @Date: 2021/03/05/11:26
 */
public class _54_螺旋矩阵 {
	// 2021/3/5 二刷
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		boolean[][] visit = new boolean[matrix.length][matrix[0].length];
		int n = matrix.length * matrix[0].length;
		// 1表示向右 2表示向下 3表示向左 4表示向上
		int flag = 1;
		int x = 0, y = 0; // 坐标
		while(res.size() < n) {
			// 越界判断 或者 访问判断
			if(x >= matrix.length || x < 0 || y >= matrix[0].length || y < 0 || visit[x][y]) {
				if(flag == 1) {
					// 转为向下
					flag = 2;
					y--;
					x++;
				} else if(flag == 2) {
					// 转为向左
					flag = 3;
					y--;
					x--;
				} else if(flag == 3) {
					// 转为向上
					flag = 4;
					y++;
					x--;
				} else {
					// 转为向右
					flag = 1;
					x++;
					y++;
				}
			} else {
				visit[x][y] = true;
				res.add(matrix[x][y]);
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
