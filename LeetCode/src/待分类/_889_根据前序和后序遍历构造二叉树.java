package 待分类;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: 待分类._889_根据前序和后序遍历构造二叉树
 * @Author: whc
 * @Date: 2021/03/06/13:25
 */
public class _889_根据前序和后序遍历构造二叉树 {

	private int[] pre;
	private Map<Integer, Integer> dic = new HashMap<>();

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		this.pre = pre;
		for (int i = 0; i < post.length; i++) {
			dic.put(post[i], i);
		}
		return recur(0, 0, post.length-1);
	}

	public TreeNode recur(int root, int left, int right) {
		if(left > right)
			return null;
		// 构建根节点
		TreeNode node = new TreeNode(pre[root]);
		// 划分子树, 左子树和右子树
		int i = dic.get(pre[root]);
		//			根节点索引						后序遍历左边界						后序遍历右边界
		// 左子树     root+1           					left             			dic.get(pre[root+1])
		// 右子树     root+1+dic[pre[root+1]]-left    dic[pre[root+1]]+1              i-1
		node.left = recur(root+1, left, dic.get(pre[root+1]));
		node.right = recur(root+1+dic.get(pre[root+1])-left, dic.get(pre[root+1])+1, i-1);
		return node;
	}

	public static void main(String[] args) {
		_889_根据前序和后序遍历构造二叉树 a = new _889_根据前序和后序遍历构造二叉树();
		int[] pre = {1,2,4,5,3,6,7};
		int[] post = {4,5,2,6,7,3,1};
		a.constructFromPrePost(pre, post);
	}
}
