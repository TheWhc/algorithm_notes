package 待分类;

/**
 * @ClassName: 待分类._151_翻转字符串里的单词
 * @Author: whc
 * @Date: 2021/03/21/12:09
 */
public class _151_翻转字符串里的单词 {

	// 分割法
	/*public static String reverseWords(String s) {
		s = s.trim();
		String[] array = s.split(" "); // 不建议使用
		StringBuffer sb = new StringBuffer();
		for (int i = array.length-1; i > 0; i--) {
			if(!array[i].equals("")) {
				sb.append(array[i]);
				sb.append(" ");
			}
		}
		sb.append(array[0]);
		return sb.toString();
	}*/

	// 双指针法
	public static String reverseWords(String s) {
		s = s.trim();
		int i = s.length()-1, j = i;
		StringBuffer res = new StringBuffer();
		while(i >= 0) {
			while(i >= 0 && s.charAt(i) != ' ') {
				i--;
			}
			res.append(s.substring(i+1, j+1) + " ");
			while(i >= 0 && s.charAt(i) == ' ') {
				i--;
			}
			j = i;
		}
		return res.toString().trim();
	}

	public static void main(String[] args) {
		reverseWords("a good   example");
	}

}
