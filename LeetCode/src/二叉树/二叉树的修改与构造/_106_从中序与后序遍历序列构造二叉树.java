package 二叉树.二叉树的修改与构造;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _106_从中序与后序遍历序列构造二叉树
 * @Author: whc
 * @Date: 2021/06/23/10:36
 */
public class _106_从中序与后序遍历序列构造二叉树 {

	/**
	 *  思路: 递归法
	 *  区间按照左闭右闭原则
	 *	1. 取后序数组的最后一个元素作为根节点,然后找到根节点在中序数组对应的位置,先划分中序数组左数组 和 右数组区间
	 *  2. 然后再划分后序数组中的后序左数组区间和后序右数组区间
	 *  3. 然后以1,2得到的数组区间递归构建根节点的左子树和右子树,最后返回根节点
	 *
	 *  中序数组左数组区间 [in_start, in_root_index-1] 和 右数组区间 [in_root_index+1, in_end]
	 *  后序数组左数组区间 [post_start, post_start + in_root_index - 1 - in_start] 和 右数组区间[post_start + in_root_index - in_start, post_end-1]
	 */

	Map<Integer, Integer> map = new HashMap<>();
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || postorder == null) {
			return null;
		}

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helperBuild(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
	}

	private TreeNode helperBuild(int[] inorder, int in_start, int in_end, int[] postorder, int post_start, int post_end) {
		if(in_end < in_start || post_end < post_start) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[post_end]);
		int in_root_index = map.get(postorder[post_end]);

		root.left = helperBuild(inorder, in_start, in_root_index -1, postorder, post_start, post_start + in_root_index - 1 - in_start);
		root.right = helperBuild(inorder, in_root_index+1, in_end, postorder, post_start + in_root_index - in_start, post_end-1);

		return root;
	}

	/**
	 * 思路: 递归 区间按照左闭右开原则
	 * 1. 取后序数组中的最后一个元素作为根节点,然后找到根节点在中序数组中的位置,先划分中序数组左数组区间和右数组区间
	 * 2. 然后再划分后序数组中的后序左数组区间和后序右数组区间
	 * 3. 然后以1和2得到的数组区间递归构建根节点的左子树和右子树, 最后返回根节点
	 * 4. 中序数组左数组区间 [i_start, i_root_index) 和 右数组区间[i_root_index+1, i_end)
	 * 5. 后序数组左数组区间 [p_start, p_start + i_root_index - i_start) 和 右数组区间[p_start + i_root_index-i_start, p_end-1)  【p_end-1的原因是最后一个元素已作跟节点构建完毕】
	 */

	// 存储后序数组中的根节点元素在中序数组中的下标位置,以便划分中序数组的左区间和右区间
	/*private HashMap<Integer, Integer> map = new HashMap<>();

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
    }*/

}
