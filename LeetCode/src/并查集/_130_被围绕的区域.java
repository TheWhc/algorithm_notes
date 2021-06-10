package 并查集;

import java.util.Arrays;

/**
 * @ClassName: _130_被围绕的区域
 * @Author: whc
 * @Date: 2021/05/18/11:21
 */
public class _130_被围绕的区域 {

	/**
	 * 思路
	 *
	 */

	class UnionFind {
		// 存储节点的根触点,一维
		int[] parents;
		int[] ranks;

		public UnionFind(int capacity) {
			parents = new int[capacity];
			ranks = new int[capacity];
			Arrays.fill(ranks, 1);
		}

		// 返回根触点
		// 路径压缩
		public int find(int x) {
			if(parents[x] == x) {
				return x;
			}
			return parents[x] = find(parents[x]);
		}

		// 按秩归并
		public void union(int x, int y) {
			int fx = find(x);
			int fy = find(y);

			if(fx == fy) return;

			// 树高的节点 不需要改变高度
			if(ranks[fx] < ranks[fy]) {
				parents[fx] = fy;
			} else if(ranks[fx] > ranks[fy]) {
				parents[fy] = fx;
			} else {
				// 两根树的高度一样
				parents[fx] = fy;
				ranks[fy] += 1;
			}
		}

		// 判断两个节点是否属于一个集合
		public boolean isConnected(int node1, int node2) {
			return find(node1) == find(node2);
		}
	}
	public void solve(char[][] board) {
		int n = board.length;
		if(n == 0) return;
		int m = board[0].length;
		if(m == 0) return;

		// +1的目的是 多出一个虚拟节点 处理边界问题(i=0  || i=n-1 || j=0 || j=m-1 时节点值为'0'的情况)
		UnionFind unionFind = new UnionFind(n * m + 1);
		// 虚拟节点
		unionFind.parents[n * m] = n * m;

		// 先初始化坐标值为'O'的节点的下标值 二维转化为一维
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(board[i][j] == 'O') {
					int index = i * m + j;
					unionFind.parents[index] = index;
				}
			}
		}

		// 遍历board数组,标记'O'节点的父节点,即合并节点
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(board[i][j] == 'O') {
					if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
						int index1 = i * m + j;
						int index2 = n * m;
						unionFind.union(index1, index2);
					} else {
						// 上下左右合并
						int index1 = i * m + j;
						if(board[i-1][j] == 'O') {
							int index2 = (i-1) * m + j;
							unionFind.union(index1, index2);
						}
						if(board[i+1][j] == 'O') {
							int index2 = (i+1) * m + j;
							unionFind.union(index1, index2);
						}
						if(board[i][j-1] == 'O') {
							int index2 = i * m + j - 1;
							unionFind.union(index1, index2);
						}
						if(board[i][j+1] == 'O') {
							int index2 = i * m + j + 1;
							unionFind.union(index1, index2);
						}
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(board[i][j] == 'O' && !unionFind.isConnected(i * m + j, n * m)) {
					board[i][j] = 'X';
				}
			}
		}
	}

	public static void main(String[] args) {
		char[][] array = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},
				{'O','X','O','O','O'},
				{'x','X','O','x','O'}};
		new _130_被围绕的区域().solve(array);
	}
}
