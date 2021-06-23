package 二叉树.求二叉搜索树的属性;

import java.util.*;

/**
 * @ClassName: _501_二叉搜索树中的众数
 * @Author: whc
 * @Date: 2021/06/23/15:01
 */
public class _501_二叉搜索树中的众数 {

	/**
	 * 思路: 用map进行统计次数
	 * 		<key, value> : <节点值, 次数>
	 * 1. 用map进行统计,根据中序遍历得到节点值对应的次数
	 * 2. 对map进行遍历values,得到次数最多的值
	 * 3. 遍历map.entry,如果等于次数最多的值,则记录对应的节点值
	 */
	/*Map<Integer, Integer> map = new HashMap<>();
	public int[] findMode(TreeNode root) {
		 if(root == null) {
		 	return new int[0];
		 }

		 dfs(root);
		 int maxCount = 0;
		 for (int value : map.values()) {
			maxCount = Math.max(maxCount, value);
		 }

		List<Integer> list = new ArrayList<>();

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == maxCount) {
				list.add(entry.getKey());
			}
		}

		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) {
			return;
		}

		dfs(root.left);
		map.put(root.val, map.getOrDefault(root.val, 0) + 1);
		dfs(root.right);
	}*/


	/**
	 * 思路2: 利用中序遍历的特性,不需要像第一种方法那样,统计完最大次数后,还要对map进行再一次遍历,进行与count相等进行统计
	 * 思路2按照list统计临时结果,只需要一次遍历,如果出现次数比之前次数大的,则清空临时结果,然后添加当前节点
	 */
	/*TreeNode pre = null;
	int maxCount = 0;
	int count = 0;
	List<Integer> list = new ArrayList<>();
	public int[] findMode(TreeNode root) {
		findMode1(root);

		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}

		return res;
	}

	private void findMode1(TreeNode cur) {
		if(cur == null) {
			return;
		}

		// 左
		findMode1(cur.left);
		if(pre == null || pre.val != cur.val) {
			count = 1;
		} else {
			// pre != null && pre.val == root.val
			count++;
		}

		if(count > maxCount) {
			maxCount = count;
			list.clear();
			list.add(cur.val);
		} else if(count == maxCount) {
			maxCount = count;
			list.add(cur.val);
		}
		pre = cur;

		findMode1(cur.right);
	}*/


	TreeNode pre = null;
	int maxCount = 0;
	int count = 0;
	List<Integer> list = new ArrayList<>();
	public int[] findMode(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode node = stack.pop();

				if(pre == null || pre.val != node.val) {
					count = 1;
				} else {
					// pre != null && pre.val == node.val
					count++;
				}

				if(count > maxCount) {
					maxCount = count;
					list.clear();
					list.add(node.val);
				} else if(count == maxCount) {
					list.add(node.val);
				}
				pre = node;
				cur = node.right;
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

}
