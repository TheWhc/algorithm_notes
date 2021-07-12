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
	/*int result = 0;
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
	}*/


	/**
	 * 思路: 贪心
	 * 局部最优： 让叶子节点的父节点安摄像头, 所用摄像头最少
	 * 整体最优: 全部摄像头数量所用最少
	 *
	 * 1. 从下往上看, 后序遍历
	 * 2. 每隔两个点安放一个摄像头
	 *
	 *
	 * 状态0表示没被覆盖
	 * 状态1表示安摄像头
	 * 状态2表示被覆盖
	 */

	int res = 0;
	public int minCameraCover(TreeNode root) {
		if(traversal(root) == 0) {
			res++;
		}
		return res;
	}

	private int traversal(TreeNode cur) {

		// 递归终止条件
		// 空节点的时候,应该返回有覆盖的状态,因为如果是无覆盖(0),那么空节点需要安摄像头, 如果是安摄像头(1),那么父节点就没必要放摄像头了
		// 而我们希望的是空节点应该是有覆盖的状态(2), 这样就可以在叶子节点的父节点放摄像头了
		if(cur == null) {
			return 2;
		}

		// 左
		int left = traversal(cur.left);
		// 右
		int right = traversal(cur.right);
		// 根

		// 对返回当前节点状态值为0,1,2进行分类讨论

		// 1. 左右节点都覆盖的情况下
		if(left == 2 && right == 2) {
			return 0;
		}

		// 2. 左右节点至少有一个无覆盖, 此时需要安摄像头监控其子节点
		// 比如左节点为0,右节点也为0; 左节点为1,右节点为0; 左节点为0,右节点为1;
		// 左节点为0,右节点为2; 左节点为2,右节点为0
		if(left == 0 || right == 0) {
			res++;
			return 1;
		}

		// 3. 左右节点至少有一个摄像头
		// 比如左节点为1,右节点为2; 左节点为2,右节点为1; 左节点为1, 右节点为1; 左节点为1,右节点为0,情况二已经讨论过了
		if(left == 1 || right == 1) {
			return 2;
		}

		// 这个逻辑不会走到这里
		return -1;
	}
}
