package CodeTop;

/**
 * @ClassName: _151_翻转字符串里的单词
 * @Author: whc
 * @Date: 2021/07/22/14:09
 */
public class _151_翻转字符串里的单词 {

	/*public String reverseWords(String s) {
		if(s == null || s.length() == 0) {
			return "";
		}

		StringBuilder res = new StringBuilder();
		s = s.trim();
		String[] wordList = s.split(" ");
		for (int i = wordList.length-1; i > 0; i--) {
			if(wordList[i].equals("")) {
				continue;
			}
			res.append(wordList[i]);
		}
		res.append(wordList[0]);

		return res.toString();
	}*/

	public static void main(String[] args) {
		_151_翻转字符串里的单词 _151_翻转字符串里的单词 = new _151_翻转字符串里的单词();
		_151_翻转字符串里的单词.reverseWords("  hello world  ");
	}


	public String reverseWords(String s) {
		if(s == null || s.length() == 0) {
			return "";
		}

		char[] chars = s.toCharArray();
		// 整体进行翻转
		reverse(chars, 0, s.length()-1);
		System.out.println(String.valueOf(chars));

		// 对单词进行翻转
		reverseWord(chars, chars.length);
		System.out.println(String.valueOf(chars));

		// 去除首尾和中间多余空格,并返回结果
		return removeSpace(chars);
	}

	private String removeSpace(char[] chars) {
		int i = 0;
		int j = 0;
		int n = chars.length;
		while(j < n) {
			// 去除首部多余空格
			while(j < n && chars[j] == ' ') {
				j++;
			}
			// 开始单词赋值操作
			while(j < n && chars[j] != ' ') {
				chars[i++] = chars[j++];
			}

			// 去除中间多余空格
			while(j < n && chars[j] == ' ') {
				j++;
			}

			// 中间多余空格只赋值一个并且尾部不添加空格
			if(j < n) {
				chars[i++] = ' ';
			}
		}

		return String.valueOf(chars, 0, i);
	}

	private void reverseWord(char[] chars, int n) {
		int i = 0;
		int j = 0;
		while(j < n) {
			// 找到单词的第一个字母
			while(i < n && chars[i] == ' ') {
				i++;
			}
			j = i;
			// 找到单词的最后一个字母
			while(j < n && chars[j] != ' ') {
				j++;
			}
			// 对单词进行翻转
			reverse(chars, i, j-1);

			// 开始搜索下一个单词的起始位置
			i = j;
		}
	}

	private void reverse(char[] chars, int left, int right) {
		while(left < right) {
			char tmp = chars[left];
			chars[left] = chars[right];
			chars[right] = tmp;
			left++;
			right--;
		}
	}
}
