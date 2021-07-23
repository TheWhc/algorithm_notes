package CodeTop;

/**
 * @ClassName: _988_从叶结点开始的最小字符串
 * @Author: whc
 * @Date: 2021/07/23/15:03
 */
public class _988_从叶结点开始的最小字符串 {

	String res = null;
	public String smallestFromLeaf(TreeNode root) {
		dfs(root, new StringBuilder());
		return res;
	}

	private void dfs(TreeNode root, StringBuilder path) {
		if(root == null) {
			return;
		}

		path.append((char)(root.val + 'a'));

		if(root.left == null && root.right == null) {
			String cur = path.reverse().toString();
			if(res == null || res.compareTo(cur) > 0) {
				res = cur;
			}
			path = path.reverse(); // 回溯时记得重新反转回去
			path.deleteCharAt(path.length()-1);
			return;
		}

		dfs(root.left, path);
		dfs(root.right, path);
		path.deleteCharAt(path.length()-1);
	}

}
