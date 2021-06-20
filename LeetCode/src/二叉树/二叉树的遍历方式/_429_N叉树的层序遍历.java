package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _429_N叉树的层序遍历
 * @Author: whc
 * @Date: 2021/06/20/14:41
 */
public class _429_N叉树的层序遍历 {

	/**
	 *  思路: 队列(先进先出)
	 *  广度优先搜索
	 *
	 *  1. 构建一个队列
	 *  2. 将每层的元素依次出队添加到临时结果集(用levelSize固定变量控制每层)
	 *  3. 将每层的元素依次出队的同时,将每个元素的孩子节点依次入队
	 *  4. 每层遍历结束后,将每层的结果添加到结果集中
	 */
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		LinkedList<Node> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			int levelSize = queue.size();
			for (int i = 0; i < levelSize; i++) {
				Node node = queue.poll();
				temp.add(node.val);
				for (Node child : node.children) {
					queue.offer(child);
				}
			}
			res.add(temp);
		}

		return res;
 	}
}
