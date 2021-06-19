package 回溯.棋盘问题;

/**
 * @ClassName: _37_解数独
 * @Author: whc
 * @Date: 2021/06/20/1:11
 */
public class _37_解数独 {

	/**
	 * 思路: 回溯法
	 *
	 * 1. 递归函数的返回值的参数类型
	 * 返回值类型为boolean,一旦找到一个符合条件立刻就返回,相当于找到从根节点到叶子节点的唯一路径
	 *
	 * backtrack(char[][] board)
	 * 参数类型为棋盘
	 *
	 * 2. 递归终止条件
	 * 无需终止条件,解数独是要遍历整个树形结构寻找可能的叶子节点就立刻返回。
	 *
	 * 没终止条件不会造成死循环问题嘛?
	 * 不会造成死循环,等数填满了棋盘自然就终止
	 *
	 * 3. 单层递归逻辑
	 *	树状图中我们需要的是一个二维的递归(两个for循环嵌套)
	 *  一层遍历棋盘的行,一层遍历棋盘的列,一行一列确定下来后,递归遍历这个位置放9个数组的可能性
	 *
	 *
	 */
	public void solveSudoku(char[][] board) {
		// 二维递归
		backtrack(board);
	}

	// 返回值是布尔类型,遇到满足的情况下直接返回
	private boolean backtrack(char[][] board) {
		// 二维递归, 双重for循环, 一层遍历棋盘的行,一层遍历棋盘的列,一行一列确定下来后,递归遍历这个位置放9个数组的可能性
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if(board[row][col] != '.') {
					continue;
				}
				// (row,col)这个位置放k是否合适
				for (char k = '1'; k <= '9'; k++) {
					if(valid(row, col, k, board)) {
						// 满足情况下,进行选择
						board[row][col] = k;
						// 找到一组合适的立即返回
						if(backtrack(board)) {
							return true;
						}
						// 回溯
						board[row][col] = '.';
					}
				}

				// 若当前这个位置'1'~'9'都不满足,则返回false,回退到上一层
				return false;
			}
		}

		// 遍历结束没有返回false,说明找到了合适的棋盘位置了
		return true;
	}

	private boolean valid(int row, int col, char val, char[][] board) {
		// 检查行是否重复
		for (int j = 0; j < 9; j++) {
			if(board[row][j] == val) {
				return false;
			}
		}

		// 检查列是否重复
		for (int i = 0; i < 9; i++) {
			if(board[i][col] == val) {
				return false;
			}
		}

		// 检查9个格子是否重复
		// 比如当前位置是(8,8), 则检查从start =  8 / 3 * 3 = 6, 下标为6开始检查
		int startRow = row / 3 * 3;
		int startCol = col / 3 * 3;
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if(board[i][j] == val) {
					return false;
				}
			}
		}

		return true;
	}

}
