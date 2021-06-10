package 并查集;

import java.util.Arrays;

/**
 * 思路:  Quick Union
 * 合并的时候,如果fx和fy在两个不同的集合上,则将fx指向fy
 * 时间复杂度: 平均O(logn) 最坏O(n)->退化成链表
 * 空间复杂度: 平均O(logn) 最坏O(n)->退化成链表
 */
public class UnionFind_QU {

	private int[] parents;

	public UnionFind_QU(int capacity) {
		this.parents = new int[capacity];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
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
		// 将x所在集合的根触点fx指向另一个根触点fy
		parents[fx] = fy;
	}
}
