package bilibili;

import java.util.*;

/**
 * @ClassName: _02_数组排成最小的数
 * @Author: whc
 * @Date: 2021/03/07/1:04
 */
public class _02_数组排成最小的数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		List<String> strs = new ArrayList<>();
		String[] nums = s.split(",");
		for (int i = 0; i < nums.length; i++) {
			strs.add(nums[i]);
		}
		// 按从小到大排序
		// 32,231
		// s1=32 s2=231
		// s1+s2(32231) > s2+s1(23132)
		Collections.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s1.compareTo(s2);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(str);
		}
		System.out.println(sb.toString());
	}
}
