package 字符串;

/**
 * @ClassName: _151_翻转字符串里的单词
 * @Author: whc
 * @Date: 2021/06/30/11:07
 */
public class _151_翻转字符串里的单词 {

	/**
	 * 思路: 调用api
	 * 1. trim()函数去除字符串s两端的空格
	 * 2. 对字符串s进行分割,以空格作为分隔符
	 * 3. 倒叙遍历字符串s,拼接到StringBuilder中
	 *    如果遇到空字符串,则跳过
	 */
	/*public String reverseWords(String s) {
		if(s == null || s.length() == 0) {
			return new String();
		}

		s = s.trim();

		String[] words = s.split(" ");
		StringBuilder res = new StringBuilder();
		for (int i = words.length-1; i >= 0; i--) {
			if(words[i].equals("")) {
				continue;
			}
			res.append(words[i] + " ");
		}

		res.deleteCharAt(res.length()-1);

		return res.toString();
	}*/

	/**
	 * 思路: 不调用api写法
	 * 1. 对字符串s进行整体翻转,比如"a good example" -> "elpmaxa doog a"
	 *
	 * 2. 对每个单词进行翻转, 比如"elpmaxa doog a" -> "example good a"
	 *
	 * 3. 去除多余的空格,返回新的字符串
	 * 		- 首先去除单词前面的空格
	 * 		- 然后把字符依次赋值
	 * 			words[i++] = words[j++]
	 * 		- 去除中间多余的空格
	 * 			j++
	 * 		- 中间空格只添加一个,尾部有多余的空格,则不添加(通过j < n控制不添加最后一个)
	 * 			words[i++] = ' '
	 *
	 */
	public String reverseWords(String s) {
		if(s == null || s.length() == 0) {
			return new String();
		}

		char[] words = s.toCharArray();
		// 对数组整体翻转
		// 比如"a good example" -> "elpmaxa doog a"
		reverse(words, 0, words.length-1);

		// 对单词进行翻转
		// 比如"elpmaxa doog a" -> "example good a"
		reverse_word(words);

		// 去除多余的空格
		return remove_space(words);
	}

	private String remove_space(char[] words) {
		int i = 0;
		int j = 0;
		int n = words.length;
		while(j < n) {
			// 去除首部空格
			while(j < n && words[j] == ' ') {
				j++;
			}

			// 移动字符位置
			while(j < n && words[j] != ' ') {
				words[i++] = words[j++];
			}

			// 去除中间多余的空格
			while(j < n && words[j] == ' ') {
				j++;
			}

			// 中间多余空格只加一个, 并且如果是尾部有多余空格的话,则不添加
			if(j < n) {
				words[i++] = ' ';
			}
		}

		return String.valueOf(words, 0, i);
	}

	private void reverse_word(char[] words) {
		int i = 0;
		int j = 0;
		int n = words.length;
		while(j < n) {
			// 找到第一个字母
			while(i < n && words[i] == ' ') {
				i++;
			}

			j = i;
			// 找到单词的末尾位置
			while(j < n && words[j] != ' ') {
				j++;
			}
			reverse(words, i, j-1);
			i = j;
		}
	}

	private void reverse(char[] words, int i, int j) {
		while(i < j) {
			char temp = words[i];
			words[i] = words[j];
			words[j] = temp;
			i++;
			j--;
		}
	}

}
