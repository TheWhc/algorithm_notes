package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _993_二叉树的堂兄弟节点
 * @Author: whc
 * @Date: 2021/06/20/15:44
 */
public class _993_二叉树的堂兄弟节点 {

	/**
	 *  思路: 层序遍历(队列,广度优先搜索)
	 *	1. 按照层序遍历的思路
	 *  2. 这里最重要的一点就是判断是否是兄弟节点,如果当前节点的左右子树都不为空,而且刚好左右子树的节点都是x和y,那么说明是兄弟节点,返回false
	 *  3. 若不是兄弟节点,就按照每层集合中的判断是否都有x和y,如果有,则是堂兄弟节点,直接返回true
	 */
	public boolean isCousins(TreeNode root, int x, int y) {
		LinkedList<TreeNode> queue = new LinkedList<>(); // 存放树的节点
		queue.offer(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			// 添加每层节点的元素
			List<Integer> temp = new ArrayList<>();
			while(levelSize > 0) {
				TreeNode node = queue.poll();
				// 判断x和y是否是兄弟节点,如果是的话直接返回false
				if(node.left != null && node.right != null) {
					if(node.left.val == x && node.right.val == y ||
					node.left.val == y && node.right.val == x) {
						return false;
					}
				}
				temp.add(node.val);
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				levelSize--;
			}

			// 判断每层节点是否都包含x,y, 如果包含则证明是堂兄弟节点,返回true
			if(temp.contains(x) && temp.contains(y)) {
				return true;
			}
		}

		return false;
	}
}
