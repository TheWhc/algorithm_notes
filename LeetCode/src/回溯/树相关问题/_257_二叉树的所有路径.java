package 回溯.树相关问题;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _257_二叉树的所有路径
 * @Author: whc
 * @Date: 2021/06/21/15:02
 */
public class _257_二叉树的所有路径 {

	/**
	 *  思路: 回溯法
	 *
	 * 1. 递归函数的返回值以及参数
	 * 	  定义一个全局变量, 存放符合条件结果的集合
	 *
	 * 	  void backtrack(TreeNode root, List<Integer> paths)
	 * 	  root: 当前节点
	 * 	  paths: 从根节点到叶子节点的路径上的所有节点集合
	 *
	 * 2. 回溯函数终止条件
	 * 	  当前节点的左右子树都为空,说明到达了叶子节点,将paths路径中的所有元素拼接起来
	 *
	 * 3. 单层搜索的过程(单层递归逻辑)
	 * 	  若当前节点的左节点不为空,则将左节点加入到路径中,然后进入左子树递归
	 * 	  若当前节点的右节点不为空,则将右节点加入到路径中,然后进入右子树递归
	 *
	 */
	List<String> res = new ArrayList<>();
	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null){
			return res;
		}
		List<Integer> paths = new ArrayList<>();
		paths.add(root.val);
		backtrack(root, paths);
		return res;
	}

	private void backtrack(TreeNode root, List<Integer> paths) {
		if(root.left == null && root.right == null) {
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < paths.size()-1; i++) {
				temp.append(paths.get(i) + "->");
			}
			temp.append(paths.get(paths.size()-1));
			res.add(temp.toString());
			return;
		}

		if(root.left != null) {
			paths.add(root.left.val);
			backtrack(root.left, paths);
			paths.remove(paths.size()-1); // 回溯,撤销选择
		}

		if(root.right != null) {
			paths.add(root.right.val);
			backtrack(root.right, paths);
			paths.remove(paths.size()-1); // 回溯,撤销选择
		}
	}
}
