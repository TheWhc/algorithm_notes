package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _637_二叉树的层平均值
 * @Author: whc
 * @Date: 2021/06/20/14:33
 */
public class _637_二叉树的层平均值 {

	/**
	 *  思路: 队列(广度优先搜索)
	 *
	 * 1. 构建一个队列
	 * 2. 将每层的元素依次出队(用count固定变量控制每层),统计每一层的总和,计算每一层的平均值添加到结果集中
	 * 3. 将每层的元素依次出队的同时,将每个元素的左右节点不为空的入队
	 *
	 */
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int count = queue.size();
			int levelCount = count;
			double sum = 0;
			while(count > 0) {
				TreeNode node = queue.pop();
				sum += node.val;
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
			res.add(sum / levelCount);
		}

		return res;
	}

}
