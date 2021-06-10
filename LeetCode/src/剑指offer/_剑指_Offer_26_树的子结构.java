package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _剑指_Offer_26_树的子结构
 * @Author: whc
 * @Date: 2021/05/28/9:49
 */
public class _剑指_Offer_26_树的子结构 {


	/**
	 *  思路: 递归法/DFS
	 *
	 *  1. 遍历树A的节点,寻找与B根节点相同的节点
	 *  2. 如果nodeA.val = nodeB.val,说明已经找到一个相同的节点,进入helper方法判断接下来的节点是否相同
	 *  	相同,则返回true,不相同则继续遍历A,找到下一个相同的节点
	 *  3. 继续遍历nodeA的左右节点，只要两者有一个为true则返回true
	 *  时间: O(n*m)  n为A树节点数量,m为B树节点数量
	 *  空间: O(m)
	 */
	/*TreeNode nodeB;
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if(B == null) {
			return false;
		}
		this.nodeB = B;
		return dfs(A);
	}

	// 找到A中与B的第一个节点相同的节点
	// 前序遍历: 根左右
	private boolean dfs(TreeNode nodeA) {
		if(nodeA == null) {
			return false;
		}

		if(nodeA.val == nodeB.val) {
			// 判断nodeA中是否存在与nodeB相同的结构
			if(helper(nodeA, nodeB)) {
				return true;
			}
		}

		return dfs(nodeA.left) || dfs(nodeA.right);
	}

	// 判断从A的子树是否有和B相同的部分
	private boolean helper(TreeNode nodeA, TreeNode nodeB) {
		// nodeB遍历完为空
		if(nodeB == null) {
			return true;
		}
		if(nodeA == null || nodeA.val != nodeB.val) {
			return false;
		}
		return helper(nodeA.left, nodeB.left) && helper(nodeA.right, nodeB.right);
	}*/

	/**
	 *  思路: BFS(广度优先搜索)
	 *
	 *  1. 先遍历树A,如果遍历到和B节点相同的节点,进入helper方法判断接下来的节点是否都相同
	 *  2. 节点都相同返回true,不相同则返回false,并且继续遍历树A找下一个相同的节点
	 *  3. 如果遍历完了A还没有返回过true,则返回false
	 *
	 *  时间: O(m*n)  m为A树总节点数,n为B数总节点数
	 *  空间: O(m) 最差情况下遍历A中所有节点入队
	 */
	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if(B == null || A == null) {
			return false;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(A);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.val == B.val) {
				if(helper(node, B)) {
					return true;
				}
			}
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
		return false;
	}

	private boolean helper(TreeNode nodeA, TreeNode nodeB) {
		Queue<TreeNode> queueA = new LinkedList<>();
		Queue<TreeNode> queueB = new LinkedList<>();
		queueA.offer(nodeA);
		queueB.offer(nodeB);
		while(!queueB.isEmpty()) {
			nodeA = queueA.poll();
			nodeB = queueB.poll();
			if(nodeA == null || nodeA.val != nodeB.val) {
				return false;
			}
			if(nodeB.left != null) {
				queueA.offer(nodeA.left);
				queueB.offer(nodeB.left);
			}
			if(nodeB.right != null) {
				queueA.offer(nodeA.right);
				queueB.offer(nodeB.right);
			}
		}

		return true;
	}
}
