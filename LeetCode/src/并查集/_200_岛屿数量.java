package 并查集;

import java.util.Arrays;

/**
 * @ClassName: 待分类._200_岛屿数量
 * @Author: whc
 * @Date: 2021/05/18/13:49
 *
 * 思路: 相邻的陆地(只需要向上和向左（保持两个方向就可以了）,只要发生过合并,岛屿的数量就减少1
 * 在初始化时,先记录所有陆地面积
 * 每合并一次,陆地面积减1,最后就是岛屿数量
 */
public class _200_岛屿数量 {

	class UnionFind {
		// 一维数组
		int[] parents;
		// 岛屿数量
		int size;
		// 节点树的高度
		int[] ranks;

		public UnionFind(int capacity) {
			this.parents = new int[capacity];
			this.ranks = new int[capacity];
			Arrays.fill(ranks,1);
		}

		// 优化 路径压缩 find上所有节点指向根触点
		public int find(int x) {
			if(parents[x] == x) return x;

			return parents[x] = find(parents[x]);
//			return find(parents[x]);
		}

		// 优化 按秩归并 树高度小的指向树高度大的
		public void union(int x, int y) {
			int fx = find(x);
			int fy = find(y);

			if(fx == fy) return;
			/*parents[fx] = fy;
			// 合并同一个区域的岛屿,数量减1
			size--;*/

			// 优化 按秩归并 树高度小的指向树高度大的
			if(ranks[fx] < ranks[fy]) {
				parents[fx] = fy;
			} else if(ranks[fx] > ranks[fy]) {
				parents[fy] = fx;
			} else {
				parents[fx] = fy;
				ranks[fy]++;
			}
			size--;
		}
	}

	public int numIslands(char[][] grid) {
		int n = grid.length;
		if(n == 0) return 0;
		int m = grid[0].length;
		if(m == 0) return 0;

		// 初始化大小为n * m
		UnionFind unionFind = new UnionFind(n * m);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(grid[i][j] == '1') {
					int index = i * m + j;
					// 将陆地初始化为下标值 指向自己
					unionFind.parents[index] = index;
					// 岛屿数量一开始初始化为所有1相加
					unionFind.size++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(grid[i][j] == '1') {
					// 左边为1
					if(j-1 >= 0 && grid[i][j-1] == '1') {
						int index1 = i * m + j;
						int index2 = i * m + j - 1;
						unionFind.union(index1, index2);
					}
					// 上边为1
					if(i-1 >= 0 && grid[i-1][j] == '1') {
						int index1 = i * m + j;
						int index2 = (i-1) * m + j;
						unionFind.union(index1, index2);
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(grid[i][j] == '1') {
					int index = i * m + j;
					System.out.print(unionFind.parents[index] + " ");
				}
			}
		}

		return unionFind.size;
	}

	public static void main(String[] args) {
		_200_岛屿数量 a = new _200_岛屿数量();
		char[][] array = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		a.numIslands(array);
	}

}
