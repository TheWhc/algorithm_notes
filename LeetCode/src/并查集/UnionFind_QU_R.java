package 并查集;

import java.util.Arrays;

/**
 * 思路:  Quick Union Rank(按秩合并)
 * 合并的时候,如果fx和fy在两个不同的集合上,则将矮的树(树的高度)嫁接到高的树
 * 时间复杂度: 平均O(logn) 最坏O(logn)
 * 空间复杂度: 平均O(logn) 最坏O(logn)
 */
public class UnionFind_QU_R {

	// 所属集合,节点的根触点
	private int[] parents;

	// 树的高度
	private int[] ranks;

	public UnionFind_QU_R(int capacity) {
		this.parents = new int[capacity];
		this.ranks = new int[capacity];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
		// 初始化所有节点的高度为1
		Arrays.fill(ranks, 1);
	}

	// 返回一个节点所在集合的根触点
	public int find(int x) {
		// 当前节点为指向自身的节点,即根触点
		if(x == parents[x]) {
			return x;
		}
		// 如果当前节点不是根触点,则继续往上查找
		return find(parents[x]);
	}

	// 合并两个集合
	public void union(int x, int y) {
		// fx,fy为元素x,y所在的集合的根触点
		int fx = find(x);
		int fy = find(y);
		// 如果两个元素所在集合的根触点相同,说明已经在同一个集合内,不需要合并
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
}
