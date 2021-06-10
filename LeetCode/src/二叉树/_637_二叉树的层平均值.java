package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _637_二叉树的层平均值
 * @Author: whc
 * @Date: 2021/04/16/10:20
 */
public class _637_二叉树的层平均值 {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty()) {
			double average = 0;
			count = queue.size();
			int levelNum = count;
			while(count > 0) {
				TreeNode node = queue.poll();
				average += node.val;
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
			res.add(average / levelNum);
		}

		return res;
	}
}
