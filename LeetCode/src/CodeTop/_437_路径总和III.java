package CodeTop;

/**
 * @ClassName: _437_路径总和III
 * @Author: whc
 * @Date: 2021/07/23/14:53
 */
public class _437_路径总和III {

	int res = 0;
	public int pathSum(TreeNode root, int sum) {
		if(root == null) {
			return res;
		}
		dfs(root, sum); // 以root作为起点查找路径
		pathSum(root.left, sum); // 左子树递归
		pathSum(root.right, sum); // 右子树递归
		return res;
	}

	private void dfs(TreeNode root, int sum) {
		if(root == null) {
			return;
		}

		sum -= root.val;

		if(sum == 0) { //注意不要return,因为不要求到叶节点结束,所以一条路径下面还可能有另一条
			res++; //如果找到了一个路径全局变量就+1
		}

		dfs(root.left, sum);
		dfs(root.right, sum);
	}
}
