package 待分类;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: 待分类._105_从前序与中序遍历序列构造二叉树
 * @Author: whc
 * @Date: 2021/03/06/12:52
 */
public class _105_从前序与中序遍历序列构造二叉树 {
	int[] preorder;
	Map<Integer, Integer> dic = new HashMap<>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.preorder = preorder;
		for (int i = 0; i < inorder.length; i++) {
			dic.put(inorder[i], i);
		}
		return recur(0, 0, inorder.length-1);
	}

	TreeNode recur(int root, int left, int right) {
		if(left > right)
			return null;
		// 构建根节点, 根节点在前序遍历的索引root
		TreeNode node = new TreeNode(preorder[root]);
		// 划分根节点、左子树、右子树
		int i = dic.get(preorder[root]);
		// 	      根节点索引   中序遍历左边界  中序遍历右边界
		// 左子树   root+1       left           i-1
		// 右子树   root+1+i-left   i+1         right
		node.left = recur(root+1, left, i-1);
		node.right = recur(root+1+i-left, i+1, right);
		return node;
	}
}
