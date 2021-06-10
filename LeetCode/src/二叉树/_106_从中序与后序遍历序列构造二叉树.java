package 二叉树;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName: _106_从中序与后序遍历序列构造二叉树
 * @Author: whc
 * @Date: 2021/04/19/15:25
 */
public class _106_从中序与后序遍历序列构造二叉树 {

	public static void main(String[] args) {
		new _106_从中序与后序遍历序列构造二叉树().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
	}

	/*
	步骤如下:
		1. 数组大小为0,说明是空节点
		2. 如果不为空节点,取后序数组的最后一个元素作为节点元素
		3. 找到后序数组最后一个元素在中序数组的位置,作为切割点
		4. 切割中序数组,切成中序左数组和中序右数组
		5. 切割右序数组,切成右许左数组和右许右数组
		6. 递归处理左区间和右区间
	 *//*
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder == null || inorder == null) {
			return null;
		}

		// 第一步
		if(postorder.length == 0) {
			return null;
		}

		// 第二步 : 通过后序数组找到最后一个元素
		int rootValue = postorder[postorder.length-1];
		// 构造根节点
		TreeNode root = new TreeNode(rootValue);

		if(postorder.length == 1) {
			return root;
		}

		// 第三步 : 遍历中序序列,确定根节点在中序数组中的位置,从而确定左右子树
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if(inorder[i] == root.val) {
				k = i;
				break;
			}
		}

		// 第四步: 分割中序数组,切成中序左数组和中序右数组
		// 左闭右开区间
		int[] leftInOrder = Arrays.copyOfRange(inorder, 0, k);
		int[] rightInOrder = Arrays.copyOfRange(inorder, k+1, inorder.length);

		// 第五步: 分割后序数组,切成后序左数组和后序右数组
		int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftInOrder.length);
		int[] rightPostOrder = Arrays.copyOfRange(postorder, leftInOrder.length, postorder.length-1);


		// 日志调试
		System.out.println("-----------");
		System.out.print("leftInOrder:");
		for (int i : leftInOrder) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("rightInOrder:");
		for (int i : rightInOrder) {
			System.out.print(i + " ");
		}

		System.out.println();

		System.out.println("-----------");
		System.out.print("leftPostOrder:");
		for (int i : leftPostOrder) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("rightPostOrder:");
		for (int i : rightPostOrder) {
			System.out.print(i + " ");
		}

		System.out.println();

		// 第六步: 递归处理左区间和右区间 构建左子树和右子树
		root.left = buildTree(leftInOrder, leftPostOrder);
		root.right = buildTree(rightInOrder, rightPostOrder);

		return root;
	}*/


	// 下标索引 不用创建数组
	/*public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || postorder == null) {
			return null;
		}
		return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
	}

	private TreeNode traversal(int[] inorder, int inorderBegin, int inorderEnd, int[] postorder, int postorderBegin, int postorderEnd) {
		if(postorderBegin == postorderEnd) {
			return null;
		}

		// 第二步 : 通过后序数组找到最后一个元素
		int rootValue = postorder[postorderEnd-1];
		// 构造根节点
		TreeNode root = new TreeNode(rootValue);

		if(postorderEnd - postorderBegin == 1) {
			return root;
		}

		// 第三步 : 遍历中序序列,确定根节点在中序数组中的位置,从而确定左右子树
		int k = 0;
		for (int i = inorderBegin; i < inorderEnd; i++) {
			if(inorder[i] == root.val) {
				k = i;
				break;
			}
		}

		// 第四步: 分割中序数组,切成中序左数组和中序右数组
		// 左闭右开区间 [leftInOrderBegin, leftInOrderEnd)
		// 左中序区间
		int leftInOrderBegin = inorderBegin;
		int leftInOrderEnd = k;
		// 右中序区间
		int rightInOrderBegin = k+1;
		int rightInOrderEnd = inorderEnd;

		// 第五步: 分割后序数组,切成后序左数组和后序右数组
		// 左闭右开区间 [leftPostOrderBegin, leftPostOrderEnd)
		// 左后序区间
		int leftPostOrderBegin = postorderBegin;
		int leftPostOrderEnd = leftPostOrderBegin  + k - inorderBegin;
		// 右后序区间
		int rightPostOrderBegin = postorderBegin + k - inorderBegin;
		int rightPostOrderEnd = postorderEnd - 1;

		// 第六步: 递归处理左区间和右区间 构建左子树和右子树
		root.left = traversal(inorder, leftInOrderBegin, leftInOrderEnd, postorder, leftPostOrderBegin, leftPostOrderEnd);
		root.right = traversal(inorder, rightInOrderBegin,rightInOrderEnd, postorder, rightPostOrderBegin, rightPostOrderEnd );

		return root;

	}*/

	// 2021/5/22 二刷
	/**
	 * 思路: 递归 区间按照左闭右开原则
	 * 1. 取后序数组中的最后一个元素作为根节点,然后找到根节点在中序数组中的位置,先划分中序数组左数组区间和右数组区间
	 * 2. 然后再划分后序数组中的后序左数组区间和后序右数组区间
	 * 3. 然后以1和2得到的数组区间递归构建根节点的左子树和右子树, 最后返回根节点
	 * 4. 中序数组左数组区间 [i_start, i_root_index) 和 右数组区间[i_root_index+1, i_end)
	 * 5. 后序数组左数组区间 [p_start, p_start + i_root_index - i_start) 和 右数组区间[p_start + i_root_index-i_start, p_end-1)  【p_end-1的原因是最后一个元素已作跟节点构建完毕】
	 */

	// 存储后序数组中的根节点元素在中序数组中的下标位置,以便划分中序数组的左区间和右区间
	private HashMap<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		for(int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildTreeHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);
	}

	private TreeNode buildTreeHelper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end) {
		// 递归终止条件
		if(p_end == p_start) {
			return null;
		}

		// 根节点值
		int root_val = postorder[p_end-1];
		// 根节点值在中序数组中的位置
		int i_root_index = map.get(root_val);

		// 构建根节点
		TreeNode root = new TreeNode(root_val);
		// 递归构建左子树
		root.left = buildTreeHelper(inorder, i_start, i_root_index, postorder, p_start, p_start + i_root_index - i_start);
		// 递归构建右子树
		root.right = buildTreeHelper(inorder, i_root_index+1, i_end, postorder, p_start + i_root_index-i_start, p_end-1);

		return root;
	}
}
