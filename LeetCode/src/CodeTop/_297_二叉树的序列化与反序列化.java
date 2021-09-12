package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _297_二叉树的序列化与反序列化
 * @Author: whc
 * @Date: 2021/09/12/12:54
 */
public class _297_二叉树的序列化与反序列化 {

	// 层序遍历
	public String serialize(TreeNode root) {
		if(root == null) {
			return "";
		}
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node != null) {
				res.add(node.val);
				queue.offer(node.left);
				queue.offer(node.right);
			} else {
				res.add(null);
			}
		}
		return res.toString();
	}

	public TreeNode deserialize(String data) {
		if(data == null || data.length() == 0) {
			return null;
		}

		String[] nums = data.substring(1, data.length()-1).split(",");
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(nums[0].trim()));
		queue.offer(root);

		for (int i = 1; i < nums.length;) {
			TreeNode node = queue.poll();
			if(nums[i].trim().equals("null")) {
				node.left = null;
			} else {
				node.left = new TreeNode(Integer.parseInt(nums[i].trim()));
				queue.offer(node.left);
			}

			if(nums[i+1].trim().equals("null")) {
				node.right = null;
			} else {
				node.right = new TreeNode(Integer.parseInt(nums[i+1].trim()));
				queue.offer(node.right);
			}

			i += 2;
		}

		return root;
	}
}
