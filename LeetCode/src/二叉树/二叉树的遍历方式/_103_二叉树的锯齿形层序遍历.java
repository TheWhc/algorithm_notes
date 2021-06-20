package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _103_二叉树的锯齿形层序遍历
 * @Author: whc
 * @Date: 2021/06/20/15:25
 */
public class _103_二叉树的锯齿形层序遍历 {

	/**
	 *  思路: 层序遍历(队列,广度优先搜索)
	 *
	 *  1. 按照层序遍历的思路
	 *  2. 添加每一层节点元素到临时集合的时候, 应该判断是奇数还是偶数的情况, 若level为偶数,则正常添加, 若level为奇数,则逆序添加
	 *  3. 遍历完每一层的时候,记得level++
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> temp = new ArrayList<>();
			while(levelSize > 0) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				levelSize--;
			}
			if(level % 2 == 1) {
				Collections.reverse(temp);
			}
			res.add(temp);
			level++;
		}

		return res;
	}
}
