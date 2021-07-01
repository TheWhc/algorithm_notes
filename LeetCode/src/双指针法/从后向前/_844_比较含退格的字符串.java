package 双指针法.从后向前;

/**
 * @ClassName: _844_比较含退格的字符串
 * @Author: whc
 * @Date: 2021/07/01/14:14
 */
public class _844_比较含退格的字符串 {

	/**
	 * 思路: 双指针法(从后向前)
	 *
	 * 1. i指针指向s的末尾
	 * 	  不断移动i指针
	 * 	  	- 遇到'#',则sSkipNum++
	 * 	  	- 遇到非'#', 则判断sSkipNum是否大于0,大于0,则sSkipNum--,否则,结束循环去比对和j下标对应的字符
	 * 2. j指向指向t的末尾
	 * 	  不断移动j指针
	 * 	  	- 遇到'#',则tSkipNum++
	 * 	  	- 遇到非'#', 则判断tSkipNum是否大于0,大于0,则tSkipNum--,否则,结束循环去比对和i下标对应的字符
	 *
	 * 不断循环1,2步骤,直到i或者j其中一个指向-1， 或者i和j此时指向的字符不匹配直接返回false
	 *
	 * 3. 当i和j指针其中一个指向-1时,则结束1,2步骤的循环,再做进一步的判断
	 * 	  如果此时i和j同时指向-1,则两者同时遍历完毕,返回true, 否则返回false
	 */
	public boolean backspaceCompare(String s, String t) {
		int sSkipNum = 0; // 记录s的#数量
		int tSkipNum = 0; // 记录t的#数量

		int i = s.length()-1;
		int j = t.length()-1;
		while(true) {
			while(i >= 0) { // 从后向前,消除s的#
				if(s.charAt(i) == '#') {
					sSkipNum++;
				} else {
					if(sSkipNum > 0) {
						sSkipNum--;
					} else {
						break;
					}
				}
				i--;
			}

			while(j >= 0) { // 从后向前,消除t的#
				if(t.charAt(j) == '#') {
					tSkipNum++;
				} else {
					if(tSkipNum > 0) {
						tSkipNum--;
					} else {
						break;
					}
				}
				j--;
			}

			// 其中一个字符串遍历结束,结束循环
			if(i < 0 || j < 0) {
				break;
			}

			// 后半部分#消除完了,接下来比较s[i] != t[j]
			if(s.charAt(i) != t.charAt(j)) {
				return false;
			}

			// s[i] == t[j], 继续遍历前半部分的字符
			i--;
			j--;
		}

		// 说明s和t同时遍历完毕
		if(i == -1 && j == -1) {
			return true;
		}

		return false;
	}

}
