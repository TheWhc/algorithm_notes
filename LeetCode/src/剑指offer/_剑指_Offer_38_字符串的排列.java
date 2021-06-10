package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _剑指_Offer_38_字符串的排列
 * @Author: whc
 * @Date: 2021/05/30/12:32
 */
public class _剑指_Offer_38_字符串的排列 {

	/**
	 * 思路: 全排列重复元素问题(回溯 + 排序 + 剪枝)
	 *
	 * 1. 对s字符串转化为数组后进行排序,比如aacb,排序后aabc
	 * 2. 对aabc进行排列
	 * 3. 设置布尔类型的used数组标记元素是否已被选择过
	 * 4. 同一树层中如果arr[i] == arr[i-1] && used[i-1] == false,则进行剪枝,因为同一树层已使用过
	 * 5. 如果同一树枝中没被使用过(used[i]=false]),则开始进行处理
	 * 	  设置当前元素used[i]=true并且加入到路径path中,接着递归进入下一层,最后进行回溯,则删除路径中当前元素,used[i]=false
	 */
	// 存放符合条件结果的集合
	List<String> res = new ArrayList<>();
	public String[] permutation(String s) {
		if(s == null || s.length() == 0) {
			return new String[0];
		}
		// 用来存放符合条件结果
		StringBuilder path = new StringBuilder();
		boolean[] used = new boolean[s.length()];
		char[] newS = s.toCharArray();
		Arrays.sort(newS);
		backtrack(newS, path, used);
		return res.toArray(new String[0]);
	}

	private void backtrack(char[] arr, StringBuilder path, boolean[] used) {
		if(path.length() == arr.length) {
			res.add(new String(path));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			// used[i-1] == false,说明同一树层nums[i-1]使用过
			if(i > 0 && arr[i] == arr[i-1] && !used[i-1]) {
				continue;
			}
			// 同一树枝s.chatAt(i)没使用过开始处理
			if(!used[i]) {
				used[i] = true;
				path.append(arr[i]);
				backtrack(arr, path, used);
				path.deleteCharAt(path.length() - 1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		String s = "bac";
		char[] newS = s.toCharArray();
		Arrays.sort(newS);
		System.out.println(String.valueOf(newS));
	}
}
