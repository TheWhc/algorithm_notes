package CodeTop;

/**
 * @ClassName: _79_单词搜索
 * @Author: whc
 * @Date: 2021/09/11/11:32
 */
public class _79_单词搜索 {

	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(dfs(board, word, i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(char[][] board, String word, int i, int j, int index) {
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length
		|| board[i][j] != word.charAt(index)) {
			return false;
		}

		// 匹配到最后一个且相等,返回true
		if(index == word.length()-1) {
			return true;
		}

		char temp = board[i][j];
		// 用特殊字符标记访问过的字符
		board[i][j] = '$';

		if(dfs(board, word, i-1, j, index+1) || dfs(board, word, i+1, j, index+1)
		|| dfs(board, word, i, j-1, index+1) || dfs(board, word, i, j+1, index+1)) {
			return true;
		}

		board[i][j] = temp;

		return false;
	}
}
