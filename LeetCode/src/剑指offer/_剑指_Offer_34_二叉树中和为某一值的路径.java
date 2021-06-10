package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _剑指_Offer_34_二叉树中和为某一值的路径
 * @Author: whc
 * @Date: 2021/05/29/11:44
 */
public class _剑指_Offer_34_二叉树中和为某一值的路径 {

	/**
	 * 思路: 遍历二叉树,并通过两个动态数组用于记录节点(path)和存储结果集(res)
	 * 1. 读取当前节点值,将当前节点加入到记录节点动态数组中(path)
	 * 2. 判断当前节点是不是叶子节点并且满足target目标值,如果是则加入到结果集中
	 * 3. 递归先进入左子树,并且传入当前计算结果target
	 * 4. 递归进入右子树,并且传入当前结算结果target
	 * 5. 子树遍历完后,移除记录节点动态数组(path)中当前节点值(即最后一个元素),进行回溯
	 */
	// 结果集
	List<List<Integer>> res = new ArrayList<>();
	// 路径
	List<Integer> path = new ArrayList<>();
	public List<List<Integer>> pathSum(TreeNode root, int target) {
		dfs(root, target);
		return res;
	}

	private void dfs(TreeNode root, int target) {
		if(root == null) {
			return;
		}
		// 添加当前二叉树的节点值
		path.add(root.val);
		// 计算target剩余值
		target -= root.val;
		// 满足条件,到达叶子节点并且taget==0时
		if(root.left == null && root.right == null && target == 0) {
			res.add(new ArrayList<>(path));
		}
		// 递归左子树
		dfs(root.left, target);
		// 递归右子树
		dfs(root.right, target);
		// 子树遍历完毕后,进行回溯,移除动态数组当前节点值
		path.remove(path.size()-1);
	}

}
