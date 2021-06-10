package top100;

/**
 * @ClassName: _79_单词搜索
 * @Author: whc
 * @Date: 2021/05/06/13:39
 */
public class _79_单词搜索 {

	/*// dfs + 回溯
	public boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0) {
			return false;
		}

		// 设置访问过的标记
		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(dfs(i, j, board, visited, 0, word)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(int i, int j, char[][] board, boolean[][] visited, int index, String word) {
		// 超过边界 或者 已被访问过 或者 字母不匹配 直接返回false
		if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j] || word.charAt(index) != board[i][j]) {
			return false;
		}

		// 匹配到最后一个字母并且相等 则返回true
		if(index == word.length()-1) {
			return true;
		}

		visited[i][j] = true; // 将当前位置标记为已访问
		// 上下左右搜索
		if(dfs(i-1, j, board, visited, index+1, word) || dfs(i+1, j, board, visited, index+1, word)
				|| dfs(i, j-1, board, visited, index+1, word) || dfs(i, j+1, board, visited, index+1, word)) {
			return true;
		}
		visited[i][j] = false; // 当前位置不符合,恢复标记

		return false;
	}*/


	// 优化时间 设置一个字符 dfs + 回溯
	public boolean exist(char[][] board, String word) {
		if(board == null || board.length == 0) {
			return false;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(dfs(i, j, board, 0, word)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(int i, int j, char[][] board, int index, String word) {
		// 超过边界 或者 已被访问过 或者 字母不匹配 直接返回false
		if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || word.charAt(index) != board[i][j]) {
			return false;
		}

		// 匹配到最后一个字母并且相等 则返回true
		if(index == word.length()-1) {
			return true;
		}

		char temp = board[i][j];

//		board[i][j] = '$';
		// 异或运算  a ^ a = 0   a ^ 0 = a
		// 所以 b ^ a ^ a = b
		// ASCII 码值的范围是 0 - 127
		board[i][j] ^= 128;

		// 上下左右搜索
		if(dfs(i-1, j, board , index+1, word) || dfs(i+1, j, board, index+1, word)
				|| dfs(i, j-1, board, index+1, word) || dfs(i, j+1, board, index+1, word)) {
			return true;
		}

//		board[i][j] = temp;
		board[i][j] ^= 128;

		return false;
	}
}
