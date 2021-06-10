package 贪心;


/**
 * @ClassName: _968_监控二叉树
 * @Author: whc
 * @Date: 2021/04/15/9:42
 */

public class _968_监控二叉树 {

	// 二叉树的遍历  后序遍历 左右根
	// 隔两个节点放一个摄像头:
	//		0: 该节点无覆盖
	// 		1: 本节点有摄像头
	//      2: 本节点有覆盖
	int result = 0;
	public int minCameraCover(TreeNode root) {
		if(traversal(root) == 0) {
			result++;
		}
		return result;
	}

	private int traversal(TreeNode cur) {
		// 递归终止条件
		if(cur == null) {
			return 2;
		}
		// 左
		int left = traversal(cur.left);
		// 右
		int right = traversal(cur.right);

		// 单层递归逻辑
		// 左右都有覆盖
		if(left == 2 && right == 2) {
			return 0;
		} else if(left == 0 || right == 0) {
			// 左右至少有一个无覆盖
			result++;
			return 1;
		} else {
			// 左右至少有一个摄像头
			// if(left == 1 || right == 1)
			return 2;
		}
	}
}
