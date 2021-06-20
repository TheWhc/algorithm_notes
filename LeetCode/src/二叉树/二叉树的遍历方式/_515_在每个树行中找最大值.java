package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _515_在每个树行中找最大值
 * @Author: whc
 * @Date: 2021/06/20/15:03
 */
public class _515_在每个树行中找最大值 {


	/**
	 *  思路: 队列(先进先出)
	 *  广度优先搜索
	 *
	 *  1. 构建一个队列
	 *  2. 将每层的元素依次出队(用count固定变量控制每层), 用levelMax记录每层的最大值
	 *  3. 将每层的元素依次出队的同时,将每个元素的左右节点不为空的入队
	 *  4. 每层遍历结束后,将每层的最大值添加到结果集中
	 */
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int count = queue.size();
			int levelMax = Integer.MIN_VALUE;
			while(count > 0) {
				TreeNode node = queue.pop();
				levelMax = Math.max(levelMax, node.val);
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
			res.add(levelMax);
		}

		return res;
	}
}
