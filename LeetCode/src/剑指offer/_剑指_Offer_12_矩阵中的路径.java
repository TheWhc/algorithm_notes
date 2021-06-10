package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _剑指_Offer_12_矩阵中的路径
 * @Author: whc
 * @Date: 2021/05/24/10:16
 */
public class _剑指_Offer_12_矩阵中的路径 {

	/**
	 *
	 * 思路: 深度优先搜索
	 *  1. 枚举矩阵中每个位置
	 *  2. 然后从当前位置开始深度优先搜索,从上下左右四个方向开始搜索
	 *  3. 过程中把遍历过的位置设置为一个特殊的标志符
	 * 时间复杂度: O(MN * k^3)
	 * 		需要枚举MN个起点,时间复杂度为(MN)
	 * 		方案数计算： 设字符串长度为 K ，搜索中每个字符有上、下、左、右四个方向可以选择，舍弃回头（上个字符）的方向，剩下 3 种选择，因此方案数的复杂度为 O(3^K)
	 * 空间复杂度: O(K)
	 * 		最差K=MN
	 */
	int[] dx = {-1, 0, 1, 0}; // 上右下左
	int[] dy = {0, 1, 0, -1};
	public boolean hasPath (char[][] matrix, String word) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}
		// 遍历矩阵中的每个元素,判断路径是否可达
		for(int i = 0; i< matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(dfs(matrix, word, i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(char[][] matrix, String word, int x, int y, int k) {
		// 不满足
		if(matrix[x][y] != word.charAt(k)) {
			return false;
		}
		if(k == word.length() - 1) {
			return true;
		}
		char temp = matrix[x][y];
		matrix[x][y] = '/';
		// 上下左右四个方向
		for(int i = 0; i < 4; i++) {
			int a = x + dx[i];
			int b = y + dy[i];
			if(a >= 0 && a < matrix.length && b >= 0 && b < matrix[0].length) {
				if(dfs(matrix, word, a, b, k+1)) {
					return true;
				}
			}
		}
		// 若不满足,则进行回溯
		matrix[x][y] = temp;
		return false;
	}
}
