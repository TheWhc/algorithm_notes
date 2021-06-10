package 二叉树;

import java.util.Arrays;

/**
 * @ClassName: 待分类._105_从前序与中序遍历序列构造二叉树
 * @Author: whc
 * @Date: 2021/04/19/17:09
 */
public class _105_从前序与中序遍历序列构造二叉树 {

	/*public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null) {
			return null;
		}

		// 1. 前序数组大小为0,空节点
		if(preorder.length == 0) {
			return null;
		}

		// 2. 不为空,取前序数组中的第一个元素作为根节点
		int rootValue = preorder[0];
		TreeNode root = new TreeNode(rootValue);

		if(preorder.length == 1) {
			return root;
		}

		// 3. 找到前序数组第一个元素在中序数组的位置,作为切割点
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if(inorder[i] == rootValue) {
				k = i;
				break;
			}
		}

		// 4. 切割中序数组
		// 左闭右开
		int[] leftInorder = Arrays.copyOfRange(inorder, 0, k);
		int[] rightInorder = Arrays.copyOfRange(inorder, k+1, inorder.length);

		// 5. 切割前序数组
		// 左闭右开
		int[] leftPreorder = Arrays.copyOfRange(preorder, 1, k+1);
		int[] rightPreorder = Arrays.copyOfRange(preorder, k+1, preorder.length);

		// 6. 递归处理左区间和右区间
		root.left = buildTree(leftPreorder, leftInorder);
		root.right = buildTree(rightPreorder, rightInorder);

		return root;
	}*/


	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null)
			return null;
		return traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);

	}

	private TreeNode traversal(int[] preorder, int preorderBegin, int preorderEnd, int[] inorder, int inorderBegin, int inorderEnd) {
		if(preorderBegin == preorderEnd) {
			return null;
		}

		int rootVal = preorder[preorderBegin];
		TreeNode root = new TreeNode(rootVal);

		// 叶子节点直接返回
		if(preorderEnd - preorderBegin == 1) {
			return root;
		}

		// 找到前序数组的第一个元素在中序数组的位置
		int k = 0;
		for (int i = inorderBegin; i < inorderEnd; i++) {
			if(preorder[preorderBegin] == inorder[i]) {
				k = i;
				break;
			}
		}

		// 切割中序数组
		// 左闭右开
		int leftInorderBegin = inorderBegin;
		int leftInorderEnd = k;
		int rightInorderBegin = k + 1;
		int rightInorderEnd = inorderEnd;

		// 切割前序数组
		int leftPreorderBegin = 1 + preorderBegin;
		int leftPreorderEnd = 1 + preorderBegin + k - inorderBegin;
		int rightPreorderBegin = leftPreorderEnd;
		int rightPreorderEnd = preorderEnd;

		// 递归处理左区间和右区间,构建左子树和右子树
		root.left = traversal(preorder, leftPreorderBegin, leftPreorderEnd, inorder, leftInorderBegin, leftInorderEnd);
		root.right = traversal(preorder, rightPreorderBegin, rightPreorderEnd, inorder, rightInorderBegin, rightInorderEnd);
		return root;
	}
}
