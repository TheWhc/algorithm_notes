package top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: _438_找到字符串中所有字母异位词
 * @Author: whc
 * @Date: 2021/05/19/11:10
 */
public class _438_找到字符串中所有字母异位词 {

	/**
	 *  思路: 滑动窗口
	 *
	 *  步骤: 1.右移右指针,直到满足条件
	 *  			while(right < s.length()) {
	 *  			    if(在右移过程中检测到满足条件) {
	 *  			        对状态进行修改,好让程序后面检测到满足条件
	 *  			    }
	 *
	 *  			    right++
	 *  			}
	 *  	  2.右指针满足条件后,再移动左指针,直到不满足条件
	 *  	  		while(满足条件) {
	 *  	  		 	if(在左移过程中检测到不满足条件) {
	 *  	  		 	  	对状态进行修改,好让程序在后面检测到不满足条件
	 *  	  		 	}
	 *
	 *  	  		 	left++;
	 *  	  		}
	 *  	  3.重复1,2步骤
	 *
	 */
	public List<Integer> findAnagrams(String s, String p) {
		// 起始的时候,都位于0,同方向移动
		int left = 0;
		int right = 0;
		int start = 0;
		List<Integer> res = new ArrayList<>();
		// 比如 s="cbaebabacd"  p="abc"
		// 那么 window = {c:1, b:1, a:1}等
		HashMap<Character, Integer> window = new HashMap<>();
		HashMap<Character, Integer> needs = new HashMap<>();
		for (char c : p.toCharArray()) {
			// needs={a:1,b:1,c:1}
			needs.put(c, needs.getOrDefault(c, 0) + 1);
		}

		int match = 0;
		while(right < s.length()) {
			// 右移过程中检测到满足条件,对状态做修改,好让程序在后面检查到满足条件
			char c = s.charAt(right);
			if(needs.containsKey(c)) {
				window.put(c, window.getOrDefault(c, 0) + 1);
				// 如果出现window={b:2,a:2,c:1}时,此时c:1,则与needs中c:1相同时,match才加1
				if(window.get(c).equals(needs.get(c))) {
					match++;
				}
			} else {
				// 不满足条件,则清空window内容
				window = new HashMap<>();
				left = right+1;
				match = 0;
			}
			// 右边界右移1格
			right++;

			// 此时满足匹配条件,右移左指针,直到条件不满足
			while(match == needs.size()) {
				start = left;
				// 添加结果,只有窗口内容与needs内容完全相同时,才添加结果
				// 比如window = {c:1, b:1, a:1}  needs={a:1,b:1,c:1}
				if(window.equals(needs)) {
					res.add(start);
				}

				// 开始右移左指针
				char c1 = s.charAt(left);
				// window = {c:1, b:1, a:1}移除{c:1} 剩下{b:1,a:1}
				window.put(c1, window.get(c1)-1);
				// window = {b:2, a:2, c:1}移除{b}减少1 -> {b:1, a:2, c:1} 此时match不能减1
				if(window.get(c1) < needs.get(c1)) {
					match--;
				}

				// 左指针右移一格
				left++;
			}
		}

		return res;
	}
}
