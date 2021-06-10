package 剑指offer;

/**
 * @ClassName: _剑指_Offer_20_表示数值的字符串
 * @Author: whc
 * @Date: 2021/05/27/9:41
 */
public class _剑指_Offer_20_表示数值的字符串 {

	/**
	 * 思路: 判断否false而不是判断true,只要有一个条件不满足就可以判断false
	 *
	 * 1. 定义四个flag,对应四种字符
	 * 		- 是否有符号: hasSign
	 * 		- 是否有数字: hasNum
	 * 		- 是否有点: hasDot
	 * 		- 是否有e: hasE
	 * 	2. 还需要定义长度n和索引index
	 * 	3. 先处理开头空格,index后移
	 * 	4. 进入循环,遍历字符串
	 * 		- 当前字符c是'+'或'-': 如果已经出现过符号、出现过点、出现过数字,则返回false,否则,令hasSign = true
	 * 		- 当前字符c是数字: 令hasNum=true,一直移动index,直到出现非数字或者遍历到末尾,如果已遍历到末尾,返回true
	 * 		- 当前字符c是'.': 如果已经出现过'.'、出现过E(e),则返回false,否则,hasDot = true
	 * 		- 当前字符c是e或E: 如果已经出现e或者e之前没有出现过数字,则返回false,否则hasE = true,并将其它三个符号位设置为false,因为要开始遍历e后面的数字了
	 * 	5. 处理空格,index相应的后移
	 * 	6. 如果当前index与字符串长度相等,说明到达了末尾,还要满足hasNum为true才能最终返回true
	 *
	 *
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	public boolean isNumber(String s) {
		if(s == null || s.length() == 0) {
			return false;
		}
		boolean hasSign = false;
		boolean hasNum = false;
		boolean hasDot = false;
		boolean hasE = false;
		int index = 0;
		int n = s.length();

		// 先处理空格
		while(index < n && s.charAt(index) == ' ') {
			index++;
		}

		while(index < n) {
			// 当前字符c是数字
			while(index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
				index++;
				hasNum = true;
			}
			if(index == n) {
				break;
			}
			char c = s.charAt(index);
			// 当前字符c是'+'或'-'
			if(c == '+' || c == '-') {
				if(hasSign || hasDot || hasNum) {
					return false;
				}
				hasSign = true;
			} else if(c == '.') {
				// 当前字符c是'.'
				if(hasDot || hasE) {
					return false;
				}
				hasDot = true;
			} else if(c == 'e' || c == 'E') {
				// 当前字符是'e'或'E'
				if(hasE || !hasNum) {
					return false;
				}
				hasE = true;
				// 开始遍历e后面的新数字
				hasNum = false;
				hasDot = false;
				hasSign = false;
			} else if(c == ' ') {
				// 结束当前循环,继续判断循环外的情况
				break;
			} else {
				// 出现其它字符,返回false
				return false;
			}
			index++;
		}

		while(index < n && s.charAt(index) == ' ') {
			index++;
		}
		return index == n && hasNum;
	}

}
