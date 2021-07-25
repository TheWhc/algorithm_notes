package CodeTop;

/**
 * @ClassName: _48_旋转图像
 * @Author: whc
 * @Date: 2021/07/25/0:46
 */
public class _48_旋转图像 {

	public  void rotate(int[][] matrix){

		// 主对角线翻转, (x,y) -> (y,x)
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// 左右翻转
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[0].length - j - 1];
				matrix[i][matrix[0].length - j - 1] = temp;
			}
		}
	}
}
