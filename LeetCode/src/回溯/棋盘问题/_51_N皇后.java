package 回溯.棋盘问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _51_N皇后
 * @Author: whc
 * @Date: 2021/06/19/23:43
 */
public class _51_N皇后 {


	/**
	 *  思路: 回溯
	 *
	 *  定义一个全局变量, 用来存放符合条件结果的集合
	 *
	 * 1. 递归函数的返回值以及参数
	 * 	  backtrack(int n, int row, char[][] chessboard)
	 * 	  n: 棋盘的大小
	 * 	  row: 遍历到棋盘的第几层
	 * 	  chessboard: 棋盘默认情况
	 *
	 * 2. 回溯函数终止条件
	 * 	  递归到棋盘最底层,即叶子节点的时候,收集结果并返回
	 *
	 * 3. 单层搜索的过程
	 * 	  for循环每次从col开始(0到n),然后递归深度即row控制棋盘的行
	 *
	 */
	List<List<String>> res = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {
		char[][] chessboard = new char[n][n];
		for (char[] chars : chessboard) {
			Arrays.fill(chars, '.');
		}
		backtrack(n, 0, chessboard);
		return res;
	}

	private void backtrack(int n, int row, char[][] chessboard) {
		if(row == n) {
			res.add(ArraysToList(chessboard));
			return;
		}

		for (int col = 0; col < n; col++) {
			// 检查当前要添加的元素是否合法
			if(valid(row, col, chessboard)) {
				chessboard[row][col] = 'Q';
				backtrack(n, row+1, chessboard);
				// 回溯,撤销皇后
				chessboard[row][col] = '.';
			}
		}
	}

	/**
	 *  校验当前的位置是否合法, 排除行(忽略)、列、对角线(45°,135°)皇后的影响
	 */
	private boolean valid(int row, int col, char[][] chessboard) {
		// 检查列是否有Q
		for (int i = row-1; i >= 0; i--) {
			if(chessboard[i][col] == 'Q') {
				return false;
			}
		}

		// 检查对角线45°
		for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
			if(chessboard[i][j] == 'Q') {
				return false;
			}
		}

		// 检查对角线135°
		for (int i = row-1, j = col + 1; i >= 0 && j < chessboard.length; i--, j++) {
			if(chessboard[i][j] == 'Q') {
				return false;
			}
		}

		return true;
	}

	private List<String> ArraysToList(char[][] chessboard) {
		List<String> list = new ArrayList<>();
		for (char[] chars : chessboard) {
			list.add(String.valueOf(chars));
		}

		return list;
	}

}
