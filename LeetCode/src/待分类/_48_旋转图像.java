package 待分类;

/**
 * @ClassName: 待分类._48_旋转图像
 * @Author: whc
 * @Date: 2021/03/24/20:52
 */
public class _48_旋转图像 {
	public static void rotate(int[][] matrix){
		if(matrix.length == 0 || matrix.length != matrix[0].length) {
			return;
		}

		int len = matrix.length;
		// 从右上角到左下角进行翻转
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[len-1-j][len-1-i];
				matrix[len-1-j][len-1-i] = temp;
			}
		}

		// 水平中线上下翻转
		for (int i = 0; i < (len >> 1); i++) {
			for (int j = 0; j < len; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[len-1-i][j];
				matrix[len-1-i][j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
	}
}
