package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _199_二叉树的右视图
 * @Author: whc
 * @Date: 2021/06/20/14:29
 */
public class _199_二叉树的右视图 {

	/**
	 *  思路: 队列(先进先出)
	 *  广度优先搜索
	 *
	 *  1. 构建一个队列
	 *  2. 将每层的元素依次出队(用count固定变量控制每层),到最后count=1的时候,就是每层的最右节点,添加到结果集中
	 *  3. 将每层的元素依次出队的同时,将每个元素的左右节点不为空的入队
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int count = queue.size();
			while(count > 0) {
				TreeNode node = queue.pop();
				if(count == 1) {
					res.add(node.val);
				}
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
		}

		return res;
	}
}
