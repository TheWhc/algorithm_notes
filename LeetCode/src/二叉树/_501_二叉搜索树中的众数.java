package 二叉树;

import java.util.*;

/**
 * @ClassName: _501_二叉搜索树中的众数
 * @Author: whc
 * @Date: 2021/04/21/13:01
 */
public class _501_二叉搜索树中的众数 {


	// 如果是一般的二叉树
	/*Map<Integer, Integer> map = new HashMap<>();

	public int[] findMode(TreeNode root) {
		if (root == null) return new int[0];
		dfs(root);
		int maxCount = Integer.MIN_VALUE;
		for (int n : map.values()) {
			maxCount = Math.max(n, maxCount);
		}

		List<Integer> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == maxCount) {
				list.add(entry.getKey());
			}
		}

		int[] res = new int[list.size()];
		for(int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private void dfs(TreeNode root) {
		if (root == null) return;
		dfs(root.left);
		map.put(root.val, map.getOrDefault(root.val, 0) + 1);
		dfs(root.right);
	}*/

	// 二叉搜索树
	// 递归法   借助指针 然后频率次数
	/*int maxCount = 0; // 最大频率
	int count = 0; // 统计频率
	TreeNode pre = null;
	List<Integer> list = new ArrayList<>();

	public int[] findMode(TreeNode root) {
		if(root == null) return new int[0];

		dfs(root);

		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private void dfs(TreeNode cur) {
		if(cur == null) return;

		dfs(cur.left);
		if(pre == null) {
			count = 1;
		} else if(pre.val == cur.val) {
			count++;
		} else {
			count = 1;
		}

		if(count == maxCount) {
			list.add(cur.val);
		}

		if(count > maxCount) {
			maxCount = count;
			list.clear();
			list.add(cur.val);
		}
		pre = cur;

		dfs(cur.right);
	}*/

	// 迭代法
	public int[] findMode(TreeNode root) {
		if(root == null) return new int[0];
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;
		TreeNode cur = root;
		int count = 0; // 频率
		int maxCount = 0; // 最大频率
		List<Integer> list = new ArrayList<>();
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left; // 左
			} else {
				cur = stack.pop(); // 根
				if(pre == null) {
					count = 1;
				} else if(pre.val == cur.val) {
					count++;
				} else {
					count = 1;
				}
				if(count == maxCount) {
					list.add(cur.val);
				}
				if(count > maxCount) {
					maxCount = count;
					list.clear();
					list.add(cur.val);
				}
				pre = cur;
				cur = cur.right; // 右
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

}
