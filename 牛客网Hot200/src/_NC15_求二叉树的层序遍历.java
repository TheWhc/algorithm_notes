import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _NC15_求二叉树的层序遍历
 * @Author: whc
 * @Date: 2021/01/30/0:24
 */
public class _NC15_求二叉树的层序遍历 {

	public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
		// write code here
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(queue.size() != 0) {
			int count = queue.size();
			ArrayList<Integer> ans = new ArrayList<>();
			while(count > 0) {
				TreeNode node = queue.peek();
				ans.add(node.val);
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				queue.poll();
				count--;
			}
			res.add(ans);
		}

		return res;
	}
}
