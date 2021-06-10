import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _NC14_二叉树的之字形层序遍历
 * @Author: whc
 * @Date: 2021/02/24/12:06
 */
public class _NC14_二叉树的之字形层序遍历 {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
		// write code here
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		if(root != null) {
			queue.add(root);
		}
		int line = 0;
		while(!queue.isEmpty()) {
			int count = queue.size();
			ArrayList<Integer> tmp = new ArrayList<>();
			while(count > 0) {
				TreeNode node = queue.poll();
				if(line % 2 == 0) {
					tmp.add(node.val);
				} else {
					tmp.add(0, node.val);
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
			res.add(tmp);
			line++;
		}

		return res;
	}
}
