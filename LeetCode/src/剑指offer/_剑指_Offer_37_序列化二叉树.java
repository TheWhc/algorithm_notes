package 剑指offer;

import java.util.*;

/**
 * @ClassName: _剑指_Offer_37_序列化二叉树
 * @Author: whc
 * @Date: 2021/05/30/10:05
 */
public class _剑指_Offer_37_序列化二叉树 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		_剑指_Offer_37_序列化二叉树 a = new _剑指_Offer_37_序列化二叉树();
	/*	System.out.println(a.serialize(root));
		a.deserialize(a.serialize(root));*/

		System.out.println(a.Serialize(root));
	}

	/**
	 *  思路: BFS
	 *  序列化:
	 *  	1. 用BFS遍历树,不管node的左右子节点是否存在,都加入到队列中
	 *  	2. 节点出队时,如果节点不存在,在返回值res加入一个"null",如果节点存在,则加入节点的字符串形式
	 *  反序列化:
	 *  	1. 利用队列新建二叉树
	 *  	2. 将data转化为列表,然后遍历,只要不为null将节点按顺序加入二叉树中,同时还要将节点入队
	 *  	3. 队列为空时,遍历结束,返回根节点
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	// Encodes a tree to a single string.
	/*public String serialize(TreeNode root) {
		if(root == null) {
			return "[]";
		}
		StringBuilder res = new StringBuilder();
		res.append("[");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node == null) {
				res.append("null,");
			} else {
				res.append(node.val + ",");
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
		res.deleteCharAt(res.length()-1);
		res.append("]");
		return res.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data == null || data.equals("[]") || data.length() == 0) {
			return null;
		}
		data = data.substring(1, data.length()-1);
		String[] nums = data.split(",");
		// 构建根节点
		TreeNode root = new TreeNode(Integer.valueOf(nums[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int index = 1;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(!nums[index].equals("null")) {
				node.left = new TreeNode(Integer.valueOf(nums[index]));
				queue.offer(node.left);
			}
			index++;
			if(!nums[index].equals("null")) {
				node.right = new TreeNode(Integer.valueOf(nums[index]));
				queue.offer(node.right);
			}
			index++;
		}
		return root;
	}*/

	/**
	 *  思路: DFS
	 *
	 *  序列化:
	 *  	1. 递归终止条件,为空时返回"null"
	 * 		2. 序列化结果: 根节点值 + "," + 左子节点值(进入递归) + "," + 右子节点值(进入递归)
	 *
	 *  比如 1
	 *     / \
 	 *    2  3
	 *    序列化结果是:1,2,null,null,3,null,null
	 * 	反序列:
	 * 		1. 先把字符串转换为队列
	 * 		2. 进入递归
	 * 			2.1 队列出队
	 * 			2.2 如果元素为"null",返回null
	 * 			2.3 不为"null",新建一个值为弹出元素的新节点
	 * 			2.4 其左子节点为队列的下一个元素,其右子节点为队列的下下个元素
	 *
	 * 	时间: O(n)
	 * 	空间: O(n)
	 */
	/*public String serialize(TreeNode root) {
		if(root == null) {
			return "null";
		}
		return root.val + "," + serialize(root.left) + "," + serialize(root.right);
	}

	public TreeNode deserialize(String data) {
		if(data == null || data.equals("[]") || data.length() == 0) {
			return null;
		}
		Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
		return dfs(queue);
	}

	private TreeNode dfs(Queue<String> queue) {
		String val = queue.poll();
		if("null".equals(val)){
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left = dfs(queue);
		root.right = dfs(queue);
		return root;
	}*/


	/*String Serialize(TreeNode root) {
		if(root==null){
			return "#!";
		}
		StringBuilder sb=new StringBuilder();
		Serialize2(root,sb);
		return sb.toString();
	}
	void Serialize2(TreeNode root,StringBuilder sb){//前序遍历
		if(root==null){
			sb.append("#!");
			return;
		}
		sb.append(root.val);
		sb.append("!");
		Serialize2(root.left,sb);
		Serialize2(root.right,sb);
	}
	TreeNode Deserialize(String str) {
		if(str.length()==0)return null;
		String[] strs=str.split("!");
		return Deserialize2(strs);
	}
	int index=-1;
	TreeNode Deserialize2(String[] strs){
		index++;
		if(!strs[index].equals("#")){
			TreeNode root=new TreeNode(0);
			root.val=Integer.parseInt(strs[index]);
			root.left=Deserialize2(strs);
			root.right=Deserialize2(strs);
			return root;
		}
		return null;
	}*/


	String Serialize(TreeNode root) {
		if(root == null) {
			return "#!";
		}
		StringBuilder res = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node != null) {
				res.append(node.val + "!");
				queue.offer(node.left);
				queue.offer(node.right);
			} else {
				res.append("#" + "!");
			}

		}
		return res.toString();
	}
	TreeNode Deserialize(String str) {
		if(str == null || str.length() == 0 || str.equals("#!")) {
			return null;
		}
		str = str.substring(0, str.length()-1);
		String[] nodes = str.split("!");
		TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int index = 1;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(!nodes[index].equals("#")) {
				node.left = new TreeNode(Integer.valueOf(nodes[index]));
				queue.offer(node.left);
			}
			index++;
			if(!nodes[index].equals("#")) {
				node.right = new TreeNode(Integer.valueOf(nodes[index]));
				queue.offer(node.right);
			}
			index++;
		}
		return root;
	}
}
