package 待分类;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: 待分类._22_括号生成
 * @Author: whc
 * @Date: 2021/03/12/13:15
 */
public class _22_括号生成 {


	/*public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		dfs("", n, n, res);
		return res;
	}


	 *
	 * @param curStr 当前递归得到的结果
 	 * @param left 左括号还有几个可以使用
	 * @param right 右括号还有几个可以使用
	 * @param res 结果集
	 *
	private void dfs(String curStr, int left, int right, List<String> res) {
		// 递归终止条件
		if(left == 0 && right == 0) {
			res.add(curStr);
			return;
		}

		// 剪枝
		// 左括号数大于右括号数,需要排除, 因为第一步是做出右括号选择 不符合条件
		if(left > right) {
			return;
		}

		if(left > 0) {
			dfs(curStr + "(", left - 1, right, res);
		}

		if(right > 0) {
			dfs(curStr + ")", left, right-1, res);
		}
	}*/


	// 广度优先搜索, 需要自己实现一个结点类
	class Node {
		// 当前得到的字符串
		private String cur;
		// 左括号数量
		private int left;
		// 右括好数量
		private int right;

		public Node(String cur, int left, int right) {
			this.cur = cur;
			this.left = left;
			this.right = right;
		}

	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if(n == 0)
			return res;

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node("", n, n));

		while(!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.left == 0 && node.right == 0) {
				res.add(node.cur);
			}

			if(node.left > 0) {
				queue.offer(new Node(node.cur + "(", node.left-1, node.right));
			}

			if(node.right > 0 && node.left < node.right) {
				queue.offer(new Node(node.cur + ")", node.left, node.right-1));
			}
		}

		return res;
	}

}
