package CodeTop;

/**
 * @ClassName: _498_对角线遍历
 * @Author: whc
 * @Date: 2021/07/29/16:43
 */
public class _498_对角线遍历 {

	public int[] findDiagonalOrder(int[][] mat) {
		if(mat.length == 0) {
			return new int[0];
		}

		int m = mat.length;
		int n = mat[0].length;
		int count = m + n - 1; // 趟数

		int x = 0; // 横
		int y = 0; // 纵
		int cnt = 0;

		int[] res = new int[m * n];
		int idx = 0;

		while(cnt < count) {
			// 右上方
			if(cnt % 2 == 0) {
				while(x >= 0 && y < n) {
					res[idx++] = mat[x][y];
					x--;
					y++;
				}
				// 越界情况, 转换方向, 注意这里分两种越界情况
				if(y < n) {
					x++;
				} else {
					// y >= n
					y--;
					x += 2;
				}
			} else {
				// 左下方
				while(x < m && y >= 0) {
					res[idx++] = mat[x][y];
					x++;
					y--;
				}

				// 越界情况, 转换方向, 注意这里也分两种越界情况
				if(x < m) {
					y++;
				} else {
					// y >= 0
					x--;
					y += 2;
				}
			}
			cnt++;
		}
		return res;
	}

	public static void main(String[] args) {
		_498_对角线遍历 _498_对角线遍历 = new _498_对角线遍历();
		_498_对角线遍历.findDiagonalOrder(new int[][]{{0}});
	}
}
