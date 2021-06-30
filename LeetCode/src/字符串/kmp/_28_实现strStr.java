package 字符串.kmp;

/**
 * @ClassName: _28_实现strStr
 * @Author: whc
 * @Date: 2021/06/30/9:41
 */
public class _28_实现strStr {

	/**
	 * 思路: KMP算法
	 *
	 * KMP思想: 当出现字符串不匹配时,可以记录一部分之前已经匹配的文本内容,利用这些信息避免从头再去做遍历
	 *
	 * 1. 构造前缀表, 即next数组
	 * 2. 使用next数组做匹配
	 *
	 * 例子: s : a a b a a b a a f a
	 *      t : a a b a a f
	 * next数组: 0 1 0 1 2 0
	 *
	 * 时间复杂度: O(m+n) n为原串的长度
	 * 空间: O(m)  m为匹配串的长度
	 */
	public int strStr(String haystack, String needle) {
		if(needle.length() == 0 || needle == null) {
			return 0;
		}

		// 构造next数组, 数组长度为匹配串的长度
		int[] next = new int[needle.length()];
		getNext(next, needle);

		// 使用next数组做匹配
		int j = 0;
		// i从0开始,遍历文本串
		for (int i = 0; i < haystack.length(); i++) {
			// s[i] != s[j], j就要从next数组找到下一个匹配的位置
			while(j > 0 && haystack.charAt(i) != needle.charAt(j)) {
				j = next[j-1];
			}

			// s[i] == s[j], j向后移动
			if(haystack.charAt(i) == needle.charAt(j)) {
				j++;
			}

			// j指向了模板串的末尾,说明完全匹配, 返回文本串出现模板串的第一个位置
			if(j == needle.length()) {
				return i - needle.length() + 1;
			}
		}

		return -1;
	}

	/**
	 * 构造前缀表,即next数组
	 *
	 * 1. 初始化
	 * 	  定义两个指针i,j,j指向前缀起始位置,i指向后缀起始位置
	 * 	  j = 0;
	 * 	  next[0] = j;
	 *
	 * 2. 处理前后缀不相同的情况
	 *    i从1开始遍历,进行s[i]和s[j]的比较
	 *    如果s[i] != s[j],  则将j进行向前回退, 找到j前一个元素在next数组里的值(next[j-1])
	 *
	 * 3. 处理前后缀相同的情况
	 * 	  如果s[i] == s[j], 即找到相同的前后缀, 将j进行+1, 然后赋值给next[i]
	 */
	private void getNext(int[] next, String s) {
		int j = 0;
		next[0] = 0;
		// 注意i从1开始
		for (int i = 1; i < s.length(); i++) {
			// 前后缀不相同
			// 注意这里是循环
			while(j > 0 && s.charAt(i) != s.charAt(j)) {
				j = next[j-1]; // 向前回退
			}
			// 找到相同的前后缀
			if(s.charAt(i) == s.charAt(j)) {
				j++;
			}
			next[i] = j; // 将j(前缀的长度)赋给next[i]
		}
	}
}
