package cvte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: _02_子集
 * @Author: whc
 * @Date: 2021/10/01/10:00
 */
public class _02_子集 {

	static List<List<Integer>> res = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		permutate(n);
		System.out.println(res);
	}

	private static void permutate(int n) {
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		backtrack(nums, 0, new ArrayList<>());
	}

	private static void backtrack(int[] nums, int startIndex, List<Integer> path) {
		res.add(new ArrayList<>(path));

		if(startIndex >= nums.length) {
			return;
		}

		for (int i = startIndex; i < nums.length; i++) {
			path.add(nums[i]);
			backtrack(nums, i+1, path);
			path.remove(path.size()-1);
		}
	}
}
