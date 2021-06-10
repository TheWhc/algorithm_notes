package top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _297_二叉树的序列化与反序列化
 * @Author: whc
 * @Date: 2021/05/15/10:35
 */
public class _297_二叉树的序列化与反序列化 {

	/**
	 *  思路: 序列化: 每一层的序列存到数组中,如果是null就存null
	 *       反序列化: 将数组按照层序遍历顺序依次入队, 出队时构成结点进行反序列化
	 */
	// Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		if(root == null) {
			return "";
		}
		// 层序遍历
		List<Integer> res = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.pop();
			if(node != null) {
				res.add(node.val);
				queue.add(node.left);
				queue.add(node.right);
			} else {
				res.add(null);
			}
		}
		return res.toString();
	}

	// Decodes your encoded data to tree.
	public static TreeNode deserialize(String data) {
		if(data == null || data.length() == 0)
			return null;
		// 还原数组
		String[] nodes = data.substring(1, data.length() - 1).split(",");

		LinkedList<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(nodes[0].trim()));
		queue.add(root);
		for (int i = 1; i < nodes.length;) {
			TreeNode node = queue.pop();
			if(nodes[i].trim().equals("null")) {
				node.left = null;
			} else {
				node.left = new TreeNode(Integer.parseInt(nodes[i].trim()));
				queue.add(node.left);
			}

			if(nodes[i+1].trim().equals("null")) {
				node.right = null;
			} else {
				node.right = new TreeNode(Integer.parseInt(nodes[i+1].trim()));
				queue.add(node.right);
			}

			i += 2;
		}

		return root;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		System.out.println(serialize(root));
		deserialize("[1, 2, 3, null, 5, null, null, null, null]");
	}

	// Decodes your encoded data to tree.
	/*public TreeNode deserialize(String data) {

	}*/

}
