package 并查集;

/**
 * 为什么要进行路径压缩？
 * 因为一条路径高度可能越来越高,查找效率可能变慢
 *
 * 如何实现?
 * 在find操作进行实现
 *
 * 思路: Quick Union + Path Compression(路径压缩)
 * 合并的时候,如果fx和fy在两个不同的集合上,则将fx指向fy
 *
 * 路径压缩: 在find时使路径上的所有节点都指向根节点,从而降低树的高度
 *
 * 时间复杂度: 平均O(α(n)) 最坏O(logn)
 * 空间复杂度: 平均O(α(n)) 最坏O(logn)
 */
public class UnionFind_QU_PC {

	private int[] parents;

	public UnionFind_QU_PC(int capacity) {
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

		// 在find时使路径上的所有节点都指向根节点,从而降低树的高度
		// 如果当前节点不是根触点,则继续往上查找
		return parents[x] = find(parents[x]);
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
