package 回溯.棋盘问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _52_N皇后II
 * @Author: whc
 * @Date: 2021/06/20/0:57
 */
public class _52_N皇后II {

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
	public int totalNQueens(int n) {
		char[][] chessBoard = new char[n][n];
		for (char[] chars : chessBoard) {
			Arrays.fill(chars, '.');
		}
		backtrack(n, 0, chessBoard);
		return res.size();
	}

	private void backtrack(int n, int row, char[][] chessBoard) {
		if(row == n) {
			res.add(ArraysToList(chessBoard));
			return;
		}

		for (int col = 0; col < n; col++) {
			if(valid(row, col, chessBoard)) {
				chessBoard[row][col] = 'Q';
				backtrack(n, row + 1, chessBoard);
				chessBoard[row][col] = '.';
			}
		}
	}

	private boolean valid(int row, int col, char[][] chessBoard) {
		// 检查列是否有皇后'Q'
		for (int i = row-1; i >= 0; i--) {
			if(chessBoard[i][col] == 'Q') {
				return false;
			}
		}

		// 检查对角线45°是否有皇后'Q'
		for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
			if(chessBoard[i][j] == 'Q') {
				return false;
			}
		}

		// 检查对角线135°是否有皇后'Q'
		for (int i = row-1, j = col+1; i >= 0 && j < chessBoard.length; i--, j++) {
			if(chessBoard[i][j] == 'Q') {
				return false;
			}
		}

		return true;
	}

	private List<String> ArraysToList(char[][] chessBoard) {
		List<String> list = new ArrayList<>();
		for (char[] chars : chessBoard) {
			list.add(String.valueOf(chars));
		}
		return list;
	}
}
