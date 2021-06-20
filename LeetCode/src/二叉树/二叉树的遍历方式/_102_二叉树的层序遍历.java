package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _102_二叉树的层序遍历
 * @Author: whc
 * @Date: 2021/06/20/14:19
 */
public class _102_二叉树的层序遍历 {

	/**
	 *  思路: 队列(先进先出)
	 *  广度优先搜索
	 *
	 *  1. 构建一个队列
	 *  2. 将每层的元素依次出队添加到临时结果集(用count固定变量控制每层)
	 *  3. 将每层的元素依次出队的同时,将每个元素的左右节点不为空的入队
	 *  4. 每层遍历结束后,将每层的结果添加到结果集中
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int count = queue.size();
			List<Integer> temp = new ArrayList<>();
			while(count > 0) {
				TreeNode node = queue.pop();
				temp.add(node.val);
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
			res.add(temp);
		}

		return res;
	}
}
